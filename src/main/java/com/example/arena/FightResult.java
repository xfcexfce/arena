
package com.example.arena;

public class FightResult {
    Creature c1;
    Creature c2;
    int finalDamageMostPowerFull;
    Creature CreatureWithFinalDamageMostPowerFull;
    AttackResult attackResult;

    public FightResult(Creature c1, Creature c2, AttackResult attackResult) {
        this.c1 = c1;
        this.c2 = c2;
        this.attackResult = attackResult;
    }

   // void addResultOfFinishedAttack(Creature c1, Creature c2, AttackResult attackResult) {
     //   this.c1 = c1; //tu jest blad - bo przypisuje refenecje do obiektu a nie zapisuje nowego obiektu - wystarczy zapisac punkty zycia
       // this.c2 = c2;
       // this.attackResult = attackResult;

   // }

}
