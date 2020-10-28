package dev.alexzvn.among.events.game.chat;

import dev.alexzvn.among.events.Event;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import dev.alexzvn.among.contract.game.GameSession;
import dev.alexzvn.among.contract.game.RoomSession;
import dev.alexzvn.among.contract.team.Crewmate;


public class AsyncCrewmateChat extends Event {
    protected AsyncPlayerChatEvent originEvent;

    protected Crewmate crewmate;
    
    public AsyncCrewmateChat(Crewmate crewmate, AsyncPlayerChatEvent originEvent) {
        this.crewmate = crewmate;
        this.originEvent = originEvent;
    }

    public Crewmate getCrewmate() {
        return crewmate;
    }

    public GameSession getGame() {
        return crewmate.getSession().getGameSession();
    }

    public RoomSession getRoom() {
        return crewmate.getSession();
    }

    public String getMessage() {
        return originEvent.getMessage();
    }

    public String getFormat() {
        return originEvent.getFormat();
    }

    public AsyncPlayerChatEvent getOriginEvent() {
        return originEvent;
    }
}
