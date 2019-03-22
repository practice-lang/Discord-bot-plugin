package com.ttakkku.brotherharass;

import com.ttakkku.bukkitcommand.hello;
import com.ttakkku.utils.Title;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Contract;
public class Main extends JavaPlugin  implements Listener {
    private static Main instance;
    public Title title = new Title();
    CommandSender console = getServer().getConsoleSender();
    @Override
    public void onEnable() {
        console.sendMessage(ChatColor.AQUA +"[BrotherHarass] Plugin enabled");
        getCommand("hello").setExecutor(new hello());
        new c05(this);
      /*  getServer().getPluginManager().registerEvents(new PlayerJoin(), this); */
    }

    @Override
    public void onDisable()
    {
        console.sendMessage(ChatColor.RED + "[BrotherHarass] Plugin disabled");
    }
   @Contract(pure = true)
   public static Main getInstance() {
        return instance;
    }
}
