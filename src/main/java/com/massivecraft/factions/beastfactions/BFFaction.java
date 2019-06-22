package com.massivecraft.factions.beastfactions;

import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.iface.RelationParticipator;
import com.massivecraft.factions.struct.BanInfo;
import com.massivecraft.factions.struct.Relation;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.util.LazyLocation;
import com.massivecraft.factions.zcore.fperms.Access;
import com.massivecraft.factions.zcore.fperms.Permissable;
import com.massivecraft.factions.zcore.fperms.PermissableAction;
import com.massivecraft.factions.zcore.util.TL;
import info.beastsoftware.beastfactions.BeastFactions;
import info.beastsoftware.beastfactions.factions.entity.IFPlayer;
import info.beastsoftware.beastfactions.factions.entity.IFaction;
import info.beastsoftware.beastfactions.factions.entity.IFactionRole;
import info.beastsoftware.beastfactions.factions.entity.impl.FactionsLocation;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class BFFaction implements Faction, RelationParticipator {


    private final IFaction faction;

    public BFFaction(IFaction faction) {
        this.faction = faction;
    }


    @Override
    public IFaction getBFFaction() {
        return faction;
    }

    @Override
    public HashMap<String, List<String>> getAnnouncements() {
        return null;
    }

    @Override
    public ConcurrentHashMap<String, LazyLocation> getWarps() {
        return null;
    }

    @Override
    public LazyLocation getWarp(String name) {
        return null;
    }

    @Override
    public void setWarp(String name, LazyLocation loc) {

    }

    @Override
    public boolean isWarp(String name) {
        return false;
    }

    @Override
    public boolean hasWarpPassword(String warp) {
        return false;
    }

    @Override
    public boolean isWarpPassword(String warp, String password) {
        return false;
    }

    @Override
    public void setWarpPassword(String warp, String password) {

    }

    @Override
    public boolean removeWarp(String name) {
        return false;
    }

    @Override
    public void clearWarps() {

    }

    @Override
    public int getMaxVaults() {
        return 0;
    }

    @Override
    public void setMaxVaults(int value) {

    }

    @Override
    public void addAnnouncement(FPlayer fPlayer, String msg) {

    }

    @Override
    public void sendUnreadAnnouncements(FPlayer fPlayer) {

    }

    @Override
    public void removeAnnouncements(FPlayer fPlayer) {

    }

    @Override
    public Set<String> getInvites() {
        return null;
    }

    @Override
    public String getId() {
        return String.valueOf(faction.getId());
    }

    @Override
    public void invite(FPlayer fplayer) {

    }

    @Override
    public void deinvite(FPlayer fplayer) {

    }

    @Override
    public boolean isInvited(FPlayer fplayer) {
        return false;
    }

    @Override
    public void ban(FPlayer target, FPlayer banner) {

    }

    @Override
    public void unban(FPlayer player) {

    }

    @Override
    public boolean isBanned(FPlayer player) {
        return false;
    }

    @Override
    public Set<BanInfo> getBannedPlayers() {
        return null;
    }

    @Override
    public boolean getOpen() {
        return false;
    }

    @Override
    public void setOpen(boolean isOpen) {

    }

    @Override
    public boolean isPeaceful() {
        return false;
    }

    @Override
    public void setPeaceful(boolean isPeaceful) {

    }

    @Override
    public void setPeacefulExplosionsEnabled(boolean val) {

    }

    @Override
    public boolean getPeacefulExplosionsEnabled() {
        return false;
    }

    @Override
    public boolean noExplosionsInTerritory() {
        return false;
    }

    @Override
    public boolean isPermanent() {
        return false;
    }

    @Override
    public void setPermanent(boolean isPermanent) {

    }

    @Override
    public String getTag() {
        return faction.getName();
    }

    @Override
    public String getTag(String prefix) {
        return null;
    }

    @Override
    public String getTag(Faction otherFaction) {
        return faction.getRelationWith(otherFaction.getBFFaction()).getColour() + getTag();
    }

    @Override
    public String getTag(FPlayer otherFplayer) {
        return getTag(otherFplayer.getFaction());
    }

    @Override
    public void setTag(String str) {
    }

    @Override
    public String getComparisonTag() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setDescription(String value) {

    }

    @Override
    public void setHome(Location home) {

    }

    @Override
    public boolean hasHome() {
        return false;
    }

    @Override
    public Location getHome() {
        return null;
    }

    @Override
    public long getFoundedDate() {
        return 0;
    }

    @Override
    public void setFoundedDate(long newDate) {

    }

    @Override
    public void confirmValidHome() {

    }

    @Override
    public String getAccountId() {
        return null;
    }

    @Override
    public Integer getPermanentPower() {
        return null;
    }

    @Override
    public void setPermanentPower(Integer permanentPower) {

    }

    @Override
    public boolean hasPermanentPower() {
        return false;
    }

    @Override
    public double getPowerBoost() {
        return 0;
    }

    @Override
    public void setPowerBoost(double powerBoost) {

    }

    @Override
    public boolean noPvPInTerritory() {
        return false;
    }

    @Override
    public boolean noMonstersInTerritory() {
        return false;
    }

    @Override
    public boolean isNormal() {
        return !isWilderness() && !isSafeZone() && !isWarZone();
    }

    @Override
    public boolean isNone() {
        return isWilderness();
    }

    @Override
    public boolean isWilderness() {
        return getBFFaction().isFactionless();
    }

    @Override
    public boolean isSafeZone() {
        return getBFFaction().getName().equalsIgnoreCase("safezone");
    }

    @Override
    public boolean isWarZone() {
        return getBFFaction().getName().equalsIgnoreCase("warzone");
    }

    @Override
    public boolean isPlayerFreeType() {
        return false;
    }

    @Override
    public boolean isPowerFrozen() {
        return false;
    }

    @Override
    public void setLastDeath(long time) {

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
    public Access getAccess(Permissable permissable, PermissableAction permissableAction) {
        return null;
    }

    @Override
    public Access getAccess(FPlayer player, PermissableAction permissableAction) {
        return null;
    }

    @Override
    public void setPermission(Permissable permissable, PermissableAction permissableAction, Access access) {

    }

    @Override
    public void resetPerms() {

    }

    @Override
    public Map<Permissable, Map<PermissableAction, Access>> getPermissions() {
        return null;
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

        if(rp instanceof BFFPlayer){
            BFFPlayer player = (BFFPlayer) rp;
            return getRelationWish(player.getFaction());
        }

        BFFaction faction = (BFFaction) rp;
        return getRelationWish(faction);
    }

    @Override
    public Relation getRelationTo(RelationParticipator rp, boolean ignorePeaceful) {
        return null;
    }

    @Override
    public ChatColor getColorTo(RelationParticipator rp) {
        return null;
    }

    @Override
    public Relation getRelationWish(Faction otherFaction) {
        return Relation.getRelation(otherFaction.getBFFaction().getRelationWith(this.getBFFaction()));
    }

    @Override
    public void setRelationWish(Faction otherFaction, Relation relation) {

    }

    @Override
    public int getRelationCount(Relation relation) {
        return 0;
    }

    @Override
    public double getPower() {
        return getBFFaction().getPower();
    }

    @Override
    public double getPowerMax() {
        return getBFFaction().getMaxPower();
    }

    @Override
    public int getPowerRounded() {
        return 0;
    }

    @Override
    public int getPowerMaxRounded() {
        return 0;
    }

    @Override
    public int getLandRounded() {
        return 0;
    }

    @Override
    public int getLandRoundedInWorld(String worldName) {
        return 0;
    }

    @Override
    public boolean hasLandInflation() {
        return getBFFaction().canBeOverClaimed();
    }

    @Override
    public void refreshFPlayers() {

    }

    @Override
    public boolean addFPlayer(FPlayer fplayer) {
        return false;
    }

    @Override
    public boolean removeFPlayer(FPlayer fplayer) {
        return false;
    }

    @Override
    public int getSize() {
        return getBFFaction().getSize();
    }

    @Override
    public Set<FPlayer> getFPlayers() {

        if(faction == null || faction.isDefaultFaction())
            return new HashSet<>();

        Set<FPlayer> players =  new HashSet<>();
        for(IFPlayer player : getBFFaction().getFPlayers())
            players.add(new BFFPlayer(player));

        return players;
    }

    @Override
    public Set<FPlayer> getFPlayersWhereOnline(boolean online) {
        return getFPlayers()
                .stream()
                .filter(FPlayer::isOnline)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<FPlayer> getFPlayersWhereOnline(boolean online, FPlayer viewer) {
        return getFPlayers()
                .stream()
                .filter(FPlayer::isOnline)
                .filter(player -> !player.equals(viewer))
                .collect(Collectors.toSet());    }

    @Override
    public FPlayer getFPlayerAdmin() {
        return new BFFPlayer(getBFFaction().getOwner());
    }

    @Override
    public ArrayList<FPlayer> getFPlayersWhereRole(Role role) {
        return getFPlayersWhereOnline(true)
                .stream()
                .filter(p -> p.getRole().equals(role))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public ArrayList<Player> getOnlinePlayers() {
        return getFPlayersWhereOnline(true)
                .stream()
                .map(FPlayer::getPlayer).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public boolean hasPlayersOnline() {
        return !getFPlayersWhereOnline(true).isEmpty();
    }

    @Override
    public void memberLoggedOff() {

    }

    @Override
    public void promoteNewLeader() {

    }

    @Override
    public Role getDefaultRole() {
        return null;
    }

    @Override
    public void setDefaultRole(Role role) {

    }

    @Override
    public void msg(String message, Object... args) {

    }

    @Override
    public void msg(TL translation, Object... args) {

    }

    @Override
    public void sendMessage(String message) {

    }

    @Override
    public void sendMessage(List<String> messages) {

    }

    @Override
    public Map<FLocation, Set<String>> getClaimOwnership() {
        return null;
    }

    @Override
    public void clearAllClaimOwnership() {

    }

    @Override
    public void clearClaimOwnership(FLocation loc) {

    }

    @Override
    public void clearClaimOwnership(FPlayer player) {

    }

    @Override
    public int getCountOfClaimsWithOwners() {
        return 0;
    }

    @Override
    public boolean doesLocationHaveOwnersSet(FLocation loc) {
        return false;
    }

    @Override
    public boolean isPlayerInOwnerList(FPlayer player, FLocation loc) {
        Set<String> list = getOwnerList(loc);

        if(list == null) return true;

        else
            return list.contains(player.getName()) || list.contains(player.getPlayer().getUniqueId().toString());
    }

    @Override
    public void setPlayerAsOwner(FPlayer player, FLocation loc) {

    }

    @Override
    public void removePlayerAsOwner(FPlayer player, FLocation loc) {

    }

    @Override
    public Set<String> getOwnerList(FLocation loc) {

        Set<String> list =
                getBFFaction()
                .getClaimAt(new FactionsLocation(loc.getLocation()))
                .getOwners()
                .stream()
                .map(IFPlayer::getName)
                .collect(Collectors.toSet());

        if(list.isEmpty()) return null;
        else
            return list;
    }

    @Override
    public String getOwnerListString(FLocation loc) {
        return getOwnerList(loc).toString();
    }

    @Override
    public boolean playerHasOwnershipRights(FPlayer fplayer, FLocation loc) {
        return false;
    }

    @Override
    public void remove() {

    }

    @Override
    public Set<FLocation> getAllClaims() {
        return getBFFaction().getALlClaims()
                .stream()
                .map(claim -> new FLocation(claim.getWorldName(), claim.getX(), claim.getZ()))
                .collect(Collectors.toSet());
    }

    @Override
    public void setId(String id) {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BFFaction faction1 = (BFFaction) o;
        return Objects.equals(faction, faction1.faction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faction);
    }
}
