package com.cor.backend.model.dto;

public class ChessGameDTO {
    private String gameType;
    private String pgn;

    public ChessGameDTO(String gameType, String pgn) {
        this.gameType = gameType;
        this.pgn = pgn;
    }

    public ChessGameDTO() {
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
