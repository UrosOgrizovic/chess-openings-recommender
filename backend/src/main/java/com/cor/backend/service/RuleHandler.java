package com.cor.backend.service;

import org.apache.maven.shared.invoker.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

@Service
public class RuleHandler {
    @Value("${kjarDirPath}")
    private String kjarDirPath;

    @Value("${kjarPomPath}")
    private String kjarPomPath;



    public void evaluate(String drl, String ruleFileName) throws IOException, MavenInvocationException {
        this.createFileForRule(drl, ruleFileName);
        this.mavenRefresh();
    }

    private void createFileForRule(String drl, String ruleFileName) throws IOException {
        // create new file for new rule
        File dir = new File(this.kjarDirPath);
        if (!dir.exists()) dir.mkdirs();

        String fileName = ruleFileName.replaceAll(" ", "_").toLowerCase() + ".drl";

        File ruleFile = new File(this.kjarDirPath + "/" + fileName);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruleFile))) {
            bw.append(drl);
        }
    }

    private void mavenRefresh() throws MavenInvocationException {
        InvocationRequest request = new DefaultInvocationRequest();

        request.setPomFile(new File(this.kjarPomPath));
        request.setGoals(Arrays.asList("clean", "install"));

        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(System.getenv("M2_HOME")));
        invoker.execute(request);
    }
}
