package essentials.core.player;

import org.hjson.JsonObject;

import java.util.Locale;

import static essentials.Main.config;
import static essentials.Main.tool;

public class PlayerData {
    private String name;
    private String uuid;
    private String country;
    private String country_code;
    private String language;
    private boolean isAdmin;
    private int placecount;
    private int breakcount;
    private int killcount;
    private int deathcount;
    private int joincount;
    private int kickcount;
    private int level;
    private int exp;
    private int reqexp;
    private String reqtotalexp;
    private String firstdate;
    private String lastdate;
    private String lastplacename;
    private String lastbreakname;
    private String lastchat;
    private Long playtime;
    private int attackclear;
    private int pvpwincount;
    private int pvplosecount;
    private int pvpbreakout;
    private int reactorcount;
    private String bantimeset;
    private String bantime;
    private boolean banned;
    private boolean translate;
    private boolean crosschat;
    private boolean colornick;
    private boolean connected;
    private String connserver;
    private String permission;
    private boolean mute;
    private boolean alert;
    private Long udid = 0L;
    private String accountid;
    private String accountpw;

    private boolean error;
    private boolean isLogin;

    private Long afk = 0L;
    private int tilex = 0;
    private int tiley = 0;

    private Locale locale = config.language();

    public PlayerData() {
        this.error = true;
    }

    public PlayerData(String name, String uuid, String country, String country_code, String language, boolean isAdmin, int placecount, int breakcount, int killcount, int deathcount, int joincount, int kickcount, int level, int exp, int reqexp, String reqtotalexp, String firstdate, String lastdate, String lastplacename, String lastbreakname, String lastchat, Long playtime, int attackclear, int pvpwincount, int pvplosecount, int pvpbreakout, int reactorcount, String bantimeset, String bantime, boolean banned, boolean translate, boolean crosschat, boolean colornick, boolean connected, String connserver, String permission, boolean mute, boolean alert, Long udid, String accountid, String accountpw) {
        this.name = name;
        this.uuid = uuid;
        this.country = country;
        this.country_code = country_code;
        this.language = language;
        this.isAdmin = isAdmin;
        this.placecount = placecount;
        this.breakcount = breakcount;
        this.killcount = killcount;
        this.deathcount = deathcount;
        this.joincount = joincount;
        this.kickcount = kickcount;
        this.level = level;
        this.exp = exp;
        this.reqexp = reqexp;
        this.reqtotalexp = reqtotalexp;
        this.firstdate = firstdate;
        this.lastdate = lastdate;
        this.lastplacename = lastplacename;
        this.lastbreakname = lastbreakname;
        this.lastchat = lastchat;
        this.playtime = playtime;
        this.attackclear = attackclear;
        this.pvpwincount = pvpwincount;
        this.pvplosecount = pvplosecount;
        this.pvpbreakout = pvpbreakout;
        this.reactorcount = reactorcount;
        this.bantimeset = bantimeset;
        this.bantime = bantime;
        this.banned = banned;
        this.translate = translate;
        this.crosschat = crosschat;
        this.colornick = colornick;
        this.connected = connected;
        this.connserver = connserver;
        this.permission = permission;
        this.mute = mute;
        this.alert = alert;
        this.udid = udid;
        this.accountid = accountid;
        this.accountpw = accountpw;

        this.error = false;
        this.locale = tool.TextToLocale(country_code);
    }

    public void name(String name) {
        this.name = name;
    }

    public void uuid(String uuid) {
        this.uuid = uuid;
    }

    public void country(String country) {
        this.country = country;
    }

    public void country_code(String country_code) {
        this.country_code = country_code;
    }

    public void language(String language) {
        this.language = language;
    }

    public void isAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void placecount(int placecount) {
        this.placecount = placecount;
    }

    public void breakcount(int breakcount) {
        this.breakcount = breakcount;
    }

    public void killcount(int killcount) {
        this.killcount = killcount;
    }

    public void deathcount(int deathcount) {
        this.deathcount = deathcount;
    }

    public void joincount(int joincount) {
        this.joincount = joincount;
    }

    public void kickcount(int kickcount) {
        this.kickcount = kickcount;
    }

    public void level(int level) {
        this.level = level;
    }

    public void exp(int exp) {
        this.exp = exp;
    }

    public void reqexp(int reqexp) {
        this.reqexp = reqexp;
    }

    public void reqtotalexp(String reqtotalexp) {
        this.reqtotalexp = reqtotalexp;
    }

    public void firstdate(String firstdate) {
        this.firstdate = firstdate;
    }

    public void lastdate(String lastdate) {
        this.lastdate = lastdate;
    }

    public void lastplacename(String lastplacename) {
        this.lastplacename = lastplacename;
    }

    public void lastbreakname(String lastbreakname) {
        this.lastbreakname = lastbreakname;
    }

    public void lastchat(String lastchat) {
        this.lastchat = lastchat;
    }

    public void playtime(Long playtime) {
        this.playtime = playtime;
    }

    public void attackclear(int attackclear) {
        this.attackclear = attackclear;
    }

    public void pvpwincount(int pvpwincount) {
        this.pvpwincount = pvpwincount;
    }

    public void pvplosecount(int pvplosecount) {
        this.pvplosecount = pvplosecount;
    }

    public void pvpbreakout(int pvpbreakout) {
        this.pvpbreakout = pvpbreakout;
    }

    public void reactorcount(int reactorcount) {
        this.reactorcount = reactorcount;
    }

    public void bantimeset(String bantimeset) {
        this.bantimeset = bantimeset;
    }

    public void bantime(String bantime) {
        this.bantime = bantime;
    }

    public void banned(boolean banned) {
        this.banned = banned;
    }

    public void translate(boolean translate) {
        this.translate = translate;
    }

    public void crosschat(boolean crosschat) {
        this.crosschat = crosschat;
    }

    public void colornick(boolean colornick) {
        this.colornick = colornick;
    }

    public void connected(boolean connected) {
        this.connected = connected;
    }

    public void connserver(String connserver) {
        this.connserver = connserver;
    }

    public void permission(String permission) {
        this.permission = permission;
    }

    public void mute(boolean mute) {
        this.mute = mute;
    }

    public void alert(boolean alert) {
        this.alert = alert;
    }

    public void udid(Long udid) {
        this.udid = udid;
    }

    public void accountid(String accountid) {
        this.accountid = accountid;
    }

    public void accountpw(String accountpw) {
        this.accountpw = accountpw;
    }

    public void error(boolean error) {
        this.error = error;
    }

    public void login(boolean login) {
        isLogin = login;
    }

    public void afk(Long afk) {
        this.afk = afk;
    }

    public void tilex(int afk_tilex) {
        this.tilex = afk_tilex;
    }

    public void tiley(int afk_tiley) {
        this.tiley = afk_tiley;
    }

    public void locale(Locale locale) {
        this.locale = locale;
    }

    public String name() {
        return name;
    }

    public String uuid() {
        return uuid;
    }

    public String country() {
        return country;
    }

    public String country_code() {
        return country_code;
    }

    public String language() {
        return language;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public int placecount() {
        return placecount;
    }

    public int breakcount() {
        return breakcount;
    }

    public int killcount() {
        return killcount;
    }

    public int deathcount() {
        return deathcount;
    }

    public int joincount() {
        return joincount;
    }

    public int kickcount() {
        return kickcount;
    }

    public int level() {
        return level;
    }

    public int exp() {
        return exp;
    }

    public int reqexp() {
        return reqexp;
    }

    public String reqtotalexp() {
        return reqtotalexp;
    }

    public String firstdate() {
        return firstdate;
    }

    public String lastdate() {
        return lastdate;
    }

    public String lastplacename() {
        return lastplacename;
    }

    public String lastbreakname() {
        return lastbreakname;
    }

    public String lastchat() {
        return lastchat;
    }

    public Long playtime() {
        return playtime;
    }

    public int attackclear() {
        return attackclear;
    }

    public int pvpwincount() {
        return pvpwincount;
    }

    public int pvplosecount() {
        return pvplosecount;
    }

    public int pvpbreakout() {
        return pvpbreakout;
    }

    public int reactorcount() {
        return reactorcount;
    }

    public String bantimeset() {
        return bantimeset;
    }

    public String bantime() {
        return bantime;
    }

    public boolean banned() {
        return banned;
    }

    public boolean translate() {
        return translate;
    }

    public boolean crosschat() {
        return crosschat;
    }

    public boolean colornick() {
        return colornick;
    }

    public boolean connected() {
        return connected;
    }

    public String connserver() {
        return connserver;
    }

    public String permission() {
        return permission;
    }

    public boolean mute() {
        return mute;
    }

    public boolean alert() {
        return alert;
    }

    public Long udid() {
        return udid;
    }

    public String accountid() {
        return accountid;
    }

    public String accountpw() {
        return accountpw;
    }

    public boolean error() {
        return error;
    }

    public boolean login() {
        return isLogin;
    }

    public Long afk() {
        return afk;
    }

    public int tilex() {
        return tilex;
    }

    public int tiley() {
        return tiley;
    }

    public Locale locale() {
        return locale;
    }

    public JsonObject toMap() {
        JsonObject map = new JsonObject();
        map.add("name", name);
        map.add("uuid", uuid);
        map.add("country", country);
        map.add("country_code", country_code);
        map.add("language", language);
        map.add("isAdmin", isAdmin);
        map.add("placecount", placecount);
        map.add("breakcount", breakcount);
        map.add("killcount", killcount);
        map.add("deathcount", deathcount);
        map.add("joincount", joincount);
        map.add("kickcount", kickcount);
        map.add("level", level);
        map.add("exp", exp);
        map.add("reqexp", reqexp);
        map.add("reqtotalexp", reqtotalexp);
        map.add("firstdate", firstdate);
        map.add("lastdate", lastdate);
        map.add("lastplacename", lastplacename);
        map.add("lastbreakname", lastbreakname);
        map.add("lastchat", lastchat);
        map.add("playtime", playtime);
        map.add("attackclear", attackclear);
        map.add("pvpwincount", pvpwincount);
        map.add("pvplosecount", pvplosecount);
        map.add("pvpbreakout", pvpbreakout);
        map.add("reactorcount", reactorcount);
        map.add("bantimeset", bantimeset);
        map.add("bantime", bantime);
        map.add("banned", banned);
        map.add("translate", translate);
        map.add("crosschat", crosschat);
        map.add("colornick", colornick);
        map.add("connected", connected);
        map.add("connserver", connserver);
        map.add("permission", permission);
        map.add("mute", mute);
        map.add("alert", alert);
        map.add("udid", udid);
        map.add("accountid", accountid);
        map.add("accountpw", accountpw);
        return map;
    }

    public PlayerData toData(JsonObject data) {
        this.name = data.get("name").asString();
        this.uuid = data.get("uuid").asString();
        this.country = data.get("country").asString();
        this.country_code = data.get("country_code").asString();
        this.language = data.get("language").asString();
        this.isAdmin = data.get("isAdmin").asBoolean();
        this.placecount = data.get("placecount").asInt();
        this.breakcount = data.get("breakcount").asInt();
        this.killcount = data.get("killcount").asInt();
        this.deathcount = data.get("deathcount").asInt();
        this.joincount = data.get("joincount").asInt();
        this.kickcount = data.get("kickcount").asInt();
        this.level = data.get("level").asInt();
        this.exp = data.get("exp").asInt();
        this.reqexp = data.get("reqexp").asInt();
        this.reqtotalexp = data.get("reqtotalexp").asString();
        this.firstdate = data.get("firstdate").asString();
        this.lastdate = data.get("lastdate").asString();
        this.lastplacename = data.get("lastplacename").asString();
        this.lastbreakname = data.get("lastbreakname").asString();
        this.lastchat = data.get("lastchat").asString();
        this.playtime = data.get("playtime").asLong();
        this.attackclear = data.get("attackclear").asInt();
        this.pvpwincount = data.get("pvpwincount").asInt();
        this.pvplosecount = data.get("pvplosecount").asInt();
        this.pvpbreakout = data.get("pvpbreakout").asInt();
        this.reactorcount = data.get("reactorcount").asInt();
        this.bantimeset = data.get("bantimeset").asString();
        this.bantime = data.get("bantime").asString();
        this.banned = data.get("banned").asBoolean();
        this.translate = data.get("translate").asBoolean();
        this.crosschat = data.get("crosschat").asBoolean();
        this.colornick = data.get("colornick").asBoolean();
        this.connected = data.get("connected").asBoolean();
        this.connserver = data.get("connserver").asString();
        this.permission = data.get("permission").asString();
        this.mute = data.get("mute").asBoolean();
        this.alert = data.get("alert").asBoolean();
        this.udid = data.get("udid").asLong();
        this.accountid = data.get("accountid").asString();
        this.accountpw = data.get("accountpw").asString();
        return this;
    }
}
