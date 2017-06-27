package lesson17.hw;


public class CountWords {

    public int countWords(String input) {
        if (input == null || input.isEmpty()) return 0;


        int count = 0;
        String[] words = input.trim().toLowerCase().split(" +");
        for (String word : words) {
            count++;
        }

        return count;
    }
}
