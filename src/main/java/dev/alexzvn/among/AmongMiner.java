package dev.alexzvn.among;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import dev.alexzvn.among.commands.AmongMinerCommand;
import dev.alexzvn.among.commands.Join;
import dev.alexzvn.among.commands.Leave;
import dev.alexzvn.among.game.session.SessionManager;
import dev.alexzvn.among.util.Plugin;
import dev.alexzvn.among.util.Util;

public class AmongMiner extends JavaPlugin {

    protected ProtocolManager protocolManager;


    @Override
    public void onEnable() {
        Util.writeInfoLog("Enable Among Miner");

        this.saveDefaultConfig();

        // Register protocol lib
        this.protocolManager = ProtocolLibrary.getProtocolManager();

        // Load static config
        new Plugin(this);

        this.registerCommand();
        this.registerListener();
    }

    @Override
    public void onDisable() {

        SessionManager.destroyAll();
    }

    protected void registerCommand() {
        this.getCommand("amongminer").setExecutor(new AmongMinerCommand());
        this.getCommand("join").setExecutor(new Join());
        this.getCommand("leave").setExecutor(new Leave());
    }

    protected void registerListener() {
        Listener[] listeners = {
            
        };

        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, this);
        }
    }
}
