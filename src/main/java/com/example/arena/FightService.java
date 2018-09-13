
package com.example.arena;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class FightService {

    public LinkedList<FightResult> fight(Creature c1, Creature c2) {
        LinkedList<FightResult> fightResultList = new LinkedList<>();
        FightResult fightResultBeforeRealFight = new FightResult(c1, c2, null); //stan poczatkowy
        fightResultList.add(fightResultBeforeRealFight);
        while (c1.getLifePoints() > 0 && c2.getLifePoints() > 0) {
            AttackResult attackResultFromC1 = c1.attack();
            System.out.println("Potential attack from C1 (before dodge): BodyPart " + attackResultFromC1.bodyPart +
                    " Attack was finished with success: " + attackResultFromC1.successAttack +
                    " Hit number: " + attackResultFromC1.hitNumber + " Numer of try: " +
                    attackResultFromC1.numberOfTry + " Final (potential) damage " + attackResultFromC1.finalDamage +
                    "Final (potential) damage: " + attackResultFromC1.potentialDamage);
            if (attackResultFromC1.successAttack == true) {
                attackResultFromC1 = c2.dodge(attackResultFromC1);
                FightResult fightResult = new FightResult(c1, c2, attackResultFromC1); //tu stworzyc kopie c1 i c2
                fightResultList.add(fightResult);
            }
            if (c2.getLifePoints() > 0 && c1.getLifePoints() > 0) {
                AttackResult attackResultFromC2 = c2.attack();
                System.out.println("Atak od C2 " + attackResultFromC2.potentialDamage);
                if (attackResultFromC2.successAttack == true) {
                    c1.dodge(attackResultFromC2);
                    FightResult fightResult = new FightResult(c1, c2, attackResultFromC2);
                    fightResultList.add(fightResult);
                }
            }
            System.out.println("C1 ma punkty zycia " + c1.getLifePoints() + "C2 ma punkty zycia " + c2.getLifePoints());
        }
        return fightResultList;
    }

    List<Creature[]> listOfPairs(LinkedList<Creature> listOfCreatures) {
        List<Creature[]> pairs = new ArrayList<>();
        for (int i = 0; i < listOfCreatures.size(); ++i)
            for (int j = i + 1; j < listOfCreatures.size(); ++j)
                pairs.add(new Creature[]{listOfCreatures.get(i), listOfCreatures.get(j)});
        return pairs;
    }

    LinkedList<FightResult> singleTournament(List<Creature[]> listOfPairs) {
        LinkedList<FightResult> singleTournament = new LinkedList<>();
        for (int i = 0; i < listOfPairs.size(); i++) {
            Creature[] cpair = listOfPairs.get(i);
            Creature cc1 = cpair[0]; //to dalej jest wskaznik do tego samego Creature - wiec potrzeba zrobic tu kopie obiektu zamiast nowego wskaznika
            Creature cc2 = cpair[1];
            LinkedList<FightResult> fightResult2 = fight(cc1, cc2);
            FightResult lastFightResult = fightResult2.getLast();
            if (lastFightResult.c1.getLifePoints() < 1)
                lastFightResult.c2.numberOfWins++;
            else
                lastFightResult.c1.numberOfWins++;
            singleTournament.add(lastFightResult);
        }
        return singleTournament;
    }
}