package com.example.arena;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

//stworzyc interfejs z metoda - a potem druga klasa, ktora jest taka sama ale nie zawiera Primary

//po co jest tu ta nazwa? koniec koncow sie z niej nie kozysta?

@Component("fullrandom")
@Primary
public class UtilitiesMain implements Utilities {
    public int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    //static int random2(int min, int max){
    //    Random2 nowylosowy = new Random2();
    //    nowylosowy.nextInt(); //pokombinowac z tym.
    //    return ThreadLocalRandom.current().nextInt(min,max);
    //}
}
