package net.ghostrealms.elo;

import net.ghostrealms.elo.lib.Database;

import net.ghostrealms.elo.events.PlayerJoin;
import net.ghostrealms.elo.events.PlayerKillPlayer;
import net.ghostrealms.elo.events.PlayerLeave;

import org.bukkit.plugin.java.JavaPlugin;

public class PVPELO extends JavaPlugin {
  
  private Database database;
  
  @Override
  public void onEnable() {
    this.establishSQL();
  }
  
  @Override
  public void onDisable() {
    database.disconnect();
  }
  
  private void establishSQL() {
    String name = this.getConfig().getString("database.name");
    String user = this.getConfig().getString("database.user");
    String pass = this.getConfig().getString("database.pass");
    String host = this.getConfig().getString("database.host");
    int port = this.getConfig().getInt("database.port");
    
    database = new Database(name, host, user, pass, port);
    database.connect();
  }

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
