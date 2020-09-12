package com.jamesball.tictactoe;

public final class BoardSpace {

    private PlayerMark playerMark = null;

    public BoardSpace() {
    }

    public PlayerMark getPlayerMark() {
        return this.playerMark;
    }

    public void setPlayerMark(PlayerMark playerMark) {
        this.playerMark = playerMark;
    }

    @Override
    public String toString() {
        return "BoardSpace{" +
                "playerMark=" + playerMark +
                "}";
    }
}
