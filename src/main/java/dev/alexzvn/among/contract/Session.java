package dev.alexzvn.among.contract;

import java.util.List;

import org.bukkit.World;
import org.bukkit.entity.Player;

public interface Session {
    public List<Player> getPlayers();

    public void addPlayer(Player player);

    public void kickPlayer(Player player);

    public Player getOwner();

    public void setOwner(Player player);

    public boolean hasPlayer(Player player);

    public boolean isOwner(Player player);

    public World getMap();

    public String getId();

    public void destroy();
}
