package com.cor.backend.service;

import com.cor.backend.model.*;
import com.cor.backend.model.dto.DeterminePlayerTypeDTO;
import com.cor.backend.model.dto.PlayerDTO;
import com.cor.backend.model.enums.PlayerDifficulty;
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

    @Autowired
    private ChessBookService chessBookService;

    @Autowired
    private ChessOpeningService chessOpeningService;

    @Autowired
    private ChessGameService chessGameService;

    public Recommended fireDroolsRulesMoves(DeterminePlayerTypeDTO determinePlayerTypeDTO) {

        Player p = new Player();
        PlayerDTO pdto = new PlayerDTO();
        p.setChosenMoveTypes(determinePlayerTypeDTO.getChosenMoveTypes());
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.getAgenda().getAgendaGroup("player-type").setFocus();
        kieSession.insert(p);
        kieSession.fireAllRules();

        pdto.setPlayerDifficulty(determinePlayerTypeDTO.getPlayerDifficulty());
        pdto.setPlayerType(p.getPlayerType());
        kieSession.getAgenda().getAgendaGroup("recommended-for-player-type").setFocus();
        kieSession.insert(pdto);

        List<ChessBook> allChessBooks = this.chessBookService.findAll();
        List<ChessOpening> allChessOpenings = this.chessOpeningService.findAll();
        List<ChessGame> allChessGames = this.chessGameService.findAll();

        kieSession.setGlobal("allChessBooks", allChessBooks);
        kieSession.setGlobal("allChessOpenings", allChessOpenings);
        kieSession.setGlobal("allChessGames", allChessGames);
        kieSession.insert(this.recommendedService);
        kieSession.insert(new Recommended());


        kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Player type: " + p.getPlayerType());

        return pdto.getRecommended();
    }

    public PlayerPreferences fireDroolsRulesAnswers(PlayerPreferences pp) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.getAgenda().getAgendaGroup("player-preferences").setFocus();
        kieSession.insert(pp);
        kieSession.fireAllRules();
        kieSession.dispose();
        return pp;
    }
}
