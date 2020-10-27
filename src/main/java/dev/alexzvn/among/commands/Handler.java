package dev.alexzvn.among.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import dev.alexzvn.among.contract.ContainSubCommand;

abstract public class Handler implements CommandExecutor, ContainSubCommand {

    protected HashMap<String, CommandExecutor> subCommand;

    public Handler() {
        this.subCommand = this.getSubCommands();
    }

    protected boolean excuteSubCommand(CommandSender sender, Command command, String[] args) {

        String subCommand = shift(args);

        return this.subCommand.get(subCommand)
            .onCommand(sender, command, subCommand, getSubArgs(args));
    }

    protected boolean hasSubCommand(String[] args) {
        if (shift(args) == null) {
            return false;
        }

        return this.subCommand.containsKey(shift(args));
    }

    private String shift(String[] args) {

        if (args.length < 1) {
            return null;
        }

        return args[0];
    }

    private String[] getSubArgs(String[] args) {
        if (args.length < 2) {
            return new String[] {};
        }

        String[] newArgs = new String[args.length - 1];

        for (int i = 1; i < args.length; i++) {
            newArgs[i - 1] = args[i];
        }

        return newArgs;
    }

    abstract public HashMap<String, CommandExecutor> getSubCommands();
}
