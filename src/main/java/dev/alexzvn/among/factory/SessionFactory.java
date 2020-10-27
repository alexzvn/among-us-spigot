package dev.alexzvn.among.factory;

import org.bukkit.World;
import org.bukkit.entity.Player;

import dev.alexzvn.among.contract.Session;
import dev.alexzvn.among.session.SessionManager;
import dev.alexzvn.among.session.RoomSession;
import dev.alexzvn.among.util.Util;
import dev.alexzvn.among.util.WorldMap;

public class SessionFactory {
    public static Session create(World originMap, Player owner) {

        String id = generateId();

        Session session = new RoomSession(WorldMap.copy(originMap, id), owner, id);

        try {
            SessionManager.addSession(id, session);
        } catch (Exception e) {
            e.printStackTrace();
            
        }

        return session;
    }

    protected static String generateId() {

        return Integer.toString(Util.random_int(100000, 999999));
    }
}
