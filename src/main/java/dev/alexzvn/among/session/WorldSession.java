package dev.alexzvn.among.session;

import java.util.List;

import org.bukkit.World;
import org.bukkit.entity.Player;

import dev.alexzvn.among.contract.Session;

public class WorldSession implements Session {

    protected World world;

    protected Player owner;

    protected String id;

    protected List<Player> players;

    public WorldSession(World map, Player owner, String id) {
        this.world = map;
        this.id = id;
        this.setOwner(owner);
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public void kickPlayer(Player player) {
        players.removeIf(
            currentPlayer -> player.equals(currentPlayer)
        );
    }

    @Override
    public void setOwner(Player player) {
        this.owner = player;
    }

    @Override
    public boolean hasPlayer(Player player) {
        return players.contains(player);
    }

    @Override
    public boolean isOwner(Player player) {
        return player.equals(owner);
    }

    @Override
    public void destroy() {
        
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Player getOwner() {
        return this.owner;
    }

    @Override
    public World getMap() {
        return this.world;
    }

    @Override
    public String getId() {
        return id;
    }
}
