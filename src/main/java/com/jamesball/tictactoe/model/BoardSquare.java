package com.jamesball.tictactoe.model;

import com.jamesball.tictactoe.exception.PlayerMarkNotNullException;

public class BoardSquare extends BoardPosition {

    private PlayerMark playerMark;

    public PlayerMark getPlayerMark() {
        return playerMark;
    }

    public void setPlayerMark(PlayerMark playerMark) throws PlayerMarkNotNullException {
        if (this.playerMark == null) {
            this.playerMark = playerMark;
        }
        else {
            throw new PlayerMarkNotNullException();
        }
    }

    public BoardSquare clone() {
        BoardSquare clone = new BoardSquare();
        clone.setRow(getRow());
        clone.setColumn(getColumn());
        clone.setPlayerMark(getPlayerMark());
        return clone;
    }
}
