package com.cor.backend.model.dto;

import com.cor.backend.model.Recommended;
import com.cor.backend.model.enums.PlayerDifficulty;
import com.cor.backend.model.enums.PlayerType;

public class PlayerDTO {
    private PlayerType playerType;
    private Recommended recommended;
    private PlayerDifficulty playerDifficulty;

    public PlayerDTO() {
    }

    public PlayerDTO(PlayerType playerType, Recommended recommended, PlayerDifficulty playerDifficulty) {
        this.playerType = playerType;
        this.recommended = recommended;
        this.playerDifficulty = playerDifficulty;
    }

    public PlayerDifficulty getPlayerDifficulty() {
        return playerDifficulty;
    }

    public void setPlayerDifficulty(PlayerDifficulty playerDifficulty) {
        this.playerDifficulty = playerDifficulty;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Recommended getRecommended() {
        return recommended;
    }

    public void setRecommended(Recommended recommended) {
        this.recommended = recommended;
    }
}
