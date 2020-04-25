package com.cor.backend.controller;

import com.cor.backend.service.PlayerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/playerType")
public class PlayerTypeController {
    @Autowired
    private PlayerTypeService playerTypeService;

    @PostMapping(value="/sendMoves", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> determinePlayerType(@RequestBody List<String> chosenMoveTypes) {
        for (String cmt : chosenMoveTypes) {
            if (! ( cmt.equals("AGGRESSIVE") || cmt.equals("TACTICAL")|| cmt.equals("POSITIONAL")
                    || cmt.equals("DEFENSIVE") ) ) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }
        String playerType = playerTypeService.fireDroolsRules(chosenMoveTypes);

        return ResponseEntity.ok(playerType);
    }
}
