package com.ttakkku.botcommand;

import com.ttakkku.brotherharass.setting;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.GuildVoiceState;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class address extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");
        if(args[0].equalsIgnoreCase(setting.prefix+"화공주소")){
            if(!e.getMember().getUser().isBot()){
                GuildVoiceState channel1 = e.getMember().getVoiceState();
                VoiceChannel voiceChannel = channel1.getChannel();

                e.getChannel().sendMessage(
                        new EmbedBuilder()
                                .setAuthor(e.getAuthor().getName(), null, e.getMember().getUser().getAvatarUrl())
                                .setColor(Color.RED)
                                .setDescription("https://canary.discordapp.com/channels/"  + e.getGuild().getId() +"/" + voiceChannel.getId())
                                .build()
                ).queue();
            }
        }
    }
}
