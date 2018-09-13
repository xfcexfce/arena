package com.example.arena;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;

public class RandomName {

    @Autowired
    UtilitiesMain random = new UtilitiesMain();

//to zyje do konca dzialania programu??
        final static LinkedList<String> listOfUsedNames = new LinkedList<>();

        private static String[] Beginning = { "Kr", "Ca", "Ra", "Mrok", "Cru",
                "Ray", "Bre", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol",
                "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro",
                "Mar", "Luk" };
        private static String[] Middle = { "air", "ir", "mi", "sor", "mee", "clo",
                "red", "cra", "ark", "arc", "miri", "lori", "cres", "mur", "zer",
                "marac", "zoir", "slamar", "salmar", "urak" };
        private static String[] End = { "d", "ed", "ark", "arc", "es", "er", "der",
                "tron", "med", "ure", "zur", "cred", "mur" };



        public String generateName() {
//gdzies - ale gdzie? trzeba przechowywac liste wylosowanych juz kombinacji
            String returnName = Beginning[random.random(0,Beginning.length-1)] +
                    Middle[random.random(0,Middle.length-1)]+
                    End[random.random(0,End.length-1)];
// a czy da sie aby wewnatrz ifa zadeklarowac zmienna??
            //if(listOfUsedNames.contains(returnName))

            listOfUsedNames.add(returnName);
            return returnName;
        }


}