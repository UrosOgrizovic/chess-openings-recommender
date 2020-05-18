package com.cor.backend.controller;

import com.cor.backend.model.PlayerPreferences;
import com.cor.backend.model.Recommended;
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
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> determinePlayerType(@RequestBody List<String> chosenMoveTypes) {
        for (String cmt : chosenMoveTypes) {
            if (! ( cmt.equals("AGGRESSIVE") || cmt.equals("TACTICAL")|| cmt.equals("POSITIONAL")
                    || cmt.equals("DEFENSIVE") ) ) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }

        Recommended r = this.playerTypeService.fireDroolsRulesMoves(chosenMoveTypes);

        return ResponseEntity.ok(r);
    }



    @PostMapping(value="/sendAnswers", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> determinePositionsToShow(@RequestBody PlayerPreferences pp) {
        if (pp.getPlayerSeriousness() < 1 || pp.getPlayerSeriousness() > 10) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        if (pp.getImgPaths() != null && (pp.getImgPaths().length < 4 || pp.getImgPaths().length > 4)) {
            pp.setImgPaths(new String[]{"pos1", "pos2", "pos3", "pos4"});
        }
        return ResponseEntity.ok(this.playerTypeService.fireDroolsRulesAnswers(pp));
    }


}
