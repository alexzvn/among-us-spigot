package dev.alexzvn.among.session;

import java.util.HashMap;

import org.bukkit.entity.Player;

import dev.alexzvn.among.contract.Session;
import dev.alexzvn.among.events.session.SessionCreated;
import dev.alexzvn.among.events.session.SessionDestroyed;
import dev.alexzvn.among.events.session.SessionPlayerJoined;
import dev.alexzvn.among.events.session.SessionPlayerLeft;
import dev.alexzvn.among.util.Plugin;

public class SessionManager {
    
    protected static HashMap<String, Session> listSession = new HashMap<String, Session>();

    protected static HashMap<String, String> listPlayerSession = new HashMap<String, String>();

    public static void addSession(String id, Session session) throws Exception {
        if (hasSession(id)) {
            throw new Exception(
                "Session manager already have id:".concat(id)
            );
        }

        listSession.put(id, session);

        Plugin.dispatchEvent(new SessionCreated(id, session));
    }

    public static void addPlayer(Player player, String sessionId) {
        Session session = listSession.get(sessionId);

        session.addPlayer(player);

        listPlayerSession.put(player.getName(), sessionId);

        Plugin.dispatchEvent(new SessionPlayerJoined(player, session));
    }

    public static void disconnectPlayer(Player player, String sessionId) {
        Session session = listSession.get(sessionId);

        session.kickPlayer(player);

        listPlayerSession.remove(player.getName());

        Plugin.dispatchEvent(new SessionPlayerLeft(player, session));
    }

    public static void destroy(String id) {
        Session session = listSession.get(id);

        listSession.remove(id);

        Plugin.dispatchEvent(new SessionDestroyed(session));

        session.destroy();
    }

    public static void destroyAll() {
        listSession.forEach(
            (id, session) -> { destroy(id); }
        );

        listSession.clear();
    }

    /**
     * You should check hasSession() first before call this
     * @param id
     * @return session
     */
    public static Session getSession(String id) {
        return listSession.get(id);
    }

    public static boolean hasPlayer(Player player) {
        return listPlayerSession.get(player.getName()) != null;
    }

    public static boolean hasSession(String id) {
        return listSession.containsKey(id);
    }
}
