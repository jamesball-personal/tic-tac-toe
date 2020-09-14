package com.jamesball.tictactoe;

public final class Player {

    private final PlayerMark mark;

    public Player(PlayerMark mark) {
        this.mark = mark;
    }

    public PlayerMark getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "Player{" +
                "mark=" + mark +
                "}";
    }

}
