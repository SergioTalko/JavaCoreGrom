package lesson31.hw;

import java.util.*;

public class Solution<T> {


    public static Map countSymbols(String text) throws Exception {

        if (text == null || text.isEmpty()) throw new Exception("Input string is empty or null");


        //char[] to Character[]
        Character[] chars = text.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        Map<Character, Integer> result = new Hashtable<>();


        for (Character character : chars) {
            if (Character.isLetter(character)) {
                if (!result.containsKey(character)) {
                    result.put(character, new Solution<Character>().countRepeat(chars, character));
                    //чи може краще було написати result.get(character) + 1 ?
                }
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
                if (!result.containsKey(word)) {
                    result.put(word, new Solution<String>().countRepeat(words, word));
                }
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

    private int countRepeat(T[] t, T y) {

        int count = 0;
        for (T t1 : t) {
            if (y.equals(t1)) {
                count++;
            }
        }
        return count;
    }
}
 /* for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                result.merge(chars[i], 1, (a, b) -> a + b);

            }
        }*/