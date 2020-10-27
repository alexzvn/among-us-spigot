package dev.alexzvn.among.events.session;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import dev.alexzvn.among.contract.Session;

public class SessionDestroyed extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    protected Session session;

    public SessionDestroyed(Session session) {
        this.session = session;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public String getId() {
        return session.getId();
    }

    public Session getSession() {
        return session;
    }
}
