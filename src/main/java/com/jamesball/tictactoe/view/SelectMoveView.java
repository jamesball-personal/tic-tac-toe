package com.jamesball.tictactoe.view;

import java.util.Scanner;

public class SelectMoveView {

    public String inputMove() {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Enter move: ");
        return scanner.next();
    }
}
