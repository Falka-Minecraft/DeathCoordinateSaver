package com.Feshior.DeathCoordinate;

import com.Feshior.DeathCoordinate.events.PlayerEvents;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathCoordinate extends JavaPlugin {
    ConsoleCommandSender cms;
    private void sendMessage(String message, ChatColor c){
        if (cms == null) {
            cms = getServer().getConsoleSender();
        }
        cms.sendMessage(c + "[DeathCoordinate]: "+ message);
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerEvents(),this);
        sendMessage("Death plugin enabled!", ChatColor.GREEN);
    }
    @Override
    public void onDisable(){
        sendMessage("Plugin disabled!", ChatColor.RED);
    }


}
