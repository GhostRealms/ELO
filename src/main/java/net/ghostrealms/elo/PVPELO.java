package net.ghostrealms.elo;

import net.ghostrealms.elo.events.PlayerJoin;
import net.ghostrealms.elo.events.PlayerKillPlayer;
import net.ghostrealms.elo.events.PlayerLeave;

import org.bukkit.plugin.java.JavaPlugin;

public class PVPELO extends JavaPlugin {

    @Override
    public void onEnable() {
        //Event registry
        this.getServer().getPluginManager().registerEvents(new PlayerKillPlayer(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        //Command registry
    }

    @Override
    public void onDisable() {

    }

    private void setupDB(String host, String user, String pass, int port) {

    }

}
