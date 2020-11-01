package dev.alexzvn.among.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.alexzvn.among.game.session.SessionManager;

public class Leave implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (! (sender instanceof Player)) {
            return false;
        }
       
        if (SessionManager.hasPlayer((Player) sender)) {
            SessionManager.disconnectPlayer((Player) sender);
        }

        return true;
    }
    
}
