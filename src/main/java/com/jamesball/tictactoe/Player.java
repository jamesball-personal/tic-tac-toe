package com.jamesball.tictactoe;

public final class Player {

    private PlayerMark playerMark;

    public Player(PlayerMark playerMark) {
        this.playerMark = playerMark;
    }

    public PlayerMark getPlayerMark() {
        return playerMark;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerMark=" + this.playerMark +
                "}";
    }

}
