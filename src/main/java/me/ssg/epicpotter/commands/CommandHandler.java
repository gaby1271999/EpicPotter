package me.ssg.epicpotter.commands;


import me.ssg.epicpotter.Main;
import org.bukkit.entity.Player;

public abstract class CommandHandler {

    private String name, permission, descriptionPath;
    private String[] args;

    public CommandHandler(String name, String permission, String descriptionPath, String... args) {
        this.name = name;
        this.permission = permission;
        this.descriptionPath = descriptionPath;
        this.args = args;
    }

    public abstract void onExecute(Player player, String[] args);

    public void sentDescription(Player player) {
        Main.messageManager.sendConfigMessage(player, descriptionPath, false);
    }

    public boolean hasPermission(Player player) {
        if (player.hasPermission(permission)) {
            return true;
        }

        return false;
    }

    public String getName() {
        return name;
    }
}
