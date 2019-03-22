package com.ttakkku.listeners;

import com.ttakkku.brotherharass.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        //Title
        Main.getInstance().title.sendFullTitle(player, 20, 100, 20, "§a서버에 오신걸 ", "§a환영합니다");
    }


}
