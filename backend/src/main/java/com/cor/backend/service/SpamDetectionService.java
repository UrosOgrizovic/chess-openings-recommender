package com.cor.backend.service;

import com.cor.backend.model.UserEvent;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderConfiguration;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class SpamDetectionService {

    private final KieContainer kieContainer;
    private KieSession kieSession;

    @Autowired
    public SpamDetectionService(KieContainer kieContainer) {
        super();
        this.kieContainer = kieContainer;
    }

    @PostConstruct
    private void initializeSession() {
        KnowledgeBuilderConfiguration kbc = KnowledgeBuilderFactory.newKnowledgeBuilderConfiguration();
        kbc.setProperty("drools.dialect.mvel.strict", "false");
        java.lang.System.setProperty("drools.dialect.mvel.strict", "false");

        KnowledgeBuilder kb = KnowledgeBuilderFactory.newKnowledgeBuilder(kbc);

        this.kieSession = this.kieContainer.newKieSession();
        this.kieSession.getAgenda().getAgendaGroup("check-spam").setFocus();
    }

    public boolean checkSpam(UserEvent userEvent) {
        this.kieSession.getAgenda().getAgendaGroup("check-spam").setFocus();
        this.kieSession.insert(userEvent);
        this.kieSession.fireAllRules();
        return userEvent.isSpam();
    }

    @PreDestroy
    private void disposeSession() {
        this.kieSession.dispose();
    }
}
