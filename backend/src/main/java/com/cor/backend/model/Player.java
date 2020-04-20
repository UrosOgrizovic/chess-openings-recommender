package com.cor.backend.model;

import com.cor.backend.model.enums.PlayerType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Player {


    private List<String> chosenMoves;
    private PlayerType playerType;
    private int aggressiveCount;
    private int tacticalCount;
    private int defensiveCount;
    private int positionalCount;


    public Player() {
    }

    public Player(List<String> chosenMoves, PlayerType playerType) {
        this.chosenMoves = chosenMoves;
        this.playerType = playerType;
        this.aggressiveCount = 0;
        this.tacticalCount = 0;
        this.defensiveCount = 0;
        this.positionalCount = 0;
    }

    public void setChosenMoves(List<String> chosenMoves) {
        this.chosenMoves = chosenMoves;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public List<String> getChosenMoves() {
        return chosenMoves;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setAggressiveCount(int aggressiveCount) {
        this.aggressiveCount = aggressiveCount;
    }

    public void setTacticalCount(int tacticalCount) {
        this.tacticalCount = tacticalCount;
    }

    public void setDefensiveCount(int defensiveCount) {
        this.defensiveCount = defensiveCount;
    }

    public void setPositionalCount(int positionalCount) {
        this.positionalCount = positionalCount;
    }

    public int getAggressiveCount() {
        return aggressiveCount;
    }

    public int getTacticalCount() {
        return tacticalCount;
    }

    public int getDefensiveCount() {
        return defensiveCount;
    }

    public int getPositionalCount() {
        return positionalCount;
    }

    public String getMaxCount() {

        int maxValue = Collections.max(Arrays.asList(this.aggressiveCount, this.defensiveCount, this.positionalCount,
                this.tacticalCount));
        if (maxValue == this.defensiveCount)
            return "DEFENSIVE";
        else if (maxValue == this.aggressiveCount)
            return "AGGRESSIVE";
        else if (maxValue == this.tacticalCount)
            return "TACTICAL";
        else
            return "POSITIONAL";

    }
}
