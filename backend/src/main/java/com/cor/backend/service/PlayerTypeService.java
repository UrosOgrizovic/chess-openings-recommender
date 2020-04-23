package com.cor.backend.service;

import com.cor.backend.model.Player;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerTypeService {
    @Autowired
    private KieContainer kieContainer;

    public String fireDroolsRules(List<String> chosenMoves) {
        Player p = new Player();
        p.setChosenMoves(chosenMoves);
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.getAgenda().getAgendaGroup("player-type").setFocus();
        kieSession.insert(p);

        kieSession.fireAllRules();
        kieSession.dispose();
        return p.getPlayerType().name();

    }
}