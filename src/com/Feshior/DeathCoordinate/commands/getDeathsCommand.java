package com.Feshior.DeathCoordinate.commands;

import com.Feshior.DeathCoordinate.DeathCoordinate;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.MemorySection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class getDeathsCommand implements CommandExecutor {
    private Plugin plugin = DeathCoordinate.getPlugin(DeathCoordinate.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player)sender;
            int lastId=0;
            while (plugin.getConfig().getString("Users." + player.getUniqueId()+".Death"+lastId)!=null){
                lastId++;
            }
            for(int i=0;i<lastId;i++){
                MemorySection ms = (MemorySection) plugin.getConfig().get("Users." + player.getUniqueId()+".Death" + i);
                String World_Name = ms.getString("World");
                if(Objects.equals(World_Name, "world")) {
                    World_Name = "Overworld";
                }
                else if(Objects.equals(World_Name, "world_nether")) {
                    World_Name = "Nether";
                }
                String x = ms.getString("X");
                String y = ms.getString("Y");
                String z = ms.getString("Z");
                player.sendMessage( ChatColor.AQUA + "" + i+ ". World: " + World_Name + "; X: " + x+ " Y: " + y + " Z: " + z);
            }
            if(lastId==0){
                player.sendMessage(ChatColor.LIGHT_PURPLE+"You didn't die");
            }
            return true;
        }
        return false;
    }
}
