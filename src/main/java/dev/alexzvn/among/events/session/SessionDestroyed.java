package dev.alexzvn.among.events.session;

import dev.alexzvn.among.contract.game.RoomSession;
import dev.alexzvn.among.events.Event;

public class SessionDestroyed extends Event {

    protected RoomSession session;

    public SessionDestroyed(RoomSession session) {
        this.session = session;
    }

    public String getId() {
        return session.getId();
    }

    public RoomSession getSession() {
        return session;
    }
}
