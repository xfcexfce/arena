package com.example.arena;

public class AttackResult {
    int numberOfTry;
    int finalDamage;
    boolean successAttack;
    BodyPart bodyPart;
    int hitNumber;
    int potentialDamage;

    public AttackResult(BodyPart bodyPart, int potentialDamage, int numberOfTry, boolean successAttack) {
        this.bodyPart = bodyPart;
        this.hitNumber = 1;
        this.potentialDamage = potentialDamage;
        this.numberOfTry = numberOfTry;
        this.successAttack = successAttack;

    }

}
