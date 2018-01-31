package me.ssg.epicpotter.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageManager {

    private Config messages;
    private String prefix;

    public MessageManager(Config messages) {
        this.messages = messages;

        prefix = messages.getConfig().getString("prefix");
    }

    public void sendConfigMessage(Player player, String path, boolean prefix) {
        player.sendMessage(toColor((prefix ? this.prefix : "") + messages.getConfig().getString(path)));
    }

    public String toColor(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
