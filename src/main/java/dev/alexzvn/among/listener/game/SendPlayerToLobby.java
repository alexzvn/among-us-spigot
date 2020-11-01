package dev.alexzvn.among.listener.game;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import dev.alexzvn.among.events.session.SessionPlayerLeft;
import dev.alexzvn.among.util.WorldMap;

public class SendPlayerToLobby implements Listener {
    
    @EventHandler
    public void onPlayerLeft(SessionPlayerLeft event) {
        WorldMap.telePlayerToLobby(event.getPlayer());
    }
}
