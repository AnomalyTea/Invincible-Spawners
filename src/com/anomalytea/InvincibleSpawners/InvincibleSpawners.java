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

    this.getCommand("invinciblespawners").setExecutor(new CommandHandler(this));
    this.getCommand("invinciblespawners").setTabCompleter(new TabComplete());
  }

  @Override
  public void onDisable() {

  }

  public ArrayList<String> loadConfig() {
    ArrayList<String> msg = new ArrayList<>();

    this.reloadConfig();

    if (!this.getConfig().isSet("creative-can-break")) {
      this.getConfig().set(
          "creative-can-break",
          this.getConfig().getDefaults().getBoolean("creative-can-break"));
      this.saveConfig();
    }

    msg.add("[" + this.getDescription().getName() + "] Config file loaded.");
    System.out.println(msg.get(msg.size() - 1));

    return msg;
  }

}
