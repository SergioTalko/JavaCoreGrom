package lesson17.hw;

public class MaxMinWord {

     String maxWord(String input) {
        if (input == null || input.isEmpty()) return null;

        String[] words = input.trim().split(" +");
        String max = words[0];

        for (int i = 1; i < words.length; i++) {
            if (max.length() < words[i].length())
                max = words[i];
        }
        return max;
    }


     String minWord(String input) {
        if (input == null || input.isEmpty()) return null;

        String[] words = input.trim().split(" +");
        String min = words[0];

        for (int i = 1; i < words.length; i++) {
            if (min.length() > words[i].length())
                min = words[i];
        }
        return min;
    }
}
