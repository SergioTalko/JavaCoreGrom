package lesson17.hw;

public class MaxMinWord {

    public String maxWord(String input) {
        if (!validInputString(input)) return null;

        String[] words = inputStringToArray(input);

        if (!ifOneWord(words)) return null;


        String max = words[0];

        for (int i = 1; i < words.length; i++) {
            if (max.length() < words[i].length() && Character.isLetter(words[i].charAt(0)))
                max = words[i];
        }
        return max;
    }


    public String minWord(String input) {
        if (!validInputString(input)) return null;

        String[] words = inputStringToArray(input);

        if (!ifOneWord(words)) return null;

        String min = words[0];

        for (int i = 1; i < words.length; i++) {
            if (min.length() > words[i].length() && words[i].matches("(?i).*[a-zа-я].*"))
                min = words[i];
        }
        return min;
    }

    //перевіриит стрінг на null та empty
    private boolean validInputString(String input) {

        return input == null || input.isEmpty() ? false : true;
    }

    // вхідний стрінг в масив, з обрізаними пробілами на початку та в кінці та
    //з розділеними словами по пробілу
    private String[] inputStringToArray(String input) {

        String[] words = input.trim().split(" ");

        return words;
    }

    //якщо в масиві залишилось одне слово і воно без літер
    private boolean ifOneWord(String[] words) {

        return words.length < 2 && words[0].toCharArray().length == 0 || !Character.isLetter(words[0].charAt(0)) ? false : true;
    }
}
