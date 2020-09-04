package com.jamesball.tictactoe;

public class BoardSpace {

    private PlayerMark playerMark = null;

    public BoardSpace() {
    }

    public PlayerMark getPlayerMark() {
        return this.playerMark;
    }

    @Override
    public String toString() {
        return "BoardSpace{" +
                "playerMark=" + playerMark +
                "}";
    }
}
