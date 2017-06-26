package lesson17.hw;

public class CountWords {

    public int countWords(String input) {
        if (input == null)
            return 0;

        String[] words = input.split(" ");

        return words.length;
    }
}
