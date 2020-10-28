package dev.alexzvn.among.game.player;

import org.bukkit.entity.Player;

import dev.alexzvn.among.contract.game.RoomSession;

public class NonImposter extends Crewmate implements dev.alexzvn.among.contract.team.NonImposter {

    public NonImposter(Player player, RoomSession session) {
        super(player, session);
    }
    
}
