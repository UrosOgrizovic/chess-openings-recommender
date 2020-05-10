package com.cor.backend.model.dto;

import com.cor.backend.model.ChessOpening;
import com.cor.backend.model.enums.PlayerType;

public class ChessOpeningDTO {
    private String openingName;
    private String description;
    private String openingType;

    public ChessOpeningDTO() {
    }

    public String getOpeningName() {
        return openingName;
    }

    public void setOpeningName(String openingName) {
        this.openingName = openingName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpeningType() {
        return openingType;
    }

    public void setOpeningType(String openingType) {
        this.openingType = openingType;
    }

    public ChessOpeningDTO(ChessOpening co) {
        this.openingName = co.getOpeningName();
        this.description = co.getDescription();
        this.openingType = co.getOpeningType().toString();
    }
}
