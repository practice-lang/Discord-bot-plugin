package com.ttakkku.brotherharass;

import com.ttakkku.botcommand.*;
import com.ttakkku.logger.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import javax.security.auth.login.LoginException;
import java.io.*;


public class c05 extends ListenerAdapter implements Listener {
    public  Main plugin;
    public  JDA jda;
    public c05(Main main){
        this.plugin = main;
        startBot();
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
        jda.addEventListener(this);
    }

    private void startBot() {
        try {
                File filename = new File("plugins/Bot/token.txt");
                FileReader filereader = null;
                filereader = new FileReader(filename);
                BufferedReader bufReader = new BufferedReader(filereader);
                String line = "";
                while (true) {
                    if (!((line = bufReader.readLine()) != null)) break;
                    jda = new JDABuilder(AccountType.BOT).setToken(line).buildBlocking();
                }
                //  addcommands();
        } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jda.getPresence().setStatus(OnlineStatus.IDLE);
                jda.getPresence().setGame(Game.streaming("서시루 방송 보는 중", "https://www.twitch.tv/sirusiru1818"));
    }
    @EventHandler
    public void chatEvent (AsyncPlayerChatEvent event){
        String message = event.getMessage();
        //TextChannel textChannel = jda.getTextChannelsByName("1반", true).get(0);
        TextChannel textChannel = jda.getTextChannelById("555752946898567175");
        textChannel.sendMessage("**" + event.getPlayer().getName() + ":** " + message).queue();
    }
    /*
    @Override
       public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        if(e.getAuthor().isBot() || e.getAuthor().isFake() || e.isWebhookMessage()) return;
        String message = e.getMessage().getContentRaw();
        User user = e.getAuthor();
        Bukkit.broadcastMessage( user.getName() + "#" + user.getDiscriminator() + ": " + message);
    }
    */
    @EventHandler
    private void addcommands() {
        jda.addEventListener(new hello());
        jda.addEventListener(new consolelogger());
        jda.addEventListener(new version());
        jda.addEventListener(new address());
    }
}
