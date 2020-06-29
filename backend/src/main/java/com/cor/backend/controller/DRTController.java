package com.cor.backend.controller;

import com.cor.backend.model.Recommended;
import com.cor.backend.model.dto.DRLFileDTO;
import com.cor.backend.service.DRTService;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/drt")
public class DRTController {
    @Autowired
    private DRTService drtService;

    @PostMapping(value="", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveFile(@RequestBody DRLFileDTO drlFile) {
        try {
            this.drtService.saveDRLFile(drlFile);
            return ResponseEntity.ok(drlFile);
        } catch (IOException | MavenInvocationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
