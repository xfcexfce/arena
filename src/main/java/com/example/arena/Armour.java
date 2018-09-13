package com.example.arena;

public enum Armour {
    HELMET(0,2),
    ARMOUR(0,4),
    GLOVES(0,3),
    GREAVES(0,2),
    SHIELD(0,1);

    private final int minDefence;
    private final int maxDefence;

    Armour(int minDefence, int maxDefence) {
        this.minDefence = minDefence;
        this.maxDefence = maxDefence;

    }
    int maxDefence(){
        return this.maxDefence;
    }
    int minDefence(){
        return this.minDefence;
    }
}
