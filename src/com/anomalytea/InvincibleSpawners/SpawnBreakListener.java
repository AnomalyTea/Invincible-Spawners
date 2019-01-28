package com.anomalytea.InvincibleSpawners;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class SpawnBreakListener implements Listener {

	@EventHandler
	public void onSpawnBreak(BlockBreakEvent e) {
		if ( e.getBlock().getType().equals(Material.SPAWNER) ) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.GREEN + "Spawners cannot be broken.");
			System.out.println("Spawner at x=" + String.valueOf(e.getBlock().getLocation().getBlockX())
				+ " y=" + String.valueOf(e.getBlock().getLocation().getBlockY()) 
				+ " z=" + String.valueOf(e.getBlock().getLocation().getBlockZ())
				+ " was protected from being broken by " + e.getPlayer().getName() + ".");
		}
	}
	
}
