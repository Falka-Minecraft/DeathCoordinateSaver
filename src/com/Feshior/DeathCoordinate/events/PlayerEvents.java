package com.Feshior.DeathCoordinate.events;

import com.Feshior.DeathCoordinate.DeathCoordinate;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class PlayerEvents implements Listener {
    private Plugin plugin = DeathCoordinate.getPlugin(DeathCoordinate.class);
    @EventHandler
    public void onPlayerDeath (PlayerDeathEvent event){
        if(event.getEntity() instanceof Player){
            Player player = (Player)(event.getEntity());
            player.sendMessage(ChatColor.DARK_RED + "You dead!");
            player.sendMessage(ChatColor.RED + "Your last coordinates:");
            int x = (int) Math.round(player.getLocation().getX());
            int y = (int) Math.round(player.getLocation().getY());
            int z = (int) Math.round(player.getLocation().getZ());
            player.sendMessage( ChatColor.BLUE+""+ChatColor.BOLD+ "X: " + x + " Y: " + y + " Z: " + z);
            int lastId=0;
            while (plugin.getConfig().getString("Users." + player.getUniqueId()+".Death"+lastId)!=null){
                lastId++;
            }
            plugin.getConfig().set("Users." + player.getUniqueId()+".Death" + lastId + ".World",player.getWorld().getName());
            plugin.getConfig().set("Users." + player.getUniqueId()+".Death" + lastId + ".X",x);
            plugin.getConfig().set("Users." + player.getUniqueId()+".Death" + lastId + ".Y",y);
            plugin.getConfig().set("Users." + player.getUniqueId()+".Death" + lastId + ".Z",z);
            plugin.saveConfig();

        }
    }
}
