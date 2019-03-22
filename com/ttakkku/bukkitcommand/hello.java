package com.ttakkku.bukkitcommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class hello implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String labal, String[] args){
        if(sender instanceof Player){
            Player player = (Player) sender;
            player.sendMessage("§a ㅎㅇㅎㅇ");
        }
        return true;
    }
}
