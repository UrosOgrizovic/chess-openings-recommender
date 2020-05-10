package com.cor.backend.model.dto;

import com.cor.backend.model.ChessGame;

public class ChessGameDTO {
    private String gameType;
    private String pgn;

    public ChessGameDTO(String gameType, String pgn) {
        this.gameType = gameType;
        this.pgn = pgn;
    }

    public ChessGameDTO() {
    }

    public ChessGameDTO(ChessGame cg) {
        this.gameType = cg.getGameType().toString();
        this.pgn = cg.getPgn();
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getPgn() {
        return pgn;
    }

    public void setPgn(String pgn) {
        this.pgn = pgn;
    }
}
