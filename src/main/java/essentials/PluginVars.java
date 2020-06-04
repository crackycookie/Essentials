package essentials;

import arc.func.Boolf;
import arc.struct.Array;
import essentials.core.player.PlayerData;
import mindustry.entities.type.Player;

import static essentials.Main.tool;

public class PluginVars {
    private final int buildVersion = 104;
    private final int buildRevision = 6;
    private final int configVersion = 13;
    private String serverIP = tool.getHostIP();
    private String pluginVersion;
    private long uptime = 0L;
    private long playtime = 0L;
    private Array<PlayerData> playerData = new Array<>();
    private Array<Player> players = new Array<>();
    private boolean PvPPeace = false;

    public int buildVersion() {
        return buildVersion;
    }

    public int buildRevision() {
        return buildRevision;
    }

    public int configVersion() {
        return configVersion;
    }

    public String serverIP() {
        return serverIP;
    }

    public void serverIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public String pluginVersion() {
        return pluginVersion;
    }

    public void pluginVersion(String pluginVersion) {
        this.pluginVersion = pluginVersion;
    }

    public long uptime() {
        return uptime;
    }

    public void uptime(long uptime) {
        this.uptime = uptime;
    }

    public long playtime() {
        return playtime;
    }

    public void playtime(long playtime) {
        this.playtime = playtime;
    }

    public Array<PlayerData> playerData() {
        return playerData;
    }

    public void addPlayerData(PlayerData p) {
        playerData.add(p);
    }

    public void removePlayerData(Boolf<PlayerData> p) {
        playerData.remove(p);
    }

    public Array<Player> players() {
        return players;
    }

    public void addPlayers(Player player) {
        players.add(player);
    }

    public void removePlayers(Player player) {
        players.remove(player);
    }

    public void players(Array<Player> players) {
        this.players = players;
    }

    public boolean isPvPPeace() {
        return PvPPeace;
    }

    public void setPvPPeace(boolean pvpPeace) {
        PvPPeace = pvpPeace;
    }
}
