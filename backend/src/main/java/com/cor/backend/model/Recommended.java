package com.cor.backend.model;

import com.cor.backend.model.dto.ChessBookDTO;
import com.cor.backend.model.dto.ChessGameDTO;
import com.cor.backend.model.dto.ChessOpeningDTO;

import java.util.List;

public class Recommended {
    private List<ChessBookDTO> books;
    private List<ChessOpeningDTO> openings;
    private List<ChessGameDTO> chessGames;

    public Recommended(List<ChessBookDTO> books, List<ChessOpeningDTO> openings, List<ChessGameDTO> chessGames) {
        this.books = books;
        this.openings = openings;
        this.chessGames = chessGames;
    }

    public Recommended() {
    }

    public List<ChessBookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<ChessBookDTO> books) {
        this.books = books;
    }

    public List<ChessOpeningDTO> getOpenings() {
        return openings;
    }

    public void setOpenings(List<ChessOpeningDTO> openings) {
        this.openings = openings;
    }

    public List<ChessGameDTO> getChessGames() {
        return chessGames;
    }

    public void setChessGames(List<ChessGameDTO> chessGames) {
        this.chessGames = chessGames;
    }
}
