package com.cor.backend.drools;

import com.cor.backend.model.UserEvent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CheckSpamUnitTest {
    @Autowired
    private KieContainer kieContainer;

    private KieSession kieSession;

    @Before
    public void setUp() {
        this.kieSession = this.kieContainer.newKieSession();
        this.kieSession.getAgenda().getAgendaGroup("check-spam").setFocus();
    }

    @Test
    public void noSpam() {
        UserEvent ue = new UserEvent();
        this.kieSession.insert(ue);
        this.kieSession.fireAllRules();
        assertFalse(ue.isSpam());
    }

    @Test
    public void detectSpam() {
        UserEvent ue1 = new UserEvent();
        UserEvent ue2 = new UserEvent();
        UserEvent ue3 = new UserEvent();
        UserEvent ue4 = new UserEvent();
        UserEvent ue5 = new UserEvent();
        UserEvent ue6 = new UserEvent();
        UserEvent ue7 = new UserEvent();
        UserEvent ue8 = new UserEvent();
        this.kieSession.insert(ue1);
        this.kieSession.insert(ue2);
        this.kieSession.insert(ue3);
        this.kieSession.insert(ue4);
        this.kieSession.insert(ue5);
        this.kieSession.insert(ue6);
        this.kieSession.insert(ue7);
        this.kieSession.insert(ue8);
        this.kieSession.fireAllRules();
        assertTrue(ue8.isSpam());
    }
}
