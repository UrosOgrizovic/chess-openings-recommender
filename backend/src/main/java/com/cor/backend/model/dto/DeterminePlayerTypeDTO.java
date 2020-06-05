package com.cor.backend.model.dto;

import com.cor.backend.model.enums.PlayerDifficulty;

import java.util.List;

public class DeterminePlayerTypeDTO {
    private List<String> chosenMoveTypes;
    private PlayerDifficulty playerDifficulty;

    public DeterminePlayerTypeDTO() {
    }

    public DeterminePlayerTypeDTO(List<String> chosenMoveTypes, PlayerDifficulty playerDifficulty) {
        this.chosenMoveTypes = chosenMoveTypes;
        this.playerDifficulty = playerDifficulty;
    }

    public List<String> getChosenMoveTypes() {
        return chosenMoveTypes;
    }

    public void setChosenMoveTypes(List<String> chosenMoveTypes) {
        this.chosenMoveTypes = chosenMoveTypes;
    }

    public PlayerDifficulty getPlayerDifficulty() {
        return playerDifficulty;
    }

    public void setPlayerDifficulty(PlayerDifficulty playerDifficulty) {
        this.playerDifficulty = playerDifficulty;
    }
}
