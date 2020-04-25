package essentials.feature;

import arc.Events;
import arc.struct.Array;
import arc.util.Time;
import essentials.core.player.PlayerData;
import essentials.internal.Bundle;
import essentials.internal.Log;
import mindustry.game.EventType;
import mindustry.game.Gamemode;
import mindustry.game.Rules;
import mindustry.game.Team;
import mindustry.gen.Call;
import mindustry.gen.Groups;
import mindustry.gen.Playerc;
import mindustry.io.SaveIO;
import mindustry.maps.Map;
import mindustry.net.Packets;

import java.util.Timer;
import java.util.TimerTask;

import static essentials.Main.*;
import static mindustry.Vars.*;

public class Vote {
    Timer timer = new Timer(true);

    Playerc player;
    Playerc target;
    String reason;
    Object parameters;
    VoteType type;
    Array<String> voted = new Array<>();

    boolean status = false;
    int require;
    int time = 0;
    int message_time = 0;
    TimerTask counting = new TimerTask() {
        @Override
        public void run() {
            time++;
            if (time >= 60) success();
        }
    };
    TimerTask alert = new TimerTask() {
        @Override
        public void run() {
            Thread.currentThread().setName("Vote alert timertask");
            String[] bundlename = {"vote.count.50", "vote.count.40", "vote.count.30", "vote.count.20", "vote.count.10"};

            if (message_time <= 4) {
                if (Groups.player.size() > 0) {
                    tool.sendMessageAll(bundlename[message_time]);
                }
                message_time++;
            }
        }
    };

    public int getRequire() {
        return require;
    }

    public void start(Playerc player, Playerc target, String reason) {
        this.player = player;
        this.target = target;
        this.reason = reason;
        this.type = VoteType.kick;

        Bundle bundle = new Bundle(playerDB.get(player.uuid()).locale);

        if (Groups.player.size() == 1) {
            player.sendMessage(bundle.get("vote.mininal"));
            return;
        } else if (Groups.player.size() <= 3) {
            require = 2;
        } else {
            require = (int) Math.ceil((double) Groups.player.size() / 2);
        }

        if (!status) {
            tool.sendMessageAll("vote.suggester-name", player.name());
            tool.sendMessageAll("vote.reason", reason);
            tool.sendMessageAll("vote.kick", player.name(), target.name());
            timer.scheduleAtFixedRate(counting, 0, 1000);
            timer.scheduleAtFixedRate(alert, 10000, 10000);
            status = true;
        } else {
            player.sendMessage(bundle.get("vote.in-processing"));
        }
    }

    public void start(VoteType type, Playerc player, Object... parameters) {
        this.player = player;
        this.type = type;
        this.parameters = parameters;

        Bundle bundle = new Bundle(playerDB.get(player.uuid()).locale);

        if (!status) {
            switch (type) {
                case gameover:
                    tool.sendMessageAll("vote.gameover");
                    break;
                case skipwave:
                    tool.sendMessageAll("vote.skipwave");
                    break;
                case rollback:
                    tool.sendMessageAll("vote.rollback");
                    break;
                case gamemode:
                    tool.sendMessageAll("vote-gamemode", ((Gamemode) parameters[0]).name());
                    break;
                default:
                    player.sendMessage(bundle.get("vote.wrong-mode"));
                    return;
            }
            status = true;
        } else {
            player.sendMessage(bundle.get("vote.in-processing"));
        }
    }

    public void start(Playerc player, Map map) {
        this.player = player;
        this.type = VoteType.map;

        Bundle bundle = new Bundle(playerDB.get(player.uuid()).locale);

        if (!status) {
            tool.sendMessageAll("vote.map");
            status = true;
        } else {
            player.sendMessage(bundle.get("vote.in-processing"));
        }
    }

    public void success() {
        status = false;
        timer.cancel();
        time = 0;
        message_time = 0;
        voted.clear();

        if (voted.size >= require) {
            switch (type) {
                case gameover:
                    tool.sendMessageAll("vote.gameover.done");
                    Events.fire(new EventType.GameOverEvent(Team.crux));
                    break;
                case skipwave:
                    tool.sendMessageAll("vote.skipwave.done");
                    for (int a = 0; a < (Integer) parameters; a++) {
                        logic.runWave();
                    }
                    break;
                case kick:
                    tool.sendMessageAll("vote.kick.done");
                    target.getInfo().lastKicked = Time.millis() + (30 * 60) * 1000;
                    Call.onKick(target.con(), Packets.KickReason.vote);
                    Log.write(Log.LogType.player, "log.player.kick");
                    break;
                case rollback:
                    tool.sendMessageAll("vote.rollback.done");
                    rollback.load();
                    break;
                case gamemode:
                    // TODO gamemode 투표 완성
                    SaveIO.save(saveDirectory.child("temp." + saveExtension));
                    Map map = state.map;
                    Rules rules = state.map.rules();

                    if (rules.attackMode) rules.attackMode = false;

                    world.loadMap(map, rules);
                    Gamemode.valueOf((String) parameters);
                    break;
                case map:
                    tool.sendMessageAll("vote.map.done");

                    Gamemode current = Gamemode.survival;
                    if (state.rules.attackMode) {
                        current = Gamemode.attack;
                    } else if (state.rules.pvp) {
                        current = Gamemode.pvp;
                    } else if (state.rules.editor) {
                        current = Gamemode.editor;
                    }
                    world.loadMap((Map) parameters, ((Map) parameters).applyRules(current));
                    Call.onWorldDataBegin();

                    for (Playerc p : Groups.player) {
                        netServer.sendWorldData(p);
                        p.reset();

                        if (state.rules.pvp) p.team(netServer.assignTeam(p, Groups.player));
                    }
                    Log.info("Map rollbacked.");
                    //tool.sendMessageAll("vote.map.done");
                    break;
            }
        } else {
            switch (type) {
                case gameover:
                    tool.sendMessageAll("vote.gameover.fail");
                    break;
                case skipwave:
                    tool.sendMessageAll("vote.skipwave.fail");
                    break;
                case kick:
                    tool.sendMessageAll("vote.kick.fail");
                    break;
                case rollback:
                    tool.sendMessageAll("vote.rollback.fail");
                    break;
                case map:
                    tool.sendMessageAll("vote.map.fail");
                    break;
            }
        }
    }

    public void interrupt() {
        timer.cancel();
        success();
    }

    public boolean status() {
        return status;
    }

    public Array<String> getVoted() {
        return voted;
    }

    public void set(String uuid) {
        voted.add(uuid);
        for (Playerc others : Groups.player) {
            PlayerData p = playerDB.get(others.uuid());
            if (!p.error)
                others.sendMessage(new Bundle(p.locale).get("vote.current-voted", voted.size, getRequire() - voted.size));
        }

        if (voted.size >= getRequire()) {
            timer.cancel();
            success();
        }
    }

    public enum VoteType {
        gameover, skipwave, kick, rollback, gamemode, map
    }
}
