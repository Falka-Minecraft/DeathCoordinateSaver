package com.Feshior.DeathCoordinate.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerEvents implements Listener {
    @EventHandler
    public void onPlayerDeath (PlayerDeathEvent event){
        if(event.getEntity() instanceof Player){
            Player player = (Player)(event.getEntity());
            player.sendMessage(ChatColor.DARK_RED + "You dead!");
            player.sendMessage(ChatColor.RED + "Your last coordinates:");
            player.sendMessage( ChatColor.BLUE+""+ChatColor.BOLD+ "X: " + Math.round(player.getLocation().getX()) + " Y: " + Math.round(player.getLocation().getY()) + " Z: " + Math.round(player.getLocation().getZ()));
        }
    }
}
