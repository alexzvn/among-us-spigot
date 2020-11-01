package dev.alexzvn.among.listener.game;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import dev.alexzvn.among.events.session.SessionPlayerJoined;
import dev.alexzvn.among.util.Message;

public class SendPlayerToSessionMap implements Listener {
    
    @EventHandler
    public void onPlayerJoined(SessionPlayerJoined event) {

        event.getPlayer().sendMessage(
            Message.buildMessage("Teleport you to the map...")
        );

        event.getPlayer().teleport(
            event.getSession().getLobbyLocation()
        );
    }
}
