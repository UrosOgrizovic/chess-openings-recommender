package com.cor.backend.drools;

import com.cor.backend.model.Player;
import com.cor.backend.model.PlayerPreferences;
import com.cor.backend.model.enums.PlayerDifficulty;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerPreferencesUnitTest {
    @Autowired
    private KieContainer kieContainer;

    private KieSession kieSession;

    @Before
    public void setUp() {
        this.kieSession = this.kieContainer.newKieSession();
        this.kieSession.getAgenda().getAgendaGroup("player-preferences").setFocus();
    }

    @Test
    public void beginnerNotSerious() {
        PlayerPreferences pp = new PlayerPreferences(PlayerDifficulty.BEGINNER, 2);
        this.kieSession.insert(pp);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Beginner and not serious at all"));
        assertEquals("assets/positions/exf4$d5$Bc5.jpeg", pp.getImgPaths()[0]);
        assertEquals("assets/positions/Nf3$Qxd4$c3.jpeg", pp.getImgPaths()[1]);
        assertEquals("assets/positions/Ng5$d3$O-O.jpeg", pp.getImgPaths()[2]);
        assertEquals("assets/positions/Qa4$b4.jpeg", pp.getImgPaths()[3]);
    }

    @Test
    public void invalidBeginnerNotSerious() {
        PlayerPreferences pp = new PlayerPreferences(PlayerDifficulty.INTERMEDIATE, 10);
        this.kieSession.insert(pp);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Beginner and not serious at all"));
        assertNull(pp.getImgPaths()[0]);
    }

    @Test
    public void intermediateNotSerious() {
        PlayerPreferences pp = new PlayerPreferences(PlayerDifficulty.INTERMEDIATE, 3);
        this.kieSession.insert(pp);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Intermediate and not serious at all"));
        assertEquals("assets/positions/e5$Bxf6$Bb5.jpeg", pp.getImgPaths()[0]);
        assertEquals("assets/positions/Qd2$Qe5$Qxc5.jpeg", pp.getImgPaths()[1]);
        assertEquals("assets/positions/Rxa7$Kd2$d4.jpeg", pp.getImgPaths()[2]);
        assertEquals("assets/positions/Qxc5$Ne4$Nh5.jpeg", pp.getImgPaths()[3]);
    }

    @Test
    public void advancedNotSerious() {
        PlayerPreferences pp = new PlayerPreferences(PlayerDifficulty.ADVANCED, 1);
        this.kieSession.insert(pp);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Advanced and not serious at all"));
        assertEquals("assets/positions/Nxe4$Nxd5$Bxf2.jpeg", pp.getImgPaths()[0]);
        assertEquals("assets/positions/g5$Bxf6$Rxd5.jpeg", pp.getImgPaths()[1]);
        assertEquals("assets/positions/Qxc5$Ne4$Nh5.jpeg", pp.getImgPaths()[2]);
        assertEquals("assets/positions/Bxh7$Qf5$Ng5.jpeg", pp.getImgPaths()[3]);
    }

    @Test
    public void beginnerModeratelySerious() {
        PlayerPreferences pp = new PlayerPreferences(PlayerDifficulty.BEGINNER, 5);
        this.kieSession.insert(pp);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Beginner and moderately serious"));
        assertEquals("assets/positions/e5$Bxf6$Bb5.jpeg", pp.getImgPaths()[0]);
        assertEquals("assets/positions/Qxc5$Ne4$Nh5.jpeg", pp.getImgPaths()[1]);
        assertEquals("assets/positions/Qa4$b4.jpeg", pp.getImgPaths()[2]);
        assertEquals("assets/positions/Nf3$Qxd4$c3.jpeg", pp.getImgPaths()[3]);
    }

    @Test
    public void intermediateModeratelySerious() {
        PlayerPreferences pp = new PlayerPreferences(PlayerDifficulty.INTERMEDIATE, 7);
        this.kieSession.insert(pp);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Intermediate and moderately serious"));
        assertEquals("assets/positions/Qd2$Qe5$Qxc5.jpeg", pp.getImgPaths()[0]);
        assertEquals("assets/positions/Nxe4$Nxd5$Bxf2.jpeg", pp.getImgPaths()[1]);
        assertEquals("assets/positions/Rxa7$Kd2$d4.jpeg", pp.getImgPaths()[2]);
        assertEquals("assets/positions/g5$Bxf6$Rxd5.jpeg", pp.getImgPaths()[3]);
    }

    @Test
    public void advancedModeratelySerious() {
        PlayerPreferences pp = new PlayerPreferences(PlayerDifficulty.ADVANCED, 4);
        this.kieSession.insert(pp);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Advanced and moderately serious"));
        assertEquals("assets/positions/Ra4$Rxa5$Nd2.jpeg", pp.getImgPaths()[0]);
        assertEquals("assets/positions/Bxh7$Qf5$Ng5.jpeg", pp.getImgPaths()[1]);
        assertEquals("assets/positions/g5$Bxf6$Rxd5.jpeg", pp.getImgPaths()[2]);
        assertEquals("assets/positions/Qd2$Qe5$Qxc5.jpeg", pp.getImgPaths()[3]);
    }

    @Test
    public void beginnerVerySerious() {
        PlayerPreferences pp = new PlayerPreferences(PlayerDifficulty.BEGINNER, 8);
        this.kieSession.insert(pp);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Beginner and very serious"));
        assertEquals("assets/positions/Qd2$Qe5$Qxc5.jpeg", pp.getImgPaths()[0]);
        assertEquals("assets/positions/Nxe4$Nxd5$Bxf2.jpeg", pp.getImgPaths()[1]);
        assertEquals("assets/positions/Bxh7$Qf5$Ng5.jpeg", pp.getImgPaths()[2]);
        assertEquals("assets/positions/Qxc5$Ne4$Nh5.jpeg", pp.getImgPaths()[3]);
    }

    @Test
    public void intermediateVerySerious() {
        PlayerPreferences pp = new PlayerPreferences(PlayerDifficulty.INTERMEDIATE, 9);
        this.kieSession.insert(pp);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Intermediate and very serious"));
        assertEquals("assets/positions/Ra4$Rxa5$Nd2.jpeg", pp.getImgPaths()[0]);
        assertEquals("assets/positions/Qd2$Qe5$Qxc5.jpeg", pp.getImgPaths()[1]);
        assertEquals("assets/positions/Qf3$Qh5$Bxf7.jpeg", pp.getImgPaths()[2]);
        assertEquals("assets/positions/Bxh7$Qf5$Ng5.jpeg", pp.getImgPaths()[3]);
    }

    @Test
    public void advancedVerySerious() {
        PlayerPreferences pp = new PlayerPreferences(PlayerDifficulty.ADVANCED, 10);
        this.kieSession.insert(pp);
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Advanced and very serious"));
        assertEquals("assets/positions/Bxh7$Qf5$Ng5.jpeg", pp.getImgPaths()[0]);
        assertEquals("assets/positions/Ra4$Rxa5$Nd2.jpeg", pp.getImgPaths()[1]);
        assertEquals("assets/positions/Qxg3$Qf7$Qd2.jpeg", pp.getImgPaths()[2]);
        assertEquals("assets/positions/Qf3$Qh5$Bxf7.jpeg", pp.getImgPaths()[3]);
    }

    @After
    public void disposeOfSession() {
        this.kieSession.dispose();
    }
}
