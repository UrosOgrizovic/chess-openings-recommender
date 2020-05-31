package com.cor.backend.controller;

import com.cor.backend.model.Recommended;
import com.cor.backend.model.dto.DRLFileDTO;
import com.cor.backend.service.DRLFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/drlFile")
public class DRLFileController {
    @Autowired
    private DRLFileService drlFileService;

    @PostMapping(value="", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveDRLFile(@RequestBody DRLFileDTO drlFile) {
        try {
            this.drlFileService.saveDRLFile(drlFile);
            return ResponseEntity.ok(drlFile);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
