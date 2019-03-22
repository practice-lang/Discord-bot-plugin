package com.ttakkku.logger;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class consolelogger extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.isFromType(ChannelType.PRIVATE))
        {
            System.out.printf("[Discord] [PM] " + event.getAuthor().getName() + ": "+ event.getMessage().getContentDisplay());
        }
        else
        {
            System.out.printf("[Discord] ["+event.getGuild().getName()+"] ["+event.getTextChannel().getName()+"] "+event.getMember().getEffectiveName()+": "+event.getMessage().getContentDisplay());
        }
    }
}
