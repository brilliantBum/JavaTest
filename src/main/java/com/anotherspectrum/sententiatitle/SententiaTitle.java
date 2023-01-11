package com.anotherspectrum.sententiatitle;

import co.aikar.commands.PaperCommandManager;
import com.anotherspectrum.anotherlibrary.AnotherLibrary;
import com.anotherspectrum.sententiatitle.commands.TitleCommands;
import com.anotherspectrum.sententiatitle.events.EventsHandler;
import com.anotherspectrum.sententiatitle.events.JoinEvents;
import com.anotherspectrum.sententiatitle.title.TitleFile;
import com.anotherspectrum.sententiatitle.title.TitleFileTett;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class SententiaTitle extends JavaPlugin {

    private @Getter AnotherLibrary anotherLibrary;

    private @Getter PaperCommandManager paperCommandManager;

    private @Getter TitleFileTett titleFileTett;

    @Override
    public void onEnable() {
        this.anotherLibrary = new AnotherLibrary("SententiaTitle", this);

        //Commands
        this.paperCommandManager = new PaperCommandManager(this);
        registerCommands();

        //Events
        getServer().getPluginManager().registerEvents(new JoinEvents(), this);
        new EventsHandler(this);

        //Files
        this.titleFileTett = new TitleFileTett();
    }

    private void registerCommands() {
        paperCommandManager.registerCommand(new TitleCommands(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
