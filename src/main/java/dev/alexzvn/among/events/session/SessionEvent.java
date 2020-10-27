package dev.alexzvn.among.events.session;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

abstract public class SessionEvent extends Event {

    protected static HandlerList HANDLERS = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
