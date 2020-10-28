package dev.alexzvn.among.listener.vanilla;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import dev.alexzvn.among.game.session.SessionManager;

public class PlayerDisconnectForward implements Listener {

    @EventHandler
    public void onDisconnect(PlayerQuitEvent event) {
        if (SessionManager.hasPlayer(event.getPlayer())) {
            SessionManager.disconnectPlayer(event.getPlayer());
            event.setQuitMessage(null);
        }
    }
}

