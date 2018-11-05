package com.example.excercise;

import com.example.arena.Creature;
import com.example.arena.CreatureType;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LambdaExcercises {
    public void sortByLifePoints(LinkedList<Creature> listOfCreatures) {
        LinkedList<Creature> sortByLifePoints = listOfCreatures;
        sortByLifePoints.sort(Comparator.comparing(Creature::getLifePoints)
                //.thenComparing(Creature::getLifePoints)
                .reversed());
        for (int i = 0; i < sortByLifePoints.size(); i++) {
            Creature currentCreature = sortByLifePoints.get(i);
            System.out.println(currentCreature.toString());
        }
    }

    public LinkedList<Creature> sortByNumberOfWins(LinkedList<Creature> listOfCreatures) {
        LinkedList<Creature> sortByNumberOfWins = listOfCreatures;
        sortByNumberOfWins.sort(Comparator.comparing(Creature::getNumberOfWins)
                //.thenComparing(Creature::getLifePoints)
                .reversed());
        for (int i = 0; i < sortByNumberOfWins.size(); i++) {
            Creature currentCreature = sortByNumberOfWins.get(i);
            System.out.println(currentCreature.toString());
        }
        return sortByNumberOfWins;
    }

    public Creature creatureWithMaxPoints(LinkedList<Creature> listOfCreatures) {
        LinkedList<Creature> sortedList = listOfCreatures;
        for (int i = 0; i< listOfCreatures.size(); i++){
            Creature c1 = listOfCreatures.get(i);
            Integer max = c1.getStrength()+c1.getDexterity()+c1.getDefence()+c1.getEndurance()+c1.getLifePoints();
            c1.setTotalValueOfSDDEL(max);
        }
        sortedList.sort(Comparator.comparing(Creature::getTotalValueOfSDDEL).reversed());
        Creature creatureWithMaxPoints = sortedList.getFirst();
        return creatureWithMaxPoints;
    }

    public Map<CreatureType, LinkedList<Creature>> mapCreatureType(LinkedList<Creature> creatureLinkedList) {
        Map<CreatureType, LinkedList<Creature>> mapCreatureType = new HashMap<>();
        for (int i = 0; i < creatureLinkedList.size(); i++) {
            Creature c1 = creatureLinkedList.get(i);
            if (mapCreatureType.get(c1.getCreatureType()) != null) {
                LinkedList<Creature> actualList = mapCreatureType.get(c1.getCreatureType());
                actualList.add(c1);
                mapCreatureType.put(c1.getCreatureType(), actualList);
            } else {
                LinkedList<Creature> actualList = new LinkedList<>();
                actualList.add(c1);
                mapCreatureType.put(c1.getCreatureType(), actualList);
            }
        }
        return mapCreatureType;
    }
}
