package com.jamesball.tictactoe.view;

import java.util.Scanner;

public class SelectPlayerView {

    public String inputPlayer() {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Select player: ");
        return scanner.next();
    }
}
