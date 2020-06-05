package com.cor.backend.drools;

import com.cor.backend.model.Player;
import com.cor.backend.model.enums.PlayerType;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.hibernate.StatelessSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerTypeUnitTest {
    @Autowired
    private KieContainer kieContainer;

    private KieSession kieSession;

    private Player p;

    @Before
    public void setUp() {
        this.p = new Player();
        List<String> cmt = new ArrayList<>();
        cmt.add("AGGRESSIVE");
        cmt.add("POSITIONAL");
        cmt.add("TACTICAL");
        cmt.add("POSITIONAL");
        cmt.add("DEFENSIVE");
        this.p.setChosenMoveTypes(cmt);

        this.kieSession = this.kieContainer.newKieSession();
        this.kieSession.getAgenda().getAgendaGroup("player-type").setFocus();
        this.kieSession.insert(p);
    }

    @Test
    public void incrementAggressiveCount() {
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Increment aggressive count"));
        assertEquals(1, this.p.getAggressiveCount());
    }

    @Test
    public void incrementPositionalCount() {
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Increment positional count"));
        assertEquals(2, this.p.getPositionalCount());
    }

    @Test
    public void incrementTacticalCount() {
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Increment tactical count"));
        assertEquals(1, this.p.getTacticalCount());
    }

    @Test
    public void incrementDefensiveCount() {
        this.kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("Increment defensive count"));
        assertEquals(1, this.p.getDefensiveCount());
    }

    @Test
    public void determinePlayerType() {
        this.kieSession.fireAllRules();
        assertEquals(PlayerType.POSITIONAL, this.p.getPlayerType());
    }

    @After
    public void disposeOfSession() {
        this.kieSession.dispose();
    }
}
