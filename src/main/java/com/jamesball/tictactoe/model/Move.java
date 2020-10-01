package com.jamesball.tictactoe.model;

public class Move extends BoardPosition {

    private PlayerMark playerMark;

    public PlayerMark getPlayerMark() {
        return playerMark;
    }

    public void setPlayerMark(PlayerMark playerMark) {
        this.playerMark = playerMark;
    }
}
