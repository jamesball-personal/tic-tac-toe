package com.jamesball.tictactoe.controller;

import com.jamesball.tictactoe.exception.InvalidPlayerException;
import com.jamesball.tictactoe.model.Player;
import com.jamesball.tictactoe.model.PlayerMark;
import com.jamesball.tictactoe.view.SelectPlayerView;

import java.util.regex.Pattern;

public class PlayerController {

    private Player player = new Player();
    private SelectPlayerView selectPlayerView = new SelectPlayerView();

    public PlayerMark getPlayerMark() {
        return player.getPlayerMark();
    }

    public void selectPlayer() {
        while (true) {
            try {
                String playerInput = selectPlayerView.inputPlayer();
                PlayerMark playerMark = parsePlayerInput(playerInput);
                player.setPlayerMark(playerMark);
                break;
            }
            catch (InvalidPlayerException exception) {
                System.out.println("Invalid player");
            }
        }
    }

    private PlayerMark parsePlayerInput(String playerInput) throws InvalidPlayerException {
        StringBuilder pattern = new StringBuilder();
        pattern.append("[");
        for (PlayerMark playerMark : PlayerMark.values()) {
            pattern.append(playerMark.name());
        }
        pattern.append("]{1}");
        final Pattern requiredInputPattern = Pattern.compile(pattern.toString());
        if (requiredInputPattern.matcher(playerInput).matches()) {
            return PlayerMark.valueOf(playerInput);
        }
        throw new InvalidPlayerException();
    }
}
