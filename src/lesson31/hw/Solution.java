package lesson31.hw;

import java.util.*;

public class Solution {


    public static Map countSymbols(String text) throws Exception {

        if (text == null || text.isEmpty()) throw new Exception("Input string is empty or null");

        char[] chars = text.toCharArray();


        Map<Character, Integer> result = new Hashtable<>();


        for (Character character : chars) {
            if (Character.isLetter(character)) {
                if (result.containsKey(character)) {
                    result.put(character, result.get(character) + 1);
                } else
                    result.put(character, 1);
            }
        }


        if (result.isEmpty()) System.out.println("Input text doesnt have letter");

        return result;


    }


    public static Map<String, Integer> words(String text) throws Exception {

        if (text == null || text.isEmpty()) throw new Exception("Input string is empty or null");


        String[] words = text.toLowerCase().split(" ");

        Map<String, Integer> result = new Hashtable<>();


        for (String word : words) {
            if (word.length() > 2 && checkLetter(word)) {
                if (result.containsKey(word)) {
                    result.put(word, result.get(word) + 1);
                } else
                    result.put(word, 1);
            }
        }

        if (result.isEmpty()) System.out.println("Input text doesn't have word with length more than 2");

        return result;
    }


    private static boolean checkLetter(String word) {

        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }
        return true;
    }

}
 /* for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                result.merge(chars[i], 1, (a, b) -> a + b);

            }
        }*/