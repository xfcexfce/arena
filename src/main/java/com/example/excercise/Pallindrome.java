package com.example.excercise;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Pallindrome {
    public static void main(String[] args) {
        String result = "";
        result = "I am pallindrome";
        String string = "dfgaad";
        List<Character> charList = new LinkedList<>();
        charList = string
                .chars() // Convert to an IntStream
                .mapToObj(i -> (char) i) // Convert int to char, which gets boxed to Character
                .collect(Collectors.toList()); // Collect in a List<Character>

        //char[] charArray = string.toCharArray();
        System.out.println("Wielkosc chara " + charList.size());
        for (int i = 0; i < charList.size(); i++) {
            if (charList.get(i) == charList.get(charList.size() - 1 - i)) {
                System.out.println("poki co jest ok; nr iteracji " + i);
            } else {
                charList.remove(i);
                break;
            }

        }
        for (int i = 0; i < charList.size(); i++) {
            if (charList.get(i) == charList.get(charList.size() - 1 - i)) {
                System.out.println("poki co jest ok; nr iteracji " + i);
            } else {
                charList = string
                        .chars() // Convert to an IntStream
                        .mapToObj(j -> (char) j) // Convert int to char, which gets boxed to Character
                        .collect(Collectors.toList()); // Collect in a List<Character>
                charList.remove(charList.size() - 1 - i);
                break;
            }
        }
        for (int i = 0; i < charList.size(); i++) {
            if (charList.get(i) == charList.get(charList.size() - 1 - i)) {
                System.out.println("poki co jest ok; nr iteracji " + i);
            } else {
                result = "I am not pallindrome";
                break;
            }
        }

        System.out.println(result);
    }
}
