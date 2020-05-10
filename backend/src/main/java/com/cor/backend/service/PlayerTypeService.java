package com.cor.backend.service;

import com.cor.backend.model.Player;
import com.cor.backend.model.Recommended;
import com.cor.backend.model.dto.PlayerDTO;
import com.cor.backend.model.enums.PlayerType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerTypeService {
    @Autowired
    private KieContainer kieContainer;


    @Autowired
    private RecommendedService recommendedService;

    public Recommended fireDroolsRules(List<String> chosenMoveTypes) {

        Player p = new Player();
        PlayerDTO pdto = new PlayerDTO();
        p.setChosenMoveTypes(chosenMoveTypes);
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.getAgenda().getAgendaGroup("player-type").setFocus();
        kieSession.insert(p);
        kieSession.fireAllRules();

        pdto.setPlayerType(p.getPlayerType());
        kieSession.getAgenda().getAgendaGroup("recommended-for-player-type").setFocus();
        kieSession.insert(pdto);
        kieSession.insert(recommendedService);

        kieSession.fireAllRules();
        kieSession.dispose();

//        return p.getPlayerType().name();
        return pdto.getRecommended();
    }
}
