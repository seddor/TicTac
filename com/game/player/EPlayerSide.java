package com.game.player;

public enum EPlayerSide {

    X_SIDE('X'),
    O_SIDE('O');

    private final char charPlayerSide;

    private EPlayerSide(char charPlayerSide) {
        this.charPlayerSide = charPlayerSide;
    }

    public char getCharPlayerSide() {
        return charPlayerSide;
    }
}
