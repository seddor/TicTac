package com.game.console;

import com.game.field.console.FieldShowerConsole;
import com.game.player.CompPlayer;
import com.game.player.EPlayerSide;
import com.game.player.Player;
import com.game.player.console.ConsolePlayer;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        FieldShowerConsole field = new FieldShowerConsole();
        int amountPlayer = 0;
        while (amountPlayer != 1 && amountPlayer != 2) {
            System.out.print("Введите количество игроков (1/2): ");
            try {
                amountPlayer = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введено невалидное значение");
                scanner = new Scanner(System.in);
            }
        }
        switch (amountPlayer) {
            case 1:
                ConsolePlayer player = new ConsolePlayer(EPlayerSide.X_SIDE);
                CompPlayer compPlayerl = new CompPlayer(EPlayerSide.O_SIDE);
                while (true) {
                    player.makeTurn(field);
                    field.showField();
                    if (field.checkWin()) {
                        field.showWinner(player);
                        break;
                    }
                    compPlayerl.makeTurn(field);
                    System.out.println("Ход компьютера: " + compPlayerl.getPlayerSide());
                    field.showField();
                    if (field.checkWin()) {
                        field.showWinner(compPlayerl);
                        break;
                    }
                }
            break;
            case 2:
                ConsolePlayer pl1 = new ConsolePlayer(EPlayerSide.X_SIDE);
                ConsolePlayer pl2 = new ConsolePlayer(EPlayerSide.O_SIDE);
                while (true) {
                    pl1.makeTurn(field);
                    field.showField();
                    if (field.checkWin()) {
                        field.showWinner(pl1);
                        break;
                    }
                    pl2.makeTurn(field);
                    field.showField();
                    if (field.checkWin()) {
                        field.showWinner(pl2);
                        break;
                    }
                }
            break;
        }
        scanner.close();
    }
}
