package lesson17.hw;

public class Solution {

    public int countWords(String input) {

        if (!validInputString(input)) return 0;

        //обрізать пробіли на початку і вкінці
        //зробити масив слів, розділених по пробілу
        String[] words = input.trim().split(" ");

        //перевірка вхідного масива якщо він складається з одних пробілів
        if (words.length < 2 && words[0].toCharArray().length == 0)
            return 0;

        //перевірка чи є в слові літера, якщо є хоч одна рахувати його як слово
        int count = 0;
        for (String word : words) {
            for (int i = 0; i < word.toCharArray().length; i++) {
                if (Character.isLetter(word.toCharArray()[i])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    //перевіриит стрінг на null та empty
    private boolean validInputString(String input) {

        return input == null || input.isEmpty() ? false : true;
    }
}
