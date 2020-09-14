package com.jamesball.tictactoe;

public enum PlayerMark {

    X(1),
    O(2);

    private int playerNumber;

    PlayerMark(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    @Override
    public String toString() {
        return "PlayerMark{" +
                "mark=" + this.name() + ", " +
                "playerNumber=" + this.playerNumber +
                '}';
    }
}
