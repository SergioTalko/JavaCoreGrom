package lesson17.hw;

import java.util.Arrays;

public class CountWords {

    public int countWords(String input) {
        if (input == null)
            return 0;

        String deleteWhitespace = input.trim();
        if (deleteWhitespace.toCharArray().length == 0) {
            return 0;
        }

        int count = 0;

        String[] words = deleteWhitespace.split(" +");
        for (String word : words) {
            if (word.matches("^[a-zA-Z]+$")) {
                count++;
            }
        }

        return count;
    }
}
