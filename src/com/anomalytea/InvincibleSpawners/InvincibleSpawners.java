package com.anomalytea.InvincibleSpawners;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class InvincibleSpawners extends JavaPlugin {

  @Override
  public void onEnable() {
    saveDefaultConfig();
    loadConfig();

    getServer().getPluginManager().registerEvents(new SpawnBreakListener(this), this);
    getServer().getPluginManager().registerEvents(new SpawnExplodeListener(this), this);
  }

  @Override
  public void onDisable() {

  }

  public ArrayList<String> loadConfig() {
    ArrayList<String> msg = new ArrayList<>();

    this.reloadConfig();

    msg.add("[" + this.getDescription().getName() + "] Config file loaded.");
    System.out.println(msg.get(msg.size() - 1));

    return msg;
  }

}
