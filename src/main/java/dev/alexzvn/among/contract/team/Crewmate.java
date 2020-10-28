package dev.alexzvn.among.contract.team;

import org.bukkit.entity.Player;

import dev.alexzvn.among.contract.game.RoomSession;
import dev.alexzvn.among.contract.game.Task;

public interface Crewmate {

    public Player getPlayer();

    public RoomSession getSession();

    public void doTask(Task task);

    public void reportBody();

    public void callEmergency();

    public void setPlayerDead();

    public void setEmergencyMeetings(int emergencyMeetings);

    public boolean isAlive();
}
