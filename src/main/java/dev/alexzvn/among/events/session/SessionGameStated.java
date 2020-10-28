package dev.alexzvn.among.events.session;

import java.util.List;

import dev.alexzvn.among.contract.game.GameSession;
import dev.alexzvn.among.contract.game.RoomSession;
import dev.alexzvn.among.contract.team.Crewmate;
import dev.alexzvn.among.events.Event;

public class SessionGameStated extends Event {

    protected GameSession game;

    public SessionGameStated(GameSession game) {
        this.game = game;
    }

    public GameSession getGame() {
        return game;
    }

    public RoomSession getRoom() {
        return game.getRoom();
    }

    public List<Crewmate> getCrewmates() {
        return game.getCrewmates();
    }
}
