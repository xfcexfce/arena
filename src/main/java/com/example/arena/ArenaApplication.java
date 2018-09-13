package com.example.arena;

import com.example.excercise.LambdaExcercises;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ArenaApplication {
    public static void main(String[] args) {
        CreatureFactory losowy = new CreatureFactory();
        LinkedList<Creature> listOfCreatures = losowy.randomCreatureList(10);
        FightService fight1 = new FightService();
        LambdaExcercises lambdaExcercises = new LambdaExcercises();
        lambdaExcercises.sortByLifePoints(listOfCreatures);
        Creature maxPacked = lambdaExcercises.creatureWithMaxPoints(listOfCreatures);
        System.out.println("MAX Packed" + maxPacked.toString());
        Map<CreatureType, LinkedList<Creature>> results = lambdaExcercises.mapCreatureType(listOfCreatures);
        LinkedList<Creature> listOfCreatures2 = losowy.randomCreatureList(10);
        List<Creature[]> listOfPairs = fight1.listOfPairs(listOfCreatures2);
        LinkedList<FightResult> singleTournament = fight1.singleTournament(listOfPairs);
        for (int i = 0; i < listOfCreatures2.size(); i++) {
            Creature c1 = listOfCreatures2.get(i);
            String s1 = c1.toString();
            System.out.println(s1);
        }
        System.out.println("KONIEC");
    }
}
