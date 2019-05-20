package com.massivecraft.factions.beastfactions;

import com.massivecraft.factions.*;
import info.beastsoftware.beastfactions.BeastFactions;
import mkremins.fanciful.FancyMessage;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.Set;

public class BFFBoard extends Board {




    @Override
    public String getIdAt(FLocation flocation) {
        return String.valueOf(BeastFactions.getInstance().getInternalApi().getFactionAtLocation(flocation.getLocation()));
    }

    @Override
    public Faction getFactionAt(FLocation flocation) {
        return new BFFaction(BeastFactions.getInstance().getInternalApi().getFactionAtLocation(flocation.getLocation()));
    }

    @Override
    public void setIdAt(String id, FLocation flocation) {

    }

    @Override
    public void setFactionAt(Faction faction, FLocation flocation) {

    }

    @Override
    public void removeAt(FLocation flocation) {

    }

    @Override
    public Set<FLocation> getAllClaims(String factionId) {
        return Factions.getInstance().getFactionById(factionId).getAllClaims();
    }

    @Override
    public Set<FLocation> getAllClaims(Faction faction) {
        return faction.getAllClaims();
    }

    @Override
    public void clearOwnershipAt(FLocation flocation) {

    }

    @Override
    public void unclaimAll(String factionId) {
        BeastFactions.getInstance().getInternalApi().getFactionFromId(Long.parseLong(factionId)).unclaimAllLand();
    }

    @Override
    public void unclaimAllInWorld(String factionId, World world) {
    }

    @Override
    public boolean isBorderLocation(FLocation flocation) {
        return false;
    }

    @Override
    public boolean isConnectedLocation(FLocation flocation, Faction faction) {
        return false;
    }

    @Override
    public boolean hasFactionWithin(FLocation flocation, Faction faction, int radius) {
        return false;
    }

    @Override
    public void clean() {

    }

    @Override
    public int getFactionCoordCount(String factionId) {
        return 0;
    }

    @Override
    public int getFactionCoordCount(Faction faction) {
        return 0;
    }

    @Override
    public int getFactionCoordCountInWorld(Faction faction, String worldName) {
        return 0;
    }

    @Override
    public ArrayList<FancyMessage> getMap(FPlayer fPlayer, FLocation flocation, double inDegrees) {
        return null;
    }

    @Override
    public void forceSave() {

    }

    @Override
    public void forceSave(boolean sync) {

    }

    @Override
    public boolean load() {
        return false;
    }
}
