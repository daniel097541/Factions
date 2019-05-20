package com.massivecraft.factions.beastfactions;

import com.massivecraft.factions.*;
import com.massivecraft.factions.iface.RelationParticipator;
import com.massivecraft.factions.struct.ChatMode;
import com.massivecraft.factions.struct.Relation;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.util.WarmUpUtil;
import com.massivecraft.factions.zcore.util.TL;
import info.beastsoftware.beastfactions.BeastFactions;
import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import mkremins.fanciful.FancyMessage;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class BFFPlayer implements FPlayer, RelationParticipator {


    private final IFPlayer beastFactionsPlayer;

    public BFFPlayer(IFPlayer beastFactionsPlayer) {
        this.beastFactionsPlayer = beastFactionsPlayer;
    }


    @Override
    public IFPlayer getBFFPlayer() {
        return beastFactionsPlayer;
    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

    @Override
    public Faction getFaction() {
        return Factions.getInstance().getFactionById(getFactionId());
    }

    @Override
    public String getFactionId() {
        return String.valueOf(getBFFPlayer().getFactionId());
    }

    @Override
    public boolean hasFaction() {
        return !getFactionId().equals("0");
    }

    @Override
    public void setFaction(Faction faction) {
        getBFFPlayer().setFactionId(Long.parseLong(faction.getId()));
    }

    @Override
    public boolean willAutoLeave() {
        return false;
    }

    @Override
    public void setAutoLeave(boolean autoLeave) {

    }

    @Override
    public long getLastFrostwalkerMessage() {
        return 0;
    }

    @Override
    public void setLastFrostwalkerMessage() {

    }

    @Override
    public void setMonitorJoins(boolean monitor) {

    }

    @Override
    public boolean isMonitoringJoins() {
        return false;
    }

    @Override
    public Role getRole() {
        return Role.getRole(getBFFPlayer().getRole());
    }

    @Override
    public void setRole(Role role) {

    }

    @Override
    public boolean shouldTakeFallDamage() {
        return false;
    }

    @Override
    public void setTakeFallDamage(boolean fallDamage) {

    }

    @Override
    public double getPowerBoost() {
        return 0;
    }

    @Override
    public void setPowerBoost(double powerBoost) {

    }

    @Override
    public Faction getAutoClaimFor() {
        return null;
    }

    @Override
    public void setAutoClaimFor(Faction faction) {

    }

    @Override
    public boolean isAutoSafeClaimEnabled() {
        return false;
    }

    @Override
    public void setIsAutoSafeClaimEnabled(boolean enabled) {

    }

    @Override
    public boolean isAutoWarClaimEnabled() {
        return false;
    }

    @Override
    public void setIsAutoWarClaimEnabled(boolean enabled) {

    }

    @Override
    public boolean isAdminBypassing() {
        return getBFFPlayer().isAdminBypassing();
    }

    @Override
    public boolean isVanished() {
        return false;
    }

    @Override
    public void setIsAdminBypassing(boolean val) {

        if(val)
            getBFFPlayer().startAdminBypassing();
        else
            getBFFPlayer().stopAdminBypassing();
    }

    @Override
    public void setChatMode(ChatMode chatMode) {
    }

    @Override
    public ChatMode getChatMode() {
        return null;
    }

    @Override
    public void setIgnoreAllianceChat(boolean ignore) {

    }

    @Override
    public boolean isIgnoreAllianceChat() {
        return false;
    }

    @Override
    public void setSpyingChat(boolean chatSpying) {

    }

    @Override
    public boolean isSpyingChat() {
        return false;
    }

    @Override
    public boolean showScoreboard() {
        return false;
    }

    @Override
    public void setShowScoreboard(boolean show) {

    }

    @Override
    public String getAccountId() {
        return null;
    }

    @Override
    public void resetFactionData(boolean doSpoutUpdate) {

    }

    @Override
    public void resetFactionData() {

    }

    @Override
    public long getLastLoginTime() {
        return 0;
    }

    @Override
    public void setLastLoginTime(long lastLoginTime) {

    }

    @Override
    public boolean isMapAutoUpdating() {
        return false;
    }

    @Override
    public void setMapAutoUpdating(boolean mapAutoUpdating) {

    }

    @Override
    public boolean hasLoginPvpDisabled() {
        return false;
    }

    @Override
    public FLocation getLastStoodAt() {
        return null;
    }

    @Override
    public void setLastStoodAt(FLocation flocation) {

    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public void setTitle(CommandSender sender, String title) {

    }

    @Override
    public String getName() {
        return getBFFPlayer().getName();
    }

    @Override
    public String getTag() {
        return getBFFPlayer().getFaction().getName();
    }

    @Override
    public String getNameAndSomething(String something) {
        return null;
    }

    @Override
    public String getNameAndTitle() {
        return null;
    }

    @Override
    public String getNameAndTag() {
        return null;
    }

    @Override
    public String getNameAndTitle(Faction faction) {
        return null;
    }

    @Override
    public String getNameAndTitle(FPlayer fplayer) {
        return null;
    }

    @Override
    public String getChatTag() {
        return null;
    }

    @Override
    public String getChatTag(Faction faction) {
        return null;
    }

    @Override
    public String getChatTag(FPlayer fplayer) {
        return null;
    }

    @Override
    public int getKills() {
        return 0;
    }

    @Override
    public int getDeaths() {
        return 0;
    }

    @Override
    public String describeTo(RelationParticipator that, boolean ucfirst) {
        return null;
    }

    @Override
    public String describeTo(RelationParticipator that) {
        return null;
    }

    @Override
    public Relation getRelationTo(RelationParticipator rp) {

        if(rp instanceof BFFaction){
            return ((BFFaction) rp).getRelationWish(this.getFaction());
        }

        return ((BFFPlayer) rp).getFaction().getRelationWish(this.getFaction());
    }

    @Override
    public Relation getRelationTo(RelationParticipator rp, boolean ignorePeaceful) {
        return null;
    }

    @Override
    public Relation getRelationToLocation() {

        Faction faction = Board.getInstance().getFactionAt(new FLocation(this.getPlayer().getLocation()));

        return faction.getRelationWish(this.getFaction());
    }

    @Override
    public ChatColor getColorTo(RelationParticipator rp) {
        return null;
    }

    @Override
    public void heal(int amnt) {

    }

    @Override
    public double getPower() {
        return getBFFPlayer().getPower();
    }

    @Override
    public void alterPower(double delta) {
        getBFFPlayer().setPower((int) delta);
    }

    @Override
    public double getPowerMax() {
        return getBFFPlayer().getMaxPower();
    }

    @Override
    public double getPowerMin() {
        return -getPowerMax();
    }

    @Override
    public int getPowerRounded() {
        return (int) getPower();
    }

    @Override
    public int getPowerMaxRounded() {
        return (int) getPowerMax();
    }

    @Override
    public int getPowerMinRounded() {
        return (int) getPowerMin();
    }

    @Override
    public void updatePower() {

    }

    @Override
    public void losePowerFromBeingOffline() {

    }

    @Override
    public void onDeath() {

    }

    @Override
    public boolean isInOwnTerritory() {
        return getBFFPlayer().isInOwnLand();
    }

    @Override
    public boolean isInOthersTerritory() {
        return !getBFFPlayer().isInOwnLand();
    }

    @Override
    public boolean isInAllyTerritory() {
        return getBFFPlayer().getFactionWhereIAm().getRelationWith(getFaction().getBFFaction()).getName().equalsIgnoreCase("ally");
    }

    @Override
    public boolean isInNeutralTerritory() {
        return getBFFPlayer().getFactionWhereIAm().getRelationWith(getFaction().getBFFaction()).getName().equalsIgnoreCase("neutral");
    }

    @Override
    public boolean isInEnemyTerritory() {
        return getBFFPlayer().getFactionWhereIAm().getRelationWith(getFaction().getBFFaction()).getName().equalsIgnoreCase("enemy");
    }

    @Override
    public void sendFactionHereMessage(Faction from) {

    }

    @Override
    public void leave(boolean makePay) {

    }

    @Override
    public boolean canClaimForFaction(Faction forFaction) {
        return false;
    }

    @Override
    public boolean canClaimForFactionAtLocation(Faction forFaction, Location location, boolean notifyFailure) {
        return false;
    }

    @Override
    public boolean canClaimForFactionAtLocation(Faction forFaction, FLocation location, boolean notifyFailure) {
        return false;
    }

    @Override
    public boolean attemptClaim(Faction forFaction, Location location, boolean notifyFailure) {
        return false;
    }

    @Override
    public boolean attemptClaim(Faction forFaction, FLocation location, boolean notifyFailure) {
        return false;
    }

    @Override
    public void msg(String str, Object... args) {

    }

    @Override
    public void msg(TL translation, Object... args) {

    }

    @Override
    public String getId() {
        return getFactionId();
    }

    @Override
    public Player getPlayer() {
        return getBFFPlayer().getPlayer();
    }

    @Override
    public boolean isOnline() {
        return getBFFPlayer().isOnline();
    }

    @Override
    public void sendMessage(String message) {
        getBFFPlayer().sms(message);
    }

    @Override
    public void sendMessage(List<String> messages) {
        messages.parallelStream()
                .forEach(this::sendMessage);
    }

    @Override
    public void sendFancyMessage(FancyMessage message) {

    }

    @Override
    public void sendFancyMessage(List<FancyMessage> message) {

    }

    @Override
    public int getMapHeight() {
        return 0;
    }

    @Override
    public void setMapHeight(int height) {

    }

    @Override
    public boolean isOnlineAndVisibleTo(Player me) {
        return false;
    }

    @Override
    public void remove() {

    }

    @Override
    public boolean isOffline() {
        return !isOnline();
    }

    @Override
    public void setId(String id) {

    }

    @Override
    public boolean isFlying() {
        return getBFFPlayer().isFlying();
    }

    @Override
    public void setFlying(boolean fly) {
        getBFFPlayer().toggleFlight();
    }

    @Override
    public void setFlying(boolean fly, boolean damage) {

    }

    @Override
    public boolean isAutoFlying() {
        return false;
    }

    @Override
    public void setAutoFlying(boolean autoFly) {

    }

    @Override
    public boolean canFlyAtLocation() {
        return getBFFPlayer().canFlyInFaction(getBFFPlayer().getFactionWhereIAm());
    }

    @Override
    public boolean canFlyAtLocation(FLocation location) {
        return getBFFPlayer().canFlyInFaction(BeastFactions.getInstance().getInternalApi().getFactionAtLocation(location.getChunk().getBlock(0,0,0).getLocation()));
    }

    @Override
    public boolean isSeeingChunk() {
        return getBFFPlayer().isSeeingChunk();
    }

    @Override
    public void setSeeingChunk(boolean seeingChunk) {
        if(seeingChunk)
            getBFFPlayer().startSeeingChunk();
        else
            getBFFPlayer().stopSeeingChunk();
    }

    @Override
    public boolean getFlyTrailsState() {
        return false;
    }

    @Override
    public void setFlyTrailsState(boolean state) {

    }

    @Override
    public String getFlyTrailsEffect() {
        return null;
    }

    @Override
    public void setFlyTrailsEffect(String effect) {

    }

    @Override
    public boolean isWarmingUp() {
        return false;
    }

    @Override
    public WarmUpUtil.Warmup getWarmupType() {
        return null;
    }

    @Override
    public void addWarmup(WarmUpUtil.Warmup warmup, int taskId) {

    }

    @Override
    public void stopWarmup() {

    }

    @Override
    public void clearWarmup() {

    }
}
