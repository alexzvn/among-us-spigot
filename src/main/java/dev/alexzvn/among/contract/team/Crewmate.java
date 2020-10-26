package dev.alexzvn.among.contract.team;

import org.bukkit.entity.Player;

import dev.alexzvn.among.contract.Session;

public interface Crewmate {

    public Player getPlayer();

    public Session getSession();

    public void doTask();

    public void reportBody();

    public void callEmergency();
}
