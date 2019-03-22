package com.ttakkku.brotherharass;

import com.ttakkku.bukkitcommand.hello;
import com.ttakkku.listeners.filecreate;
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
    public  filecreate f = new filecreate();
    @Override
    public void onEnable() {
        console.sendMessage(ChatColor.AQUA +"[Discord bot] Plugin enabled");
        getCommand("hello").setExecutor(new hello());
        new c05(this);
        f.CreateNewfile();
      /*  getServer().getPluginManager().registerEvents(new PlayerJoin(), this); */
    }

    @Override
    public void onDisable()
    {
        console.sendMessage(ChatColor.RED + "[Disocrd bot] Plugin disabled");
    }
   @Contract(pure = true)
   public static Main getInstance() {
        return instance;
    }
}
