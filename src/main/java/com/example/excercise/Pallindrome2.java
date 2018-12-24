package com.example.excercise;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Pallindrome2 {
    public static void main(String[] args) {
        String result = "";
        result = "I am pallindrome";
        String string = "adfd";
        List<Character> charList = new LinkedList<>();
        //to powinno byc wykonane jesli po pierwszym usunieciu jest konieczne 2gie usuniecie zeby usunac max 1 znak a nie 2 tak jak teraz
        charList = string
                .chars() // Convert to an IntStream
                .mapToObj(i -> (char) i) // Convert int to char, which gets boxed to Character
                .collect(Collectors.toList()); // Collect in a List<Character>

        //char[] charArray = string.toCharArray();
        System.out.println("Wielkosc chara " + charList.size());
        Pallindrome2 pallindrome2 = new Pallindrome2();
        int i = pallindrome2.checkIfPallindrome(charList);
        if (i != -1) {
            pallindrome2.removeElement(charList, i);
            int j = pallindrome2.checkIfPallindrome(charList);
            if (j != -1) {
                pallindrome2.removeElement(charList, charList.size() - 1 - j);
                int k = pallindrome2.checkIfPallindrome(charList);
                if (k == -1)
                    result = "I am pallindrome";
                else
                    result = "I am not pallindrome";
            }
            else
                result = "I am pallindrome";
        }
        else
            result = "I am pallindrome";
        System.out.println(result);
    }

    public int checkIfPallindrome(List charList) {
        int position = -1;
        for (int i = 0; i < charList.size(); i++) {
            if (charList.get(i) == charList.get(charList.size() - 1 - i)) {
                System.out.println("poki co jest ok; nr iteracji " + i);
            } else {
                return i;
            }
        }
        return position;
    }

    public List<Character> removeElement(List charList, int i) {
        if (i == -1)
            return charList;
        else {
            charList.remove(i);
            return charList;

        }
    }
    public List<Character> stringtoChar(String string){
        List<Character> charList = new LinkedList<>();
        charList = string
                .chars() // Convert to an IntStream
                .mapToObj(i -> (char) i) // Convert int to char, which gets boxed to Character
                .collect(Collectors.toList()); // Collect in a List<Character>
        return charList;
    }
}
