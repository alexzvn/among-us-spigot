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

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    public static FileConfiguration config() {
        return plugin.getConfig();
    }

    public static void dispatchEvent(Event event) {
        Bukkit.getPluginManager().callEvent(event);
    }

    public static void runAsync(Runnable task) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, task);
    }

    public static void runDelay(Runnable task, long delay) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, task, delay);
    }
}
