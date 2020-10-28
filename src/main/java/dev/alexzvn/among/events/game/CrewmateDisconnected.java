package dev.alexzvn.among.events.game;

import dev.alexzvn.among.contract.game.GameSession;
import dev.alexzvn.among.contract.game.RoomSession;
import dev.alexzvn.among.contract.team.Crewmate;
import dev.alexzvn.among.events.Event;

public class CrewmateDisconnected extends Event {
    
    protected Crewmate crewmate;

    public CrewmateDisconnected(Crewmate crewmate) {
        this.crewmate = crewmate;
    }

    public Crewmate getCrewmate() {
        return crewmate;
    }

    public GameSession getGame() {
        return getRoom().getGameSession();
    }

    public RoomSession getRoom() {
        return crewmate.getSession();
    }
}
