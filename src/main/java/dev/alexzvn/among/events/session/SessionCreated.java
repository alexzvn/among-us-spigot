package dev.alexzvn.among.events.session;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import dev.alexzvn.among.contract.Session;

public class SessionCreated extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    protected String id;

    protected Session session;

    public SessionCreated(String id, Session session) {
        this.id = id;
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
        return id;
    }

    public Session getSession() {
        return session;
    }
}
