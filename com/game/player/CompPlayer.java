package com.game.player;

import com.game.field.Field;

public class CompPlayer extends Player {

    //construction

    public CompPlayer(EPlayerSide playerSide) {
        super(playerSide);
    }

    //public method

    @Override
    public void makeTurn(Field field) {
        if (CanWin(field)) {
            return;
        }
        while (true) {
            int randomColumn =(int)(Math.random()*field.getField().length);
            int randomRow = (int)(Math.random()*field.getField().length);
            if (field.getField()[randomColumn][randomRow] == field.getDefaultValue()) {
                field.getField()[randomColumn][randomRow] = getPlayerSide();
                break;
            }
        }
    }

    //private method

    private boolean CanWin(Field field) {
        if (checkHorizontal(field)) {
            return true;
        }
        if (checkVertical(field)) {
            return true;
        }
        return false;
    }

    private boolean checkHorizontal(Field field) {
        for (int i = 0; i<field.getField().length; i++) {
            if (checkHorizontalLine(field, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkHorizontalLine(Field field, int lineNumber) {
        int counter = 0;
        for (int i = 0; i<field.getField().length; i++) {
            if (field.getField()[i][lineNumber] != field.getDefaultValue()) {
                counter++;
            }
        }
        if (counter == field.getField().length) {
            return false;
        }
        counter = 0;
        for (int i = 0; i<field.getField().length; i++) {
            if (field.getField()[i][lineNumber] != getPlayerSide()
                    && field.getField()[i][lineNumber] != field.getDefaultValue()) {
                counter++;
            }
        }
        if (counter == (field.getField().length-1)) {
            horizontalLineTurn(field, lineNumber);
            return true;
        }
        counter = 0;
        for (int i = 0; i<field.getField().length; i++) {
            if (field.getField()[i][lineNumber] == getPlayerSide()
                && field.getField()[i][lineNumber] != field.getDefaultValue()) {
                counter++;
            }
        }
        if (counter == (field.getField().length-1)) {
            horizontalLineTurn(field, lineNumber);
            return true;
        }
        return false;
    }

    private void horizontalLineTurn(Field field, int lineNumber) {
        for (int i = 0; i<field.getField().length; i++) {
            if (field.getField()[i][lineNumber] == field.getDefaultValue()) {
                field.getField()[i][lineNumber] = getPlayerSide();
                return;
            }
        }
    }

    private boolean checkVertical(Field field) {
        for (int i = 0; i<field.getField().length; i++) {
            if (checkVerticalLine(field, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkVerticalLine(Field field, int lineNumber) {
        int counter = 0;
        for (int i = 0; i<field.getField().length; i++) {
            if (field.getField()[lineNumber][i] != field.getDefaultValue()) {
                counter++;
            }
        }
        if (counter == (field.getField().length)) {
            return false;
        }
        counter = 0;
        for (int i=0; i<field.getField().length; i++) {
            if (field.getField()[lineNumber][i] != getPlayerSide() &&
                    field.getField()[lineNumber][i] != field.getDefaultValue()) {
                counter++;
            }
        }
        if (counter == (field.getField().length)) {
            verticalLineTurn(field, lineNumber);
            return true;
        }
        counter = 0;
        for (int i = 0; i<field.getField().length; i++) {
            if (field.getField()[lineNumber][i] == getPlayerSide() &&
                    field.getField()[lineNumber][i] != field.getDefaultValue()) {
                counter++;
            }
        }
        if (counter == (field.getField().length)) {
            verticalLineTurn(field, lineNumber);
            return true;
        }
        return false;
    }
    private void verticalLineTurn(Field field, int lineNumber) {
        for (int i = 0; i<field.getField().length; i++) {
            if (field.getField()[lineNumber][i] == field.getDefaultValue()) {
                field.getField()[lineNumber][i] = getPlayerSide();
                return;
            }
        }
    }




}
