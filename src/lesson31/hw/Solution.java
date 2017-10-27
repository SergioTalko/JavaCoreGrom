package lesson31.hw;

import java.util.Hashtable;
import java.util.Map;

public class Solution {


    public static Map countSymbols(String text) throws Exception {

        if (text == null || text.isEmpty()) throw new Exception("Input string is empty or null");

        char[] chars = text.toCharArray();

        Map<Character, Integer> result = new Hashtable<>();


        int index = 1;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                result.merge(chars[i], 1, (a, b) -> a + b);

            }
        }
        if (result.isEmpty()) System.out.println("Input text doesnt have letter");

        return result;


    }


    public static Map<String, Integer> words(String text) throws Exception {

        if (text == null || text.isEmpty()) throw new Exception("Input string is empty or null");


        String[] words = text.toLowerCase().split(" ");

        Map<String, Integer> result = new Hashtable<>();


        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 2 && checkLetter(words[i])) {
                result.merge(words[i], 1, (a, b) -> a + b);
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
