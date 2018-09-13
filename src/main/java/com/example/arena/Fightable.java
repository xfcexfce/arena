package com.example.arena;

public interface Fightable {
    AttackResult attack() throws Exception;
    AttackResult dodge(AttackResult attackResult);
    boolean isAlive();
}
