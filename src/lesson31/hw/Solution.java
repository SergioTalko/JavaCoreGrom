package lesson31.hw;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

public class Solution {


    public static Map countSymbols(String text) throws Exception {

        if (text == null || text.isEmpty()) throw new Exception("Input string is empty or null");

        char[] chars = text.toCharArray();
        Arrays.sort(chars);

        Map<Character, Integer> result = new Hashtable<>();

        int index = 1;
        for (Character character : chars) {
            if (Character.isLetter(character)) {
                if (!result.containsKey(character)) {
                    index = 1;
                }
                result.put(character, index++);

            }

        }

        if (result.isEmpty()) System.out.println("Input text doesnt have letter");

        return result;


    }


    public static Map<String, Integer> words(String text) throws Exception {

        if (text == null || text.isEmpty()) throw new Exception("Input string is empty or null");


        String[] words = text.toLowerCase().split(" ");
        Arrays.sort(words);

        Map<String, Integer> result = new Hashtable<>();


        int index = 1;
        for (String word : words) {
            if (word.length() > 2 && checkLetter(word)) {
                if (!result.containsKey(word)) {
                    index = 1;
                }
                result.put(word, index++);

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
