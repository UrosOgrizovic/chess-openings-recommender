package com.cor.backend.model;


import com.cor.backend.model.enums.PlayerType;

import javax.persistence.*;

@Entity
@Table(name = "ChessGame")
public class ChessGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name="pgn", length = 2048)
    private String pgn;

    @Column(name="game_type")
    private PlayerType gameType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPgn() {
        return pgn;
    }

    public void setPgn(String pgn) {
        this.pgn = pgn;
    }

    public PlayerType getGameType() {
        return gameType;
    }

    public void setGameType(PlayerType gameType) {
        this.gameType = gameType;
    }

    public ChessGame(String pgn) {
        this.pgn = pgn;
    }

    public ChessGame() {
    }
    /*
    @Column
    private PlayerType playerType;
    @Column
    private String fen;
    @Column
    private String whitePlayer;
    @Column
    private String whiteElo;
    @Column
    private String blackPlayer;
    @Column
    private String blackElo;
    @Column
    private String location;
    @Column
    private String date;

    public ChessGame() {
    }

    public ChessGame(PlayerType playerType, String pgn, String fen, String whitePlayer, String whiteElo,
                     String blackPlayer, String blackElo, String location, String date) {
        this.playerType = playerType;
        this.pgn = pgn;
        this.fen = fen;
        this.whitePlayer = whitePlayer;
        this.whiteElo = whiteElo;
        this.blackPlayer = blackPlayer;
        this.blackElo = blackElo;
        this.location = location;
        this.date = date;
    }

    public ChessGame(String gamePGN) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public String getPgn() {
        return pgn;
    }

    public void setPgn(String pgn) {
        this.pgn = pgn;
    }

    public String getFen() {
        return fen;
    }

    public void setFen(String fen) {
        this.fen = fen;
    }

    public String getWhitePlayer() {
        return whitePlayer;
    }

    public void setWhitePlayer(String whitePlayer) {
        this.whitePlayer = whitePlayer;
    }

    public String getWhiteElo() {
        return whiteElo;
    }

    public void setWhiteElo(String whiteElo) {
        this.whiteElo = whiteElo;
    }

    public String getBlackPlayer() {
        return blackPlayer;
    }

    public void setBlackPlayer(String blackPlayer) {
        this.blackPlayer = blackPlayer;
    }

    public String getBlackElo() {
        return blackElo;
    }

    public void setBlackElo(String blackElo) {
        this.blackElo = blackElo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    */
}
