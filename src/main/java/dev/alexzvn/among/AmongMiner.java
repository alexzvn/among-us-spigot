package dev.alexzvn.among;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;

import org.bukkit.plugin.java.JavaPlugin;

import dev.alexzvn.among.commands.*;
import dev.alexzvn.among.session.SessionManager;
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

        //register command
        this.registerCommand();
    }

    @Override
    public void onDisable() {

        SessionManager.destroyAll();
    }

    protected void registerCommand() {
        this.getCommand("amongminer").setExecutor(new MainHandle());
        this.getCommand("join").setExecutor(new Join());
        this.getCommand("leave").setExecutor(new Leave());
    }
}
