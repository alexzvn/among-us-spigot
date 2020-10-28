package dev.alexzvn.among.contract.game;

import java.util.List;

import org.bukkit.entity.Player;

import dev.alexzvn.among.contract.team.Crewmate;
import dev.alexzvn.among.game.GameConfig;

public interface GameSession {
    
    /**
     * Broadcast message to all player in this game session
     * @param message
     */
    public void broadcast(String message);

    /**
     * Broadcast message to player who already dead
     * @param message
     */
    public void broadcastToDeadPlayers(String message);

    public Crewmate getCrewmateByPlayer(Player player);

    public void disconnectCrewmate(Crewmate crewmate);

    public List<Crewmate> getCrewmates();

    public RoomSession getRoom();

    public GameConfig getConfig();
}
