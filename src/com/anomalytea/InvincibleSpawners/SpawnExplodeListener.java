package com.anomalytea.InvincibleSpawners;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ListIterator;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class SpawnExplodeListener implements Listener {
  private InvincibleSpawners plugin;

  public SpawnExplodeListener(InvincibleSpawners plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onSpawnExplode(EntityExplodeEvent e) {
    ListIterator<Block> i =  e.blockList().listIterator();
    while(i.hasNext()) {
      Block b = i.next();
      if(b.getType().equals(Material.SPAWNER)) {
        i.remove();
        System.out.println("Spawner at x=" + b.getLocation().getBlockX()
            + " y=" + b.getLocation().getBlockY()
            + " z=" + b.getLocation().getBlockZ()
            + " was protected from being exploded.");
        System.out.println("Nearest player to explosion: "
            + getNearestPlayerName(e.getLocation()));
      }
    }
  }

  private String getNearestPlayerName(Location location) {
    Player nearestPlayer = null;
    double nearestDistance = -1;

    for (Player player : plugin.getServer().getOnlinePlayers()) {
      if (player.getLocation().getWorld().equals(location.getWorld())) {
        double distance = location.distance(player.getLocation());
        if (distance < nearestDistance || nearestDistance == -1) {
          nearestDistance = distance;
          nearestPlayer = player;
        }
      }
    }

    if (nearestDistance == -1) {
      return "UNKNOWN";
    }

    BigDecimal printDistance = new BigDecimal(nearestDistance);
    printDistance = printDistance.setScale(2, RoundingMode.HALF_UP);
    return nearestPlayer.getName()+ " (" + printDistance.doubleValue() + " m)";
  }

}
