package com.example.arena;

import org.springframework.stereotype.Component;

@Component("fullrandom2") //tu miala byc ta sama nazwa co w UtilitiesMain

public class UtilitiesBackup implements Utilities{
    public int random(int min, int max) {
        return 3;
    }
}


//nigdy nie uzyty random - czyli inaczej treba sie odwolac do "fullrandom"