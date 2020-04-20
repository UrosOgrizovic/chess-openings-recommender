package com.cor.backend.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cor.backend.model.TestText;

@Service
public class TestService {
	@Autowired
	private KieContainer kieContainer;
	
	public TestText fireDroolsRules(TestText tt) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.getAgenda().getAgendaGroup("test").setFocus();
		kieSession.insert(tt);

		kieSession.fireAllRules();
		kieSession.dispose();
		return tt;
	}
	
}
