package com.cor.backend.model;

import com.cor.backend.model.dto.ChessBookDTO;
import com.cor.backend.model.dto.ChessGameDTO;
import com.cor.backend.model.dto.ChessOpeningDTO;

import java.util.ArrayList;
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

    public void setChessBooks(List<ChessBook> books) {
        List<ChessBookDTO> chessBookDTOS = new ArrayList<>();
        books.forEach(b -> chessBookDTOS.add(new ChessBookDTO(b)));
        this.books = chessBookDTOS;
    }

    public List<ChessOpeningDTO> getOpenings() {
        return openings;
    }

    public void setOpenings(List<ChessOpeningDTO> openings) {
        this.openings = openings;
    }

    public void setChessOpenings(List<ChessOpening> openings) {
        List<ChessOpeningDTO> chessOpeningDTOS = new ArrayList<>();
        openings.forEach(o -> chessOpeningDTOS.add(new ChessOpeningDTO(o)));
        this.openings = chessOpeningDTOS;
    }

    public List<ChessGameDTO> getChessGames() {
        return chessGames;
    }

    public void setChessGames(List<ChessGameDTO> chessGames) {
        this.chessGames = chessGames;
    }

    public void setGames(List<ChessGame> games) {
        List<ChessGameDTO> chessGameDTOS = new ArrayList<>();
        games.forEach(g -> chessGameDTOS.add(new ChessGameDTO(g)));
        this.chessGames = chessGameDTOS;
    }
}
