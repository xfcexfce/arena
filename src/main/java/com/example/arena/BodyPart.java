package com.example.arena;

import java.util.Arrays;
import java.util.Collection;

public enum BodyPart {
    HEAD(5, 3, Arrays.asList(Armour.SHIELD, Armour.HELMET)),
    LEFT_ARM(10, 1, Arrays.asList(Armour.SHIELD, Armour.GLOVES)),
    RIGHT_ARM(10, 1, Arrays.asList(Armour.SHIELD, Armour.GLOVES)),
    TRUNK(30, 0, Arrays.asList(Armour.SHIELD, Armour.ARMOUR)),
    LEFT_LEG(5, 2, Arrays.asList(Armour.SHIELD, Armour.GREAVES)),
    RIGHT_LEG(5, 2, Arrays.asList(Armour.SHIELD, Armour.GREAVES));

    private final int prawdopodobienstwoTrafienia;
    private final int premiaZaTrafienie;
    private final Collection<Armour> listOfArmours;

    BodyPart(int prawdopodobienstwoTrafienia, int hitBonus, Collection<Armour> listOfArmours ) {
        this.prawdopodobienstwoTrafienia = prawdopodobienstwoTrafienia;
        this.premiaZaTrafienie = hitBonus;
        this.listOfArmours = listOfArmours;
    }

    int PrawdopodobienstwoTrafienia() {
        return this.prawdopodobienstwoTrafienia;
    }

    int PremiaZaTrafienie() {
        return this.premiaZaTrafienie;
    }

    Collection<Armour> listOfArmours(){ return this.listOfArmours; }
}

