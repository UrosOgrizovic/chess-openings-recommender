package com.cor.backend.drools;

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
        this.kieSession = this.kieContainer.newKieSession();
        this.kieSession.getAgenda().getAgendaGroup("recommended-for-player-type").setFocus();
        this.kieSession.insert(this.recommendedService);
    }

    @Test
    public void setBeginnerAggressiveRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerType(PlayerType.AGGRESSIVE);
        this.pdto.setPlayerDifficulty(PlayerDifficulty.BEGINNER);
        this.kieSession.insert(this.pdto);
        this.kieSession.setGlobal("bookTitles", new ArrayList<String>());
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set beginner aggressive recommended"));
        assertEquals("Mikhail Tal", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertEquals("Gary Lane", this.pdto.getRecommended().getBooks().get(1).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("Hoogovens"));
        assertTrue(this.pdto.getRecommended().getChessGames().get(1).getPgn().contains("URS-chT Juniors"));
        assertEquals("King's Gambit", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
        assertEquals("Sicilian Defence", this.pdto.getRecommended().getOpenings().get(1).getOpeningName());
    }

    @Test
    public void setBeginnerTacticalRecommended() {
        this.pdto = new PlayerDTO();

        this.pdto.setPlayerType(PlayerType.TACTICAL);
        this.pdto.setPlayerDifficulty(PlayerDifficulty.BEGINNER);
        this.kieSession.insert(this.pdto);
        this.kieSession.setGlobal("bookTitles", new ArrayList<String>());
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set beginner tactical recommended"));
        assertEquals("Yasser Seirawan", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertEquals("Stuart Marguiles", this.pdto.getRecommended().getBooks().get(1).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("Buenos Aires"));
        assertTrue(this.pdto.getRecommended().getChessGames().get(1).getPgn().contains("Berlin GER"));
        assertEquals("Giuoco Piano", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
        assertEquals("King's Indian Defence", this.pdto.getRecommended().getOpenings().get(1).getOpeningName());
    }

    @Test
    public void setBeginnerDefensiveRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerDifficulty(PlayerDifficulty.BEGINNER);
        this.pdto.setPlayerType(PlayerType.DEFENSIVE);
        this.kieSession.insert(this.pdto);
        this.kieSession.setGlobal("bookTitles", new ArrayList<String>());
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set beginner defensive recommended"));
        assertEquals("Lev Polugaevsky", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertEquals("Samuel Reshevsky", this.pdto.getRecommended().getBooks().get(1).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("Amsterdam IBM"));
        assertTrue(this.pdto.getRecommended().getChessGames().get(1).getPgn().contains("Kuybyshev URS"));
        assertEquals("Slav Defense", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
        assertEquals("Nimzo-Indian Defence", this.pdto.getRecommended().getOpenings().get(1).getOpeningName());
    }

    @Test
    public void setBeginnerPositionalRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerDifficulty(PlayerDifficulty.BEGINNER);
        this.pdto.setPlayerType(PlayerType.POSITIONAL);
        this.kieSession.insert(this.pdto);
        this.kieSession.setGlobal("bookTitles", new ArrayList<String>());
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set beginner positional recommended"));
        assertEquals("Yasser Seirawan", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertEquals("Samuel Reshevsky", this.pdto.getRecommended().getBooks().get(1).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("Palma de Mallorca"));
        assertTrue(this.pdto.getRecommended().getChessGames().get(1).getPgn().contains("London ENG"));
        assertEquals("London System", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
        assertEquals("Nimzowitsch Defence", this.pdto.getRecommended().getOpenings().get(1).getOpeningName());
    }

    @Test
    public void setIntermediateAggressiveRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerType(PlayerType.AGGRESSIVE);
        this.pdto.setPlayerDifficulty(PlayerDifficulty.INTERMEDIATE);
        this.kieSession.insert(this.pdto);
        this.kieSession.setGlobal("bookTitles", new ArrayList<String>());
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set intermediate aggressive recommended"));
        assertEquals("Mikhail Tal", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertEquals("Mikhail Shereshevsky", this.pdto.getRecommended().getBooks().get(1).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("Hoogovens"));
        assertTrue(this.pdto.getRecommended().getChessGames().get(1).getPgn().contains("URS-chT Juniors"));
        assertEquals("King's Gambit", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
        assertEquals("Sicilian Defence", this.pdto.getRecommended().getOpenings().get(1).getOpeningName());
    }

    @Test
    public void setIntermediateTacticalRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerType(PlayerType.TACTICAL);
        this.pdto.setPlayerDifficulty(PlayerDifficulty.INTERMEDIATE);
        this.kieSession.insert(this.pdto);
        this.kieSession.setGlobal("bookTitles", new ArrayList<String>());
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set intermediate tactical recommended"));
        assertEquals("Gary Lane", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertEquals("Lev Alburt", this.pdto.getRecommended().getBooks().get(1).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("Buenos Aires"));
        assertTrue(this.pdto.getRecommended().getChessGames().get(1).getPgn().contains("Berlin GER"));
        assertEquals("Giuoco Piano", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
        assertEquals("King's Indian Defence", this.pdto.getRecommended().getOpenings().get(1).getOpeningName());
    }

    @Test
    public void setIntermediateDefensiveRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerDifficulty(PlayerDifficulty.INTERMEDIATE);
        this.pdto.setPlayerType(PlayerType.DEFENSIVE);
        this.kieSession.insert(this.pdto);
        this.kieSession.setGlobal("bookTitles", new ArrayList<String>());
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set intermediate defensive recommended"));
        assertEquals("Lev Polugaevsky", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertEquals("Mihail Marin", this.pdto.getRecommended().getBooks().get(1).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("Amsterdam IBM"));
        assertTrue(this.pdto.getRecommended().getChessGames().get(1).getPgn().contains("Kuybyshev URS"));
        assertEquals("Slav Defense", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
        assertEquals("Nimzo-Indian Defence", this.pdto.getRecommended().getOpenings().get(1).getOpeningName());
    }

    @Test
    public void setIntermediatePositionalRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerDifficulty(PlayerDifficulty.INTERMEDIATE);
        this.pdto.setPlayerType(PlayerType.POSITIONAL);
        this.kieSession.insert(this.pdto);
        this.kieSession.setGlobal("bookTitles", new ArrayList<String>());
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set intermediate positional recommended"));
        assertEquals("Aron Nimzowitsch", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertEquals("Jeremy Silman", this.pdto.getRecommended().getBooks().get(1).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("Palma de Mallorca"));
        assertTrue(this.pdto.getRecommended().getChessGames().get(1).getPgn().contains("London ENG"));
        assertEquals("London System", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
        assertEquals("Nimzowitsch Defence", this.pdto.getRecommended().getOpenings().get(1).getOpeningName());
    }

    @Test
    public void setAdvancedAggressiveRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerType(PlayerType.AGGRESSIVE);
        this.pdto.setPlayerDifficulty(PlayerDifficulty.ADVANCED);
        this.kieSession.insert(this.pdto);
        this.kieSession.setGlobal("bookTitles", new ArrayList<String>());
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set advanced aggressive recommended"));
        assertEquals("Mikhail Shereshevsky", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertEquals("Mark Dvoretsky", this.pdto.getRecommended().getBooks().get(1).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("Hoogovens"));
        assertTrue(this.pdto.getRecommended().getChessGames().get(1).getPgn().contains("URS-chT Juniors"));
        assertEquals("King's Gambit", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
        assertEquals("Sicilian Defence", this.pdto.getRecommended().getOpenings().get(1).getOpeningName());
    }

    @Test
    public void setAdvancedTacticalRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerType(PlayerType.TACTICAL);
        this.pdto.setPlayerDifficulty(PlayerDifficulty.ADVANCED);
        this.kieSession.insert(this.pdto);
        this.kieSession.setGlobal("bookTitles", new ArrayList<String>());
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set advanced tactical recommended"));
        assertEquals("Yuri Averbakh", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertEquals("Mark Dvoretsky", this.pdto.getRecommended().getBooks().get(1).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("Buenos Aires"));
        assertTrue(this.pdto.getRecommended().getChessGames().get(1).getPgn().contains("Berlin GER"));
        assertEquals("Giuoco Piano", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
        assertEquals("King's Indian Defence", this.pdto.getRecommended().getOpenings().get(1).getOpeningName());
    }

    @Test
    public void setAdvancedDefensiveRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerDifficulty(PlayerDifficulty.ADVANCED);
        this.pdto.setPlayerType(PlayerType.DEFENSIVE);
        this.kieSession.insert(this.pdto);
        this.kieSession.setGlobal("bookTitles", new ArrayList<String>());
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set advanced defensive recommended"));
        assertEquals("Mikhail Shereshevsky", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertEquals("Mihail Marin", this.pdto.getRecommended().getBooks().get(1).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("Amsterdam IBM"));
        assertTrue(this.pdto.getRecommended().getChessGames().get(1).getPgn().contains("Kuybyshev URS"));
        assertEquals("Slav Defense", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
        assertEquals("Nimzo-Indian Defence", this.pdto.getRecommended().getOpenings().get(1).getOpeningName());
    }

    @Test
    public void setAdvancedPositionalRecommended() {
        this.pdto = new PlayerDTO();
        this.pdto.setPlayerDifficulty(PlayerDifficulty.ADVANCED);
        this.pdto.setPlayerType(PlayerType.POSITIONAL);
        this.kieSession.insert(this.pdto);
        this.kieSession.setGlobal("bookTitles", new ArrayList<String>());
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Set advanced positional recommended"));
        assertEquals("Israel Gelfer", this.pdto.getRecommended().getBooks().get(0).getAuthorFullName());
        assertEquals("Mark Dvoretsky", this.pdto.getRecommended().getBooks().get(1).getAuthorFullName());
        assertTrue(this.pdto.getRecommended().getChessGames().get(0).getPgn().contains("Palma de Mallorca"));
        assertTrue(this.pdto.getRecommended().getChessGames().get(1).getPgn().contains("London ENG"));
        assertEquals("London System", this.pdto.getRecommended().getOpenings().get(0).getOpeningName());
        assertEquals("Nimzowitsch Defence", this.pdto.getRecommended().getOpenings().get(1).getOpeningName());
    }

    @After
    public void disposeOfSession() {
        this.kieSession.dispose();
    }
}
