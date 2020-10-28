package dev.alexzvn.among.listener.game.chat;

import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import dev.alexzvn.among.contract.team.Crewmate;
import dev.alexzvn.among.contract.team.Imposter;
import dev.alexzvn.among.events.game.chat.AsyncCrewmateChat;
import dev.alexzvn.among.util.Message;

public class HandleCrewmateChated implements Listener {

    @EventHandler
    public void onChat(AsyncCrewmateChat event) {
        List<Crewmate> recipients = event.getGame().getCrewmates();

        if (! event.getCrewmate().isAlive()) {
            recipients.removeIf(crewmate -> crewmate.isAlive());
        }

        recipients.forEach(crewmate -> {
            crewmate.getPlayer().sendMessage(
                BuildMessageForCrewmate(event.getCrewmate(), crewmate, event.getFormat())
            );
        });
    }

    protected String BuildMessageForCrewmate(Crewmate sender, Crewmate crewmate, String message) {

        if (sender instanceof Imposter && crewmate instanceof Imposter) {
            message = "&r[&l&4Imposter&r]".concat(message);
        }

        if (! sender.isAlive()) {
            message = "&r[$l&8DEAD&r]".concat(message);
        }

        return Message.color(message);
    }
}
