package dev.alexzvn.among.events.session;

import org.bukkit.entity.Player;

import dev.alexzvn.among.contract.Session;

public class SessionPlayerLeft extends SessionEvent {

    protected Player player;

    protected Session session;

    public SessionPlayerLeft(Player player, Session session) {
        this.player = player;
        this.session = session;
    }

    public String getId() {
        return session.getId();
    }

    public Session getSession() {
        return session;
    }

    public Player getPlayer() {
        return player;
    }
}
