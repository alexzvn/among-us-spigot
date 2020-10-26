package dev.alexzvn.among.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import dev.alexzvn.among.util.Message;

public class MainHandle implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        sender.sendMessage(Message.buildMessage(label));
        
        sender.sendMessage(Message.buildMessage(args.toString()));

        return false;
    }
    
}
