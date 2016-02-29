package net.ghostrealms.elo.events;

import net.ghostrealms.elo.util.PlayerTimeTracker;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Vtboy on 2/29/2016.
 */
public class PlayerJoin implements Listener {
    
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        processLogin(player);
    }

    private void processLogin(Player player) {
        PlayerTimeTracker.playerLogin(player);
    }
}
