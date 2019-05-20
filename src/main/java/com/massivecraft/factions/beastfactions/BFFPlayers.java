package com.massivecraft.factions.beastfactions;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import info.beastsoftware.beastfactions.BeastFactions;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class BFFPlayers extends FPlayers {

    @Override
    public void clean() {

    }

    @Override
    public Collection<FPlayer> getOnlinePlayers() {
        return BeastFactions.getInstance().getInternalApi().getAllOnlinePlayers()
                .parallelStream()
                .map(BFFPlayer::new)
                .collect(Collectors.toList());
    }

    @Override
    public FPlayer getByPlayer(Player player) {
        return new BFFPlayer(BeastFactions.getInstance().getInternalApi().getFPlayer(player));
    }

    @Override
    public Collection<FPlayer> getAllFPlayers() {
        return getOnlinePlayers();
    }

    @Override
    public void forceSave() {

    }

    @Override
    public void forceSave(boolean sync) {

    }

    @Override
    public FPlayer getByOfflinePlayer(OfflinePlayer player) {
        return new BFFPlayer(BeastFactions.getInstance().getInternalApi().getFPlayer(player.getUniqueId()));
    }

    @Override
    public FPlayer getById(String string) {
        return new BFFPlayer(BeastFactions.getInstance().getInternalApi().getFPlayer(UUID.fromString(string)));
    }

    @Override
    public void load() {

    }
}
