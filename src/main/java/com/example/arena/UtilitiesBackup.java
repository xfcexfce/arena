package com.example.arena;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("fullrandom")
@Primary
public class UtilitiesBackup implements Utilities{
    public int random(int min, int max) {
        return 3;
    }
}


//nigdy nie uzyty random - czyli inaczej treba sie odwolac do "fullrandom"