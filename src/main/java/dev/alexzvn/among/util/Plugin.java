package dev.alexzvn.among.util;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

import dev.alexzvn.among.AmongMiner;

public class Plugin {

    protected static JavaPlugin plugin;

    public Plugin(AmongMiner amongMiner) {
        plugin = amongMiner;
    }

    public static FileConfiguration config() {
        return plugin.getConfig();
    }

    public static void dispatchEvent(Event event) {
        Bukkit.getPluginManager().callEvent(event);
    }
}