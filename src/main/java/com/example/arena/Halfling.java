package com.example.arena;

public class Halfling extends Creature {
    public Halfling (Integer strength, Integer decterity, Integer defence, Integer endurance, Integer lifePoints) {
        super( com.example.arena.CreatureType.HALFLING, strength, decterity, defence, endurance, lifePoints);
    }
}
