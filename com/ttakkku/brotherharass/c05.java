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
            JDABuilder shardBuilder = new JDABuilder("NTM2NzI3NDY5MjAyNDcyOTYx.D2vIlA.B1Y_L8sIKHTG_B6wC5Tk-gwVUtM");
            for (int i = 0; i < 5; i++)
            {
                shardBuilder.useSharding(i, 5)
                        .build();
                System.out.println("[BrotherHarass]  [" + i + "/4] Shard on");
            }
            jda = new JDABuilder(AccountType.BOT).setToken("NTM2NzI3NDY5MjAyNDcyOTYx.D2vIlA.B1Y_L8sIKHTG_B6wC5Tk-gwVUtM").buildBlocking();
            jda.getPresence().setStatus(OnlineStatus.IDLE);
            jda.getPresence().setGame(Game.streaming("서시루 방송 보는 중", "https://www.twitch.tv/sirusiru1818"));
            addcommands();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
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
