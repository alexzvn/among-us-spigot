package dev.alexzvn.among.listener.game;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import dev.alexzvn.among.contract.team.Crewmate;
import dev.alexzvn.among.contract.team.Imposter;
import dev.alexzvn.among.events.session.SessionGameStated;
import dev.alexzvn.among.util.Message;

public class SendFirstTitleToCrewmate implements Listener {

    @EventHandler
    public void onGameStarted(SessionGameStated event) {
        
        int imposter = 0;

        for (Crewmate crewmate : event.getCrewmates()) {
            if (crewmate instanceof Imposter) {
                imposter++;
            }
        }

        for (Crewmate crewmate : event.getCrewmates()) {
            if (crewmate instanceof Imposter) {
                sendWelcomeForImposter(crewmate);
            } else {
                sendWelcomeForNonImposter(crewmate, imposter);
            }
        }
    }

    private void sendWelcomeForNonImposter(Crewmate crewmate, int imposter) {
        Message.sendTitle(
            crewmate.getPlayer(),
            "Crewmate",
            "There is ".concat(Integer.toString(imposter)).concat(" Imposter among us")
        );
    }

    private void sendWelcomeForImposter(Crewmate crewmate) {
        Message.sendTitle(
            crewmate.getPlayer(),
            "Imposter",
            "New Mission: Kill them all"
        );
    }
}
