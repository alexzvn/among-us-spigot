package dev.alexzvn.among.listener.vanilla;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import dev.alexzvn.among.contract.game.RoomSession;
import dev.alexzvn.among.contract.team.Crewmate;
import dev.alexzvn.among.events.game.chat.AsyncCrewmateChat;
import dev.alexzvn.among.game.session.SessionManager;
import dev.alexzvn.among.util.Plugin;

public class PlayerChatForward implements Listener {
    
    @EventHandler
    public void playerChat(AsyncPlayerChatEvent event) {

        if (! SessionManager.hasPlayer(event.getPlayer())) {
            this.forwardChatPlayer(event); return;
        };

        forwardChatGameSession(
            SessionManager.getSessionByPlayer(event.getPlayer()), event
        );
    }

    /**
     * Remove player in session and send message to them
     * @param event
     */
    public void forwardChatPlayer(AsyncPlayerChatEvent event) {
        event.getRecipients()
            .removeIf(
                player -> SessionManager.hasPlayer(player)
            );
    }

    public void forwardChatGameSession(RoomSession room, AsyncPlayerChatEvent originEvent) {
        if (! room.isInGame()) {
            room.broadcast(originEvent.getMessage()); return;
        }

        Crewmate crewmate = room.getGameSession()
            .getCrewmateByPlayer(originEvent.getPlayer());

        Plugin.dispatchEvent(
            new AsyncCrewmateChat(crewmate, originEvent)
        );
    }
}
