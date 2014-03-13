package com.game.field.console;

import com.game.field.Field;
import com.game.player.Player;

public class FieldShowerConsole extends Field {

    //construction

    public FieldShowerConsole() {
        super();
    }


    public FieldShowerConsole(int size) {
        super(size);
    }

    //public method


    @Override
    public void showWinner(Player pl) {
        checkWin();
        System.out.println(pl.getPlayerSide() + " - Win");
    }

    @Override
    public void showField() {
        for (int i = 0; i< getField().length; i++) {
            showLine(i);
            System.out.println();
        }
    }

    //private method

    private void showLine(int lineNumber) {
        for(int i = 0; i< getField().length; i++) {
            System.out.print("[" + getField()[i][lineNumber] + "]");
        }
    }

}
