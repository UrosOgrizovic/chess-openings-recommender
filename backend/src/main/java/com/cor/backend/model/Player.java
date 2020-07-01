package com.cor.backend.model;

import com.cor.backend.model.enums.PlayerType;
import org.apache.poi.ss.formula.functions.Count;
import org.apache.tools.ant.taskdefs.Move;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "Player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> chosenMoveTypes;
    @Column
    private PlayerType playerType;
    @OneToOne
    private CountItem aggressiveCount;
    @OneToOne
    private CountItem tacticalCount;
    @OneToOne
    private CountItem defensiveCount;
    @OneToOne
    private CountItem positionalCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player() {
        this.aggressiveCount = new CountItem(PlayerType.AGGRESSIVE, 0, this);
        this.tacticalCount = new CountItem(PlayerType.TACTICAL, 0, this);
        this.defensiveCount = new CountItem(PlayerType.DEFENSIVE, 0, this);
        this.positionalCount = new CountItem(PlayerType.POSITIONAL, 0, this);
    }

    public Player(List<String> chosenMoveTypes, PlayerType playerType) {
        this.chosenMoveTypes = chosenMoveTypes;
        this.playerType = playerType;
        this.aggressiveCount = new CountItem(PlayerType.AGGRESSIVE, 0, this);
        this.tacticalCount = new CountItem(PlayerType.TACTICAL, 0, this);
        this.defensiveCount = new CountItem(PlayerType.DEFENSIVE, 0, this);
        this.positionalCount = new CountItem(PlayerType.POSITIONAL, 0, this);
    }

    public void setChosenMoveTypes(List<String> chosenMoveTypes) {
        this.chosenMoveTypes = chosenMoveTypes;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public List<String> getChosenMoveTypes() {
        return chosenMoveTypes;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public CountItem getAggressiveCount() {
        return aggressiveCount;
    }

    public void setAggressiveCountValue(int aggressiveCountValue) {
        this.aggressiveCount.setCount(aggressiveCountValue);
    }

    public CountItem getTacticalCount() {
        return tacticalCount;
    }

    public void setTacticalCountValue(int tacticalCountValue) {
        this.tacticalCount.setCount(tacticalCountValue);
    }

    public CountItem getDefensiveCount() {
        return defensiveCount;
    }

    public void setDefensiveCountValue(int defensiveCountValue) {
        this.defensiveCount.setCount(defensiveCountValue);
    }

    public CountItem getPositionalCount() {
        return positionalCount;
    }

    public void setPositionalCountValue(int positionalCountValue) {
        this.positionalCount.setCount(positionalCountValue);
    }

    public List<CountItem> getCountItems() {
        List<CountItem> countItems = new ArrayList<>();
        countItems.add(this.aggressiveCount);
        countItems.add(this.tacticalCount);
        countItems.add(this.positionalCount);
        countItems.add(this.defensiveCount);
        return countItems;
    }

    public CountItem getMaxCountItem() {
        List<CountItem> countItems = getCountItems();
        CountItem maxCI = new CountItem();
        for (CountItem ci : countItems) {
            if (ci.getCount() > maxCI.getCount()) {
                maxCI = ci;
            }
        }
        return maxCI;
    }
}
