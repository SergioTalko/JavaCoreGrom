package lesson17.hw;

public class MostCountedWord {

    public static String mostCountedWord(String input) {
        if (input == null) {
            return null;
        }


        String[] words = input.trim().split(" +");
        int[] count = new int[words.length];


        for (String word : words) {
            for (int i = 0; i < words.length; i++) {
                if (word.equals(words[i])) {
                    count[i]++;
                }
            }
        }


        for (int i = 0; i < count.length; i++) {
            for (int j = i + 1; j < count.length; j++) {
                if (count[i] < (count[j])) {
                    words[i] = null;
                }
            }
        }

        int index = 0;
        for (String str : words) {
            if (str == null) {
                index++;
            }
        }
        if (index == 0) {
            return null;
        }


        for (String word : words) {
            if (word != null) {
                return word;
            }
        }

        return null;
    }
}
