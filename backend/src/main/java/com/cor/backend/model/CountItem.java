package com.cor.backend.model;

import com.cor.backend.model.enums.PlayerType;

import javax.persistence.*;

@Entity
@Table(name = "CountItem")
public class CountItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private PlayerType playerType;
    @Column
    private int count;
    @OneToOne
    private Player player;

    public CountItem() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CountItem(PlayerType playerType, int count, Player player) {
        this.playerType = playerType;
        this.count = count;
        this.player = player;
    }

    public CountItem(PlayerType playerType) {
        this.playerType = playerType;
    }

    public CountItem(int count) {
        this.count = count;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
