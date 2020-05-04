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

    public ChessGame(String pgn, PlayerType gameType) {
        this.pgn = pgn;
        this.gameType = gameType;
    }

    public ChessGame() {
    }
}
