package com.ttakkku.botcommand;

import com.ttakkku.brotherharass.setting;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class hello extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");
        if(args[0].equalsIgnoreCase(setting.prefix+"ㅎㅇ")){
            if(!e.getMember().getUser().isBot()){
                e.getChannel().sendMessage("ㅎㅇㅎㅇ").queue();
            }
        }
    }
}
