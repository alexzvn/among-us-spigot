package dev.alexzvn.among.events.session;

import org.bukkit.entity.Player;
import dev.alexzvn.among.events.Event;
import dev.alexzvn.among.contract.game.RoomSession;

public class SessionPlayerJoined extends Event {
    protected Player player;

    protected RoomSession session;

    public SessionPlayerJoined(Player player, RoomSession session) {
        this.player = player;
        this.session = session;
    }

    public String getId() {
        return session.getId();
    }

    public RoomSession getSession() {
        return session;
    }

    public Player getPlayer() {
        return player;
    }

    public Boolean isOwner() {
        return session.isOwner(player);
    }
}
