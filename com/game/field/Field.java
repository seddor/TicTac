package com.game.field;

import com.game.player.Player;

public abstract class Field {
    private static final int DEFAULT_FIELD_SIZE = 3;
    private static final char DEFAULT_VALUE = ' ';
    private final int fieldSize;
    private final char[][] field;



    //Constructor

    public Field() {
        this(DEFAULT_FIELD_SIZE);
    }

    public Field(int size) {
        fieldSize = size;
        field = new char[fieldSize][fieldSize];
        eraseField();
    }

    //public abstract method

    public abstract void showField();

    public abstract void showWinner(Player pl);

    //public method


    public char getDefaultValue() {
        return DEFAULT_VALUE;
    }

    public char[][] getField() {
        return field;
    }

    public boolean checkWin() {
        if (checkHorizontal()) {
                return true;
        }
        if (checkVertical()) {
            return true;
        }
        if (checkMainDiagonal()) {
            return true;
        }
        if (checkIncidentalDiagonal()) {
            return true;
        }
        return false;
    }


    //private method


    private void eraseField() {
        for (int i = 0; i< fieldSize; i++) {
            eraseLine(i);
        }
    }

    private void eraseLine(int lineNumber) {
        for(int i = 0; i< fieldSize; i++) {
            field[i][lineNumber] = DEFAULT_VALUE;
        }
    }

    private boolean checkHorizontal() {
        for (int i = 0; i<fieldSize; i++) {
            if(checkHorizontalLine(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkHorizontalLine(int lineNumber) {
        int counter = 0;
        for (int i = 0; i<fieldSize-1; i++) {
            if (field[i][lineNumber] == field[i+1][lineNumber] &&
                    field[i][lineNumber] != DEFAULT_VALUE) {
                counter++;
            }
        }
        return (counter == fieldSize-1);
    }

    private boolean checkVertical() {
        for (int i = 0; i<fieldSize; i++) {
            if(checkVerticalLine(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkVerticalLine(int lineNumber) {
        int counter = 0;
        for (int i = 0; i<fieldSize - 1; i++) {
            if (field[lineNumber][i] == field[lineNumber][i+1] &&
                    field[lineNumber][i] != DEFAULT_VALUE) {
                counter++;
            }
        }
        return (counter == fieldSize-1);
    }

    private boolean checkMainDiagonal() {
        int counter = 0;
        for (int i =0; i<fieldSize-1; i++) {
            if(field[i][i] == field[i+1][i+1] &&
                    field[i][i] != DEFAULT_VALUE) {
                counter++;
            }
        }
        return (counter == fieldSize-1);
    }

    private boolean checkIncidentalDiagonal() {
        int counter = 0;
        for (int i = 0; i<fieldSize-1; i++) {
            if (field[(fieldSize-1)-i][i] == field[(fieldSize-1)-(i+1)][i+1] &&
                    field[(fieldSize-1)-i][i] != DEFAULT_VALUE) {
                counter++;
            }
        }
        return (counter == fieldSize-1);
    }


}
