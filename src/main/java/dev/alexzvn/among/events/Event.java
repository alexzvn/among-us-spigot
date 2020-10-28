package dev.alexzvn.among.events;

import org.bukkit.event.HandlerList;

abstract public class Event extends org.bukkit.event.Event {

    protected static HandlerList HANDLERS = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
