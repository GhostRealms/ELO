package net.ghostrealms.elo.events;

import net.ghostrealms.elo.util.PlayerTimeTracker;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Vtboy on 2/29/2016.
 */
public class PlayerLeave implements Listener{

    @EventHandler
    public void playerLeaveEvent(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        processLogout(player);
    }

    private void processLogout(Player player) {
        PlayerTimeTracker.playerLogout(player);
    }
}
