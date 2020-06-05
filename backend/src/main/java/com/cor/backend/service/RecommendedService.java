package com.cor.backend.service;

import com.cor.backend.model.ChessBook;
import com.cor.backend.model.ChessGame;
import com.cor.backend.model.ChessOpening;
import com.cor.backend.model.Recommended;
import com.cor.backend.model.dto.ChessBookDTO;
import com.cor.backend.model.dto.ChessGameDTO;
import com.cor.backend.model.dto.ChessOpeningDTO;
import com.cor.backend.model.enums.PlayerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendedService {
    @Autowired
    private ChessBookService chessBookService;

    @Autowired
    private ChessOpeningService chessOpeningService;

    @Autowired
    private ChessGameService chessGameService;

    public Recommended getRecommendedForPlayerType(PlayerType playerType, ArrayList<String> chessBookTitles) {
        Recommended r = new Recommended();

        List<ChessBook> books = new ArrayList<>();
        for (String title : chessBookTitles) {
            ChessBook cb = this.chessBookService.findByTitle(title);
            books.add(cb);
        }
        List<ChessGame> games = this.chessGameService.findAllForPlayerType(playerType);
        List<ChessOpening> openings = this.chessOpeningService.findAllForPlayerType(playerType);

        List<ChessBookDTO> bookDTOS = new ArrayList<>();
        List<ChessGameDTO> gameDTOS = new ArrayList<>();
        List<ChessOpeningDTO> openingDTOS = new ArrayList<>();

        for (ChessBook cb : books) {
            bookDTOS.add(new ChessBookDTO(cb));
        }

        for (ChessGame cg : games) {
            gameDTOS.add(new ChessGameDTO(cg));
        }

        for (ChessOpening co : openings) {
            openingDTOS.add(new ChessOpeningDTO(co));
        }

        r.setBooks(bookDTOS);
        r.setChessGames(gameDTOS);
        r.setOpenings(openingDTOS);
        return r;
    }
}
