package com.anomalytea.InvincibleSpawners;
import org.bukkit.plugin.java.JavaPlugin;

public class InvincibleSpawners extends JavaPlugin {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new SpawnBreakListener(), this);
		getServer().getPluginManager().registerEvents(new SpawnExplodeListener(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
}