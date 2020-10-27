package dev.alexzvn.among.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import dev.alexzvn.among.util.Message;

public class AmongMinerCommand extends Handler {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (this.hasSubCommand(args)) {
            return this.excuteSubCommand(sender, command, args);
        }

        sender.sendMessage(
            Message.buildMessage("Invalid Command try /amongminer help to find what you need")
        );

        return false;
    }

    @Override
    public HashMap<String, CommandExecutor> getSubCommands() {
        HashMap<String, CommandExecutor> list = new HashMap<String, CommandExecutor>();

        list.put("create", new Create());
        list.put("join", new Join());
        list.put("leave", new Leave());

        return list;
    }
    
}
