package com.ttakkku.botcommand;

import com.ttakkku.brotherharass.setting;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.minecraft.server.v1_12_R1.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class version extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");
        if(args[0].equalsIgnoreCase(setting.prefix+"version")){
            if(!e.getMember().getUser().isBot()){
                e.getChannel().sendMessage( Bukkit.getBukkitVersion()).queue();
            }
        }
    }
    public double getPlayer(Player player){
        CraftPlayer pinga = (CraftPlayer) player;
        EntityPlayer pingb = pinga.getHandle();
        return pingb.ping;
    }
}
