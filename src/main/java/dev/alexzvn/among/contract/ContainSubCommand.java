package dev.alexzvn.among.contract;

import java.util.HashMap;

import org.bukkit.command.CommandExecutor;

public interface ContainSubCommand {

    public HashMap<String,CommandExecutor> getSubCommands();
}
