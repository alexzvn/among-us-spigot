package dev.alexzvn.among.factory;

import org.bukkit.World;
import org.bukkit.entity.Player;

import dev.alexzvn.among.contract.Session;
import dev.alexzvn.among.events.SessionCreated;
import dev.alexzvn.among.session.SessionManager;
import dev.alexzvn.among.session.WorldSession;
import dev.alexzvn.among.util.Plugin;
import dev.alexzvn.among.util.Util;
import dev.alexzvn.among.util.WorldMap;

public class SessionFactory {
    public static Session create(World originMap, Player owner) {

        String id = generateId();

        Session session = new WorldSession(WorldMap.copy(originMap, id), owner, id);

        try {
            SessionManager.add(id, session);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Plugin.dispatchEvent(
            new SessionCreated(id, session)
        );

        return session;
    }

    protected static String generateId() {

        String id = "";

        do {
            id = Integer.toString(Util.random_int(100000, 999999));
        } while (! SessionManager.hasSession(id));

        return id;
    }
}
