package com.game.player;

import com.game.field.Field;


public abstract class Player {

    private final char playerSide;


    protected Player(EPlayerSide playerSide) {
        this.playerSide = playerSide.getCharPlayerSide();
    }

    public char getPlayerSide() {
        return playerSide;
    }

    public abstract void makeTurn(Field field);







}
