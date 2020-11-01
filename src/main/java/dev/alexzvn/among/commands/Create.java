package dev.alexzvn.among.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.alexzvn.among.factory.SessionFactory;
import dev.alexzvn.among.util.Message;

public class Create implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (! (sender instanceof Player)) {
            sender.sendMessage(
                Message.buildMessage("Can't run command on console")
            );

            return false;
        }

        Player player = (Player) sender;

        player.sendMessage(Message.buildMessage("Creating new session..."));

        SessionFactory.create(player.getWorld(), player);

        return true;
    }
    
}
