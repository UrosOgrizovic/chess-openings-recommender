package com.cor.backend.controller;


import com.cor.backend.model.dto.ChessGameDTO;
import com.cor.backend.service.ChessGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.github.bhlangonijr.chesslib.pgn.PgnHolder;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/games")
public class ChessGameController {
    @Autowired
    private ChessGameService chessGameService;

    @PostMapping(value="", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody ChessGameDTO chessGameDTO) {

//        PgnHolder pgn = new PgnHolder("C:\\Users\\grizl\\OneDrive\\Desktop\\k-t.pgn");
        try {
//            pgn.loadPgn();

            //TODO: write game to db, read game from db?
            //TODO: flush gamePGN to file, read from that file. also, move this stuff to service
//            System.out.println("A");
//            System.out.println(pgn.getGame().get(0).getWhitePlayer());
//            System.out.println(pgn.getGame().get(0).getBlackPlayer());
            return new ResponseEntity<>(this.chessGameService.create(chessGameDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.chessGameService.findAll());
    }
}
