package dev.alexzvn.among.contract.team;

import dev.alexzvn.among.contract.game.Task;

public interface Imposter {

    public void kill(NonImposter crewmate);

    public void vent();

    public void fakeTask(Task Task);

    public void sabotage();
}
