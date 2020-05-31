package com.cor.backend.service;

import com.cor.backend.model.dto.DRLFileDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class DRLFileService {

    public void saveDRLFile(DRLFileDTO drlFile) throws IOException {
        List<String> lines = Arrays.asList(drlFile.getContent().split("\n"));
        Path file = Paths.get("../kjar/src/main/resources/drools/rules/" + drlFile.getTitle() + ".drl");
        Files.write(file, lines, StandardCharsets.UTF_8);
    }
}
