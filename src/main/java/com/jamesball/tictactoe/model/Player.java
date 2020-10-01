package com.jamesball.tictactoe.model;

import com.jamesball.tictactoe.exception.PlayerMarkNotNullException;

public class Player {

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
}
