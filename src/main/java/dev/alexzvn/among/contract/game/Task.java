package dev.alexzvn.among.contract.game;

import java.util.List;

import dev.alexzvn.among.contract.team.Crewmate;

public interface Task {

    public boolean hasSubTask();

    public boolean isDoing();

    public boolean isDone();

    public void visualize();

    public List<Task> getSubTask();

    public Crewmate getTaskOwner();

    /**
     * Determine if this can count total win for crewmate
     * @return
     */
    public boolean canCountForWin();
}
