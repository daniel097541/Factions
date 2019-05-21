package com.massivecraft.factions.beastfactions;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import info.beastsoftware.beastfactions.BeastFactions;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class BFFactions extends Factions {
    @Override
    public Faction getFactionById(String id) {
        try {
            return new BFFaction(BeastFactions.getInstance().getExternalAPI().getFaction(Long.parseLong(id)));
        }
        catch (Exception ignored){
            return null;
        }
    }

    @Override
    public Faction getByTag(String str) {
        return new BFFaction(BeastFactions.getInstance().getExternalAPI().getFaction(str));
    }

    @Override
    public Faction getBestTagMatch(String start) {
        return getAllFactions()
                .parallelStream()
                .filter(faction -> faction.getTag().startsWith(start))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean isTagTaken(String str) {
        return getByTag(str) != null;
    }

    @Override
    public boolean isValidFactionId(String id) {
        return getFactionById(id) == null;
    }

    @Override
    public Faction createFaction() {
        return null;
    }

    @Override
    public void removeFaction(String id) {

    }

    @Override
    public Set<String> getFactionTags() {
        return getAllFactions()
                .parallelStream()
                .map(Faction::getTag)
                .collect(Collectors.toSet());
    }

    @Override
    public ArrayList<Faction> getAllFactions() {
        return BeastFactions.getInstance().getInternalApi().getAllFactions()
                .parallelStream()
                .map(BFFaction::new).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Faction getNone() {
        return null;
    }

    @Override
    public Faction getWilderness() {
        return new BFFaction(BeastFactions.getInstance().getInternalApi().getFactionlessFaction());
    }

    @Override
    public Faction getSafeZone() {
        return new BFFaction(BeastFactions.getInstance().getInternalApi().getFactionFromName("safezone"));
    }

    @Override
    public Faction getWarZone() {
        return new BFFaction(BeastFactions.getInstance().getInternalApi().getFactionFromName("warzone"));
    }

    @Override
    public void forceSave() {

    }

    @Override
    public void forceSave(boolean sync) {

    }

    @Override
    public void load() {

    }
}
