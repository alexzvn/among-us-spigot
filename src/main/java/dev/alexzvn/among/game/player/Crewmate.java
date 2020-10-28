package dev.alexzvn.among.game.player;

import org.bukkit.entity.Player;

import dev.alexzvn.among.contract.game.RoomSession;
import dev.alexzvn.among.contract.game.Task;

public class Crewmate implements dev.alexzvn.among.contract.team.Crewmate {

    protected Player player;

    protected RoomSession session;

    protected boolean alive = true;

    protected int emergencyMeetings = 0;

    public Crewmate(Player player, RoomSession session) {
        this.player = player;
        this.session = session;
    }

    @Override
    public void setEmergencyMeetings(int emergencyMeetings) {
        this.emergencyMeetings = emergencyMeetings;
    }

    @Override
    public Player getPlayer() {
       return player;
    }

    @Override
    public RoomSession getSession() {
        return session;
    }

    @Override
    public void doTask(Task task) {
        // TODO Auto-generated method stub

    }

    @Override
    public void reportBody() {
        // TODO Auto-generated method stub

    }

    @Override
    public void callEmergency() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void setPlayerDead() {
        

    }
}
