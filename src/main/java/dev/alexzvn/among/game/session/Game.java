package dev.alexzvn.among.game.session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.entity.Player;

import dev.alexzvn.among.contract.game.RoomSession;
import dev.alexzvn.among.contract.game.Task;
import dev.alexzvn.among.contract.team.Crewmate;
import dev.alexzvn.among.factory.TaskFactory;
import dev.alexzvn.among.game.GameConfig;
import dev.alexzvn.among.game.player.Imposter;
import dev.alexzvn.among.game.player.NonImposter;

public class Game implements dev.alexzvn.among.contract.game.GameSession {

    protected GameConfig config;

    protected RoomSession session;

    protected List<Crewmate> crewmate = new ArrayList<Crewmate>();

    protected List<Task> tasks = new ArrayList<Task>();

    public Game(GameConfig config, RoomSession session, List<Player> players) {
        this.config = config;

        this.session = session;

        assignRoles(players);
        assignTasks();
    }

    public void eject(Crewmate crewmate) {

    }

    public void cleanDeadBody() {
        
    }

    public void meeting() {
        
    }

    private void assignRoles(List<Player> players) {
        Crewmate crewmate;

        Collections.shuffle(players);

        for (int i = 0; i < config.getMaximumImposters(players.size()); i++) {
            crewmate = new Imposter(players.remove(i), session);

            crewmate.setEmergencyMeetings(config.getEmergencyMeetings());

            this.crewmate.add(crewmate);
        }

        for (Player player : players) {
            crewmate = new NonImposter(player, session);

            crewmate.setEmergencyMeetings(config.getEmergencyMeetings());
            
            this.crewmate.add(crewmate);
        }
    }

    private void assignTasks() {

        this.crewmate.forEach(crewmate -> {
            if (crewmate instanceof NonImposter) {
                generateTasks(crewmate);
            }
        });
    }

    private void generateTasks(Crewmate crewmate) {

        for (int i = 0; i < config.getCommonTasks(); i++) {
            tasks.add(TaskFactory.createCommonTask(crewmate));
        }

        for (int i = 0; i < config.getShortTasks(); i++) {
            tasks.add(TaskFactory.createShortTask(crewmate));
        }

        for (int i = 0; i < config.getLongTasks(); i++) {
            tasks.add(TaskFactory.createLongTask(crewmate));
        }
    }

    @Override
    public void broadcast(String message) {
        for (Crewmate crewmate : this.crewmate) {
            crewmate.getPlayer().sendMessage(message);
        }

    }

    @Override
    public void broadcastToDeadPlayers(String message) {
        for (Crewmate crewmate : this.crewmate) {
            if (crewmate.isAlive()) {
                crewmate.getPlayer().sendMessage(message);
            }
        }
    }

    @Override
    public Crewmate getCrewmateByPlayer(Player player) {
        for (Crewmate crewmate : this.crewmate) {
            if (crewmate.getPlayer().getName().equals(player.getName())) {
                return crewmate;
            }
        }

        return null;
    }

    @Override
    public List<Crewmate> getCrewmates() {
        return crewmate;
    }

    @Override
    public void disconnectCrewmate(Crewmate crewmate) {
        this.crewmate.remove(crewmate);
    }

    @Override
    public RoomSession getRoom() {
        return session;
    }

    @Override
    public GameConfig getConfig() {
        return config;
    }
}
