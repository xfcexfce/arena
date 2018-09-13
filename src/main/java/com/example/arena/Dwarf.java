package com.example.arena;

public class Dwarf extends Creature {
    public Dwarf(CreatureType creatureType, Integer strength, Integer dexterity, Integer defence, Integer endurance, Integer lifePoints) {
        super(creatureType.DWARF, strength, dexterity, defence, endurance, lifePoints);
    }
}
