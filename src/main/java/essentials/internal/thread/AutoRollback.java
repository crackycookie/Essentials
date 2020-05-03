package essentials.internal.thread;

import arc.files.Fi;
import arc.struct.Array;
import essentials.internal.CrashReport;
import essentials.internal.Log;
import mindustry.Vars;
import mindustry.core.GameState;
import mindustry.entities.EntityGroup;
import mindustry.gen.Call;
import mindustry.gen.Groups;
import mindustry.gen.Playerc;
import mindustry.io.SaveIO;

import java.util.TimerTask;

import static essentials.Main.config;
import static mindustry.Vars.*;

public class AutoRollback extends TimerTask {
    public void save() {
        try {
            Fi file = saveDirectory.child(config.slownumber() + "." + saveExtension);
            if (state.is(GameState.State.playing)) SaveIO.save(file);
        } catch (Exception e) {
            new CrashReport(e);
        }
    }

    public void load() {
        EntityGroup<Playerc> all = Groups.player;
        Array<Playerc> players = new Array<>();
        players.addAll(all);

        try {
            Fi file = saveDirectory.child(config.slownumber() + "." + saveExtension);
            SaveIO.load(file);
        } catch (SaveIO.SaveException e) {
            new CrashReport(e);
        }

        Call.onWorldDataBegin();

        for (Playerc p : players) {
            Vars.netServer.sendWorldData(p);
            p.reset();

            if (Vars.state.rules.pvp) {
                p.team(Vars.netServer.assignTeam(p, new Array.ArrayIterable<>(players)));
            }
        }
        Log.info("Map rollbacked.");
        Call.sendMessage("[green]Map rollbacked.");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Essential Auto rollback thread");
        save();
    }
}
