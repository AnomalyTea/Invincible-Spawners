package com.anomalytea.InvincibleSpawners;

import java.util.ListIterator;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class SpawnExplodeListener implements Listener {

	@EventHandler
	public void onSpawnExplode(EntityExplodeEvent e) {
		ListIterator<Block> i =  e.blockList().listIterator();
		while(i.hasNext()) {
			Block b = i.next();
			if(b.getType().equals(Material.SPAWNER)) {
				i.remove();
			}
		}
	}
	
}
