package com.example.arena;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class FightServiceTest {

    @Test
    public void listOfPairs() {
        //given
        CreatureFactory creatureFactory = new CreatureFactory();
        LinkedList<Creature> listOfCreatures = creatureFactory.randomCreatureList(4);
        FightService fightService = new FightService();
        List<Creature[]> listOfPairs = fightService.listOfPairs(listOfCreatures);

        //when
        Assert.assertEquals("List of pairs should have 6 elements", 6, listOfPairs.size());


    }
}