package dev.alexzvn.among.factory;

import org.bukkit.World;
import org.bukkit.entity.Player;

import dev.alexzvn.among.contract.game.RoomSession;
import dev.alexzvn.among.game.session.Room;
import dev.alexzvn.among.game.session.SessionManager;
import dev.alexzvn.among.util.Util;
import dev.alexzvn.among.util.WorldMap;

public class SessionFactory {
    public static RoomSession create(World originMap, Player owner) {

        String id = generateId();

        RoomSession session = new Room(WorldMap.copy(originMap, id), owner, id);

        try {
            SessionManager.addSession(id, session);
            SessionManager.addPlayer(owner, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return session;
    }

    protected static String generateId() {

        return Integer.toString(Util.random_int(100000, 999999));
    }
}
