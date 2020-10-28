package dev.alexzvn.among.events.session;

import dev.alexzvn.among.contract.game.RoomSession;
import dev.alexzvn.among.events.Event;

public class SessionCreated extends Event {

    protected String id;

    protected RoomSession session;

    public SessionCreated(String id, RoomSession session) {
        this.id = id;
        this.session = session;
    }


    public String getId() {
        return id;
    }

    public RoomSession getSession() {
        return session;
    }
}
