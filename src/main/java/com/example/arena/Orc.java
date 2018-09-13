package com.example.arena;

public class Orc extends Creature {
    public Orc(CreatureType creatureType, Integer strength, Integer dexterity, Integer defence, Integer endurance, Integer lifePoints) {
        super(creatureType.ORC, strength, dexterity, defence, endurance, lifePoints);
    }
}
