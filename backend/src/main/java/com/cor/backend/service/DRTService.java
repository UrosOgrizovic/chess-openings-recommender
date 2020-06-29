package com.cor.backend.service;

import com.cor.backend.model.dto.DRLFileDTO;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.drools.template.ObjectDataCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class DRTService {
    @Autowired
    private RuleHandler ruleHandler;

    public void saveDRLFile(DRLFileDTO drlContent) throws IOException, MavenInvocationException {
        String rule = this.createRule(drlContent);
        this.ruleHandler.evaluate(rule, drlContent.getFileName());
    }

    public String createRule(DRLFileDTO drlContent) {
        ObjectDataCompiler objectDataCompiler = new ObjectDataCompiler();
        Map<String, Object> data = new HashMap<>();
        data.put("ruleTitle", drlContent.getRuleTitle());
        data.put("playerDifficulty", drlContent.getPlayerDifficulty());
        data.put("playerSeriousness", drlContent.getPlayerSeriousness());
        data.put("position1", drlContent.getPosition1());
        data.put("position2", drlContent.getPosition2());
        data.put("position3", drlContent.getPosition3());
        data.put("position4", drlContent.getPosition4());
        return objectDataCompiler.compile(Collections.singletonList(data),
                Objects.requireNonNull(Thread.currentThread().getContextClassLoader().
                        getResourceAsStream("templates/rule-template.drt")));
    }
}
