package dev.alexzvn.among.contract.game;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public interface RoomSession {
    public List<Player> getPlayers();

    /**
     * Broadcast message to all player in this room session
     * @param message
     */
    public void broadcast(String message);

    public GameSession getGameSession();

    public void addPlayer(Player player);

    public void kickPlayer(Player player);

    public Player getOwner();

    public void setOwner(Player player);

    public boolean hasPlayer(Player player);

    public boolean isOwner(Player player);

    public boolean isInGame();

    public World getMap();

    public Location getLobbyLocation();

    public String getId();

    public void destroy();
}
