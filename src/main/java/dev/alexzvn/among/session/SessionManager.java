package dev.alexzvn.among.session;

import java.util.HashMap;

import dev.alexzvn.among.contract.Session;

public class SessionManager {
    
    protected static HashMap<String, Session> listSession = new HashMap<String, Session>();

    public static void add(String id, Session session) throws Exception {
        if (hasSession(id)) {
            throw new Exception(
                "Session manager already have id:".concat(id)
            );
        }

        listSession.put(id, session);
    }

    public static void remove(String id) {
        listSession.get(id).destroy();
        listSession.remove(id);
    }

    public static void destroyAll() {
        listSession.forEach(
            (id, session) -> { session.destroy(); }
        );

        listSession.clear();
    }

    public static boolean hasSession(String id) {
        return listSession.containsKey(id);
    }
}
