package net.ghostrealms.elo.util;

import net.ghostrealms.elo.lib.UUIDLib;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Vtboy on 2/29/2016.
 */
public class PlayerTimeTracker {
    private static final Map<UUID, Long[]> playerTimes = new HashMap<>();

    public static void playerLogin(Player player) {
        UUID uuid = UUIDLib.getID(player.getName());
        if (playerTimes.containsKey(uuid)) {
            Long[] timeStamps = playerTimes.get(uuid);
            timeStamps[0] = System.currentTimeMillis();
            playerTimes.replace(uuid, timeStamps);
        } else {
            Long[] timeStamps = new Long[]{System.currentTimeMillis(), 0L};
            playerTimes.put(uuid, timeStamps);
        }
    }

    public static void playerLogout(Player player) {
        UUID uuid = UUIDLib.getID(player.getName());
        if (playerTimes.containsKey(uuid)) {
            Long[] timeStamps = playerTimes.get(uuid);
            Long currentSessionStart = timeStamps[0];
            Long currentSessionTime = System.currentTimeMillis() - currentSessionStart;
            Long oldSessionsTime = timeStamps[1];
            Long newSessionTime = oldSessionsTime + currentSessionTime;
            timeStamps[0] = 0L;
            timeStamps[1] = newSessionTime;
            playerTimes.replace(uuid, timeStamps);
        }
    }

    public static long getTimeOnline(Player player) {
        UUID uuid = UUIDLib.getID(player.getName());
        if (playerTimes.containsKey(uuid)) {
            Long[] timeStamps = playerTimes.get(uuid);
            Long currentSessionStart = timeStamps[0];
            Long currentSessionTime = System.currentTimeMillis() - currentSessionStart;
            return currentSessionTime;
        }
        return -0L;
    }

}
