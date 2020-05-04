package com.cor.backend.model;

import com.cor.backend.model.enums.PlayerType;

import javax.persistence.*;

@Entity
@Table(name = "ChessOpening")
public class ChessOpening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String openingName;
    @Column(name = "description", length = 2048)
    private String description;
    @Column
    private PlayerType openingType;

    public ChessOpening(String openingName, String description, PlayerType openingType) {
        this.openingName = openingName;
        this.description = description;
        this.openingType = openingType;
    }

    public ChessOpening() {
    }

    public PlayerType getOpeningType() {
        return openingType;
    }

    public void setOpeningType(PlayerType openingType) {
        this.openingType = openingType;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
