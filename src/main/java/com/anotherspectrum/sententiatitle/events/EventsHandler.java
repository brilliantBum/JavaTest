package com.anotherspectrum.sententiatitle.events;

import com.anotherspectrum.sententiatitle.SententiaTitle;
import com.anotherspectrum.sententiatitle.title.TitleFile;
import io.papermc.paper.event.player.AsyncChatEvent;
import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventsHandler implements Listener {

    private @Getter SententiaTitle sententiaTitle;

    public EventsHandler(SententiaTitle sententiaTitle) {
        this.sententiaTitle = sententiaTitle;
        sententiaTitle.getServer().getPluginManager().registerEvents(this, sententiaTitle);

    }

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
//        new JoinEvents().onJoin(event);
        new TitleFile(event.getPlayer());
    }
    @EventHandler
    private void chat(AsyncChatEvent event) {
        new ChatEvent().chat(event);
    }
   /* @EventHandler
    private void onPlayerChat(AsyncPlayerChatEvent event) {
        new ChatEvent().onPlayerChat(event);
    }*/


}
