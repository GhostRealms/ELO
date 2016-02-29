package net.ghostrealms.elo.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Created by Vtboy on 2/29/2016.
 */
public class PlayerKillPlayer implements Listener {

    @EventHandler
    public void PlayerKillEvent(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player Killer = (Player) e.getDamager();
            if (e.getEntityType() == EntityType.PLAYER) {
                Player Killed = (Player) e.getEntity();
                if (Killed.isDead() || Killed.getHealth() <= 0)
                    processDeath(Killed, Killer);
            }
        }
    }


    private void processDeath(Player Killed, Player Killer) {
        //TODO give points (or whatever) to killer and take points (or whatever) from killed
    }
}
