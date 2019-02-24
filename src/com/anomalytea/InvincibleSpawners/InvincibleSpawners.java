package com.anomalytea.InvincibleSpawners;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

    if (this.getConfig().getBoolean("check-for-updates")) checkForUpdate();
  }

  @Override
  public void onDisable() {

  }

  public void checkForUpdate() {
    String tag = "[" + this.getDescription().getName() + "] ";
    try {
      URL url = new URL("https://drive.google.com/uc?export=download&id=1MXpyzkFFwvqbfdBjV5IQDNUXDF2IlLIQ");
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String v = rd.readLine();
      rd.close();
      if (v.equals(this.getDescription().getVersion())) {
        System.out.println(tag + "Version is up-to-date.");
      } else {
        System.out.println(tag + "Updated version available: " + v);
      }
    } catch (IOException e) {
      System.out.println(tag + "An error occurred while checking for updates.");
    }
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
    if (!this.getConfig().isSet("check-for-updates")) {
      this.getConfig().set(
          "check-for-updates", this.getConfig().getDefaults().getBoolean("check-for-updates"));
      this.saveConfig();
    }

    msg.add("[" + this.getDescription().getName() + "] Config file loaded.");
    System.out.println(msg.get(msg.size() - 1));

    return msg;
  }

}
