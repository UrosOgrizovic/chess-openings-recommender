package com.cor.backend.model.dto;

import com.cor.backend.model.Recommended;
import com.cor.backend.model.enums.PlayerType;

public class PlayerDTO {
    private PlayerType playerType;
    private Recommended recommended;

    public PlayerDTO() {
    }

    public PlayerDTO(PlayerType playerType, Recommended recommended) {
        this.playerType = playerType;
        this.recommended = recommended;
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
