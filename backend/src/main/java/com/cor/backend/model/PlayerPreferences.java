package com.cor.backend.model;

import com.cor.backend.model.enums.PlayerDifficulty;


public class PlayerPreferences {
    private PlayerDifficulty playerDifficulty;
    private int playerSeriousness;
    private String[] imgPaths = new String[4];

    public int getPlayerSeriousness() {
        return playerSeriousness;
    }

    public String[] getImgPaths() {
        return imgPaths;
    }

    public void setImgPaths(String[] imgPaths) {
        this.imgPaths = imgPaths;
    }

    public void setPlayerSeriousness(int playerSeriousness) {
        this.playerSeriousness = playerSeriousness;
    }

    public PlayerPreferences(PlayerDifficulty playerDifficulty, int playerSeriousness) {
        this.playerDifficulty = playerDifficulty;
        this.playerSeriousness = playerSeriousness;
    }

    public PlayerPreferences() {
    }

    public PlayerDifficulty getPlayerDifficulty() {
        return playerDifficulty;
    }

    public void setPlayerDifficulty(PlayerDifficulty playerDifficulty) {
        this.playerDifficulty = playerDifficulty;
    }
}
