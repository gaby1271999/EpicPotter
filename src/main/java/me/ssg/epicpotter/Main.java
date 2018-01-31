package me.ssg.epicpotter;

import me.ssg.epicpotter.utils.Config;
import me.ssg.epicpotter.utils.MessageManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    private Config config, messages;

    public static MessageManager messageManager;

    public void onEnable() {
        config = new Config(this, "config", true);
        messages = new Config(this, "messages", true);

        messageManager = new MessageManager(messages);

        setupListeners(null);
    }

    public void setupListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, this);
        }
    }

    public Config getCustomConfig() {
        return config;
    }
}
