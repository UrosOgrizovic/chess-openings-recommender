package com.cor.backend.model.dto;

public class DRLFileDTO {
    private String fileName;
    private String ruleTitle;
    private String playerDifficulty;
    private int playerSeriousness;
    private String position1;
    private String position2;
    private String position3;
    private String position4;


    public DRLFileDTO() {
    }

    public DRLFileDTO(String fileName, String ruleTitle, String playerDifficulty, int playerSeriousness, String position1, String position2, String position3, String position4) {
        this.fileName = fileName;
        this.ruleTitle = ruleTitle;
        this.playerDifficulty = playerDifficulty;
        this.playerSeriousness = playerSeriousness;
        this.position1 = position1;
        this.position2 = position2;
        this.position3 = position3;
        this.position4 = position4;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRuleTitle() {
        return ruleTitle;
    }

    public void setRuleTitle(String ruleTitle) {
        this.ruleTitle = ruleTitle;
    }

    public String getPlayerDifficulty() {
        return playerDifficulty;
    }

    public void setPlayerDifficulty(String playerDifficulty) {
        this.playerDifficulty = playerDifficulty;
    }

    public int getPlayerSeriousness() {
        return playerSeriousness;
    }

    public void setPlayerSeriousness(int playerSeriousness) {
        this.playerSeriousness = playerSeriousness;
    }

    public String getPosition1() {
        return position1;
    }

    public void setPosition1(String position1) {
        this.position1 = position1;
    }

    public String getPosition2() {
        return position2;
    }

    public void setPosition2(String position2) {
        this.position2 = position2;
    }

    public String getPosition3() {
        return position3;
    }

    public void setPosition3(String position3) {
        this.position3 = position3;
    }

    public String getPosition4() {
        return position4;
    }

    public void setPosition4(String position4) {
        this.position4 = position4;
    }
}
