package me.ssg.epicpotter.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements CommandExecutor {

    private List<CommandHandler> commands = new ArrayList<CommandHandler>();

    public CommandManager() {
    }

    public CommandHandler getCommand(String name) {
        for(CommandHandler commandHandler : commands) {
            if (name.equals(commandHandler.getName())) {
                return commandHandler;
            }
        }

        return null;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] strings) {
        if (commandSender instanceof Player) {
            CommandHandler commandHandler = getCommand(label);

            if (commandHandler != null) {
                Player player = (Player) commandSender;

                if (commandHandler.hasPermission(player)) {
                    commandHandler.onExecute(player, strings);
                }
            }
        }

        return false;
    }
}
