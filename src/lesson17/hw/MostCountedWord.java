package lesson17.hw;

import java.util.Arrays;

public class MostCountedWord {

    public String mostCountedWord(String input) {
        if (!validInputString(input)) return null;

        String[] words = inputStringToArray(input);

        if (!ifOneWord(words)) return null;

        int[] countWord = new int[words.length];

        if (countWord.length == 1) return words[0];

        for (int i = 0; i < countWord.length; i++) {
            for (int j = i + 1; j < countWord.length; j++) {
                if (words[i].equals(words[j])) {             //&& words[i].matches("(?i).*[a-zа-я].*")
                    countWord[i]++;
                }
            }
        }

        String mostCount = words[0];
        for (int i = 0; i < countWord.length; i++) {
            for (int j = i + 1; j < countWord.length; j++) {
                if (countWord[i] < countWord[j]) {
                    mostCount = words[j];
                }
            }
        }


        return mostCount;
    }

    //перевіриит стрінг на null та empty
    private boolean validInputString(String input) {

        return input == null || input.isEmpty() ? false : true;
    }

    // вхідний стрінг в масив, з обрізаними пробілами на початку та в кінці та
    //з розділеними словами по пробілу
    private String[] inputStringToArray(String input) {

        String[] words = input.trim().toLowerCase().split(" ");

        return words;
    }

    //якщо в масиві залишилось одне слово і воно без літер
    private boolean ifOneWord(String[] words) {

        return words.length < 2 && words[0].toCharArray().length == 0 || !Character.isLetter(words[0].charAt(0)) ? false : true;
    }
}



