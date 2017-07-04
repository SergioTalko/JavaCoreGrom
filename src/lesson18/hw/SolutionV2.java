package lesson18.hw;

public class SolutionV2 {

    public int[] findNumbers(String text) {
        if (text.isEmpty() || text == null) return null;

        int[] res = new int[countNumber(text)];

        int index = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            if (word.chars().allMatch(Character::isDigit)) {
                res[index] = Integer.parseInt(word);
                index++;
            } else if (!word.chars().allMatch(Character::isDigit))
                System.out.println(word + " not a number");
        }

        return res;
    }

    private int countNumber(String input) {
        if (input.isEmpty() || input == null) return 0;
        int count = 0;

        String[] words = input.split(" ");
        for (String word : words) {
            if (word.chars().allMatch(Character::isDigit)) {
                count++;
            }
        }

        return count;

    }
}

