package dev.alexzvn.among.game.player;

import org.bukkit.entity.Player;

import dev.alexzvn.among.contract.game.RoomSession;
import dev.alexzvn.among.contract.game.Task;
import dev.alexzvn.among.contract.team.NonImposter;

public class Imposter extends Crewmate implements dev.alexzvn.among.contract.team.Imposter {

    public Imposter(Player player, RoomSession session) {
        super(player, session);
    }

    @Override
    public void kill(NonImposter crewmate) {
        // TODO Auto-generated method stub
    }

    @Override
    public void vent() {
        // TODO Auto-generated method stub
    }

    @Override
    public void doTask(Task task) {
        // do nothing :D
    }

    @Override
    public void fakeTask(Task task) {
        this.doTask(task);
    }

    @Override
    public void sabotage() {
        // TODO Auto-generated method stub

    }
}
