package com.cor.backend.drools;

import com.cor.backend.model.ChessBook;
import com.cor.backend.model.ChessGame;
import com.cor.backend.model.ChessOpening;
import com.cor.backend.model.Recommended;
import com.cor.backend.model.dto.PlayerDTO;
import com.cor.backend.model.enums.PlayerDifficulty;
import com.cor.backend.model.enums.PlayerType;
import com.cor.backend.service.RecommendedService;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.drools.core.marshalling.impl.ProtobufMessages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecommendedForPlayerTypeUnitTest {
    @Autowired
    private KieContainer kieContainer;

    private KieSession kieSession;

    PlayerDTO pdto;

    @Autowired
    private RecommendedService recommendedService;

    @Before
    public void setUp() {
        ArrayList<ChessBook> books = new ArrayList<>();
        books.add(new ChessBook("t1", "afn1", "link1", PlayerType.AGGRESSIVE, "photolink1", PlayerDifficulty.BEGINNER));
        books.add(new ChessBook("t2", "afn2", "link2", PlayerType.DEFENSIVE, "photolink2", PlayerDifficulty.BEGINNER));
        books.add(new ChessBook("t3", "afn3", "link3", PlayerType.TACTICAL, "photolink3", PlayerDifficulty.BEGINNER));
        books.add(new ChessBook("t4", "afn4", "link4", PlayerType.POSITIONAL, "photolink4", PlayerDifficulty.BEGINNER));
        books.add(new ChessBook("t5", "afn5", "link5", PlayerType.AGGRESSIVE, "photolink5", PlayerDifficulty.INTERMEDIATE));
        books.add(new ChessBook("t6", "afn6", "link6", PlayerType.DEFENSIVE, "photolink6", PlayerDifficulty.INTERMEDIATE));
        books.add(new ChessBook("t7", "afn7", "link7", PlayerType.TACTICAL, "photolink7", PlayerDifficulty.INTERMEDIATE));
        books.add(new ChessBook("t8", "afn8", "link8", PlayerType.POSITIONAL, "photolink8", PlayerDifficulty.INTERMEDIATE));
        books.add(new ChessBook("t9", "afn9", "link9", PlayerType.AGGRESSIVE, "photolink9", PlayerDifficulty.ADVANCED));
        books.add(new ChessBook("t10", "afn10", "link10", PlayerType.DEFENSIVE, "photolink10", PlayerDifficulty.ADVANCED));
        books.add(new ChessBook("t11", "afn11", "link11", PlayerType.TACTICAL, "photolink11", PlayerDifficulty.ADVANCED));
        books.add(new ChessBook("t12", "afn12", "link12", PlayerType.POSITIONAL, "photolink12", PlayerDifficulty.ADVANCED));
        ArrayList<ChessGame> games = new ArrayList<>();
        games.add(new ChessGame("pgn1", PlayerType.AGGRESSIVE));
        games.add(new ChessGame("pgn2", PlayerType.DEFENSIVE));
        games.add(new ChessGame("pgn3", PlayerType.TACTICAL));
        games.add(new ChessGame("pgn4", PlayerType.POSITIONAL));
        ArrayList<ChessOpening> openings = new ArrayList<>();
        openings.add(new ChessOpening("on1", "od1", PlayerType.AGGRESSIVE));
        openings.add(new ChessOpening("on2", "od2", PlayerType.DEFENSIVE));
        openings.add(new ChessOpening("on3", "od3", PlayerType.TACTICAL));
        openings.add(new ChessOpening("on4", "od4", PlayerType.POSITIONAL));
        this.kieSession = this.kieContainer.newKieSession();
        this.kieSession.getAgenda().getAgendaGroup("recommended-for-player-type").setFocus();
        this.kieSession.insert(this.recommendedService);
        this.kieSession.insert(new Recommended());
        this.kieSession.setGlobal("allChessBooks", books);
        this.kieSession.setGlobal("allChessGames", games);
        this.kieSession.setGlobal("allChessOpenings", openings);
    }

    @Test
    public void setBeginnerAggressiveRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerType(PlayerType.AGGRESSIVE);
        this.pdto.setPlayerDifficulty(PlayerDifficulty.BEGINNER);
        this.kieSession.insert(this.pdto);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set beginner aggressive recommended"));
        assertEquals("afn1", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("pgn1"));
        assertEquals("on1", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
    }

    @Test
    public void setBeginnerTacticalRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerType(PlayerType.TACTICAL);
        this.pdto.setPlayerDifficulty(PlayerDifficulty.BEGINNER);
        this.kieSession.insert(this.pdto);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set beginner tactical recommended"));
        assertEquals("afn3", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("pgn3"));
        assertEquals("on3", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
    }

    @Test
    public void setBeginnerDefensiveRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerDifficulty(PlayerDifficulty.BEGINNER);
        this.pdto.setPlayerType(PlayerType.DEFENSIVE);
        this.kieSession.insert(this.pdto);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set beginner defensive recommended"));
        assertEquals("afn2", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("pgn2"));
        assertEquals("on2", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
    }

    @Test
    public void setBeginnerPositionalRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerDifficulty(PlayerDifficulty.BEGINNER);
        this.pdto.setPlayerType(PlayerType.POSITIONAL);
        this.kieSession.insert(this.pdto);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set beginner positional recommended"));
        assertEquals("afn4", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("pgn4"));
        assertEquals("on4", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
    }

    @Test
    public void setIntermediateAggressiveRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerType(PlayerType.AGGRESSIVE);
        this.pdto.setPlayerDifficulty(PlayerDifficulty.INTERMEDIATE);
        this.kieSession.insert(this.pdto);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set intermediate aggressive recommended"));
        assertEquals("afn5", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("pgn1"));
        assertEquals("on1", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
    }

    @Test
    public void setIntermediateTacticalRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerType(PlayerType.TACTICAL);
        this.pdto.setPlayerDifficulty(PlayerDifficulty.INTERMEDIATE);
        this.kieSession.insert(this.pdto);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set intermediate tactical recommended"));
        assertEquals("afn7", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("pgn3"));
        assertEquals("on3", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
    }

    @Test
    public void setIntermediateDefensiveRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerDifficulty(PlayerDifficulty.INTERMEDIATE);
        this.pdto.setPlayerType(PlayerType.DEFENSIVE);
        this.kieSession.insert(this.pdto);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set intermediate defensive recommended"));
        assertEquals("afn6", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("pgn2"));
        assertEquals("on2", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
    }

    @Test
    public void setIntermediatePositionalRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerDifficulty(PlayerDifficulty.INTERMEDIATE);
        this.pdto.setPlayerType(PlayerType.POSITIONAL);
        this.kieSession.insert(this.pdto);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set intermediate positional recommended"));
        assertEquals("afn8", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("pgn4"));
        assertEquals("on4", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
    }

    @Test
    public void setAdvancedAggressiveRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerType(PlayerType.AGGRESSIVE);
        this.pdto.setPlayerDifficulty(PlayerDifficulty.ADVANCED);
        this.kieSession.insert(this.pdto);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set advanced aggressive recommended"));
        assertEquals("afn9", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("pgn1"));
        assertEquals("on1", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
    }

    @Test
    public void setAdvancedTacticalRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerType(PlayerType.TACTICAL);
        this.pdto.setPlayerDifficulty(PlayerDifficulty.ADVANCED);
        this.kieSession.insert(this.pdto);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set advanced tactical recommended"));
        assertEquals("afn11", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("pgn3"));
        assertEquals("on3", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
    }

    @Test
    public void setAdvancedDefensiveRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerDifficulty(PlayerDifficulty.ADVANCED);
        this.pdto.setPlayerType(PlayerType.DEFENSIVE);
        this.kieSession.insert(this.pdto);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set advanced defensive recommended"));
        assertEquals("afn10", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("pgn2"));
        assertEquals("on2", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
    }

    @Test
    public void setAdvancedPositionalRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerDifficulty(PlayerDifficulty.ADVANCED);
        this.pdto.setPlayerType(PlayerType.POSITIONAL);
        this.kieSession.insert(this.pdto);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set advanced positional recommended"));
        assertEquals("afn12", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("pgn4"));
        assertEquals("on4", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
    }

    @After
    public void disposeOfSession() {
        this.kieSession.dispose();
    }
}
