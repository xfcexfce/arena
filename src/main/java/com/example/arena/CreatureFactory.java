
package com.example.arena;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class CreatureFactory {
    @Autowired
    UtilitiesMain random = new UtilitiesMain();

    //bez dodaania = new UtilitiesMain(); nie wiedzial co ma zrobic i byla 500

    public CreatureType randomCreatureType() {
        CreatureType allResults[] = CreatureType.values();
        return allResults[ThreadLocalRandom.current().nextInt(allResults.length)];
    }

    public Creature randomCreature() {
        Creature randomCreature = new Creature(randomCreatureType(), random.random(1, 10), random.random(1, 10),
                random.random(1, 10), random.random(1, 10), random.random(1, 10));
        return randomCreature;
    }

    public LinkedList<Creature> randomCreatureList(int listSize) {
        LinkedList<Creature> creaturesList = new LinkedList<>();
        for (int x = 0; x < listSize; x++) {
            creaturesList.add(randomCreature());
        }
        return creaturesList;
    }
}
//LinkedList czy ArrayList?? - czy List - w sumie czym jest List ??
//jak zmnienie typ metody na private to jak do niej sie dostc z ArenaApplication?
