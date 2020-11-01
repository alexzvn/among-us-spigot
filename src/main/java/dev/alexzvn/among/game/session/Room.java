package dev.alexzvn.among.game.session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import dev.alexzvn.among.contract.game.RoomSession;
import dev.alexzvn.among.contract.game.GameSession;
import dev.alexzvn.among.util.WorldMap;

public class Room implements RoomSession {

    protected World world;

    protected Player owner;

    protected String id;

    protected HashMap<String, Player> players = new HashMap<String, Player>();

    public Room(World map, Player owner, String id) {
        this.world = map;
        this.id = id;
        this.setOwner(owner);
    }

    @Override
    public void addPlayer(Player player) {
        players.put(player.getName(), player);
    }

    @Override
    public void kickPlayer(Player player) {
        players.remove(player.getName());
    }

    @Override
    public void setOwner(Player player) {
        this.owner = player;
    }

    @Override
    public boolean hasPlayer(Player player) {
        return players.get(player.getName()) != null;
    }

    @Override
    public boolean isOwner(Player player) {
        return player.equals(owner);
    }

    @Override
    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<Player>();

        for (Player player : this.players.values()) {
            players.add(player);
        }

        return players;
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

    @Override
    public void destroy() {
        for (Player player : players.values()) {
            WorldMap.telePlayerToLobby(player);
        }

        WorldMap.delete(this.world);
        this.world = null; // prevent to save world again?
    }

    @Override
    public Location getLobbyLocation() {
        return this.world.getSpawnLocation();
    }

    @Override
    public boolean isInGame() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void broadcast(String message) {
        for (Player player : players.values()) {
            player.sendMessage(message);
        }
    }

    @Override
    public GameSession getGameSession() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int countPlayers() {
        return players.size();
    }
}
