package lesson17.hw;

public class MostCountedWord {
    public static void main(String[] args) {
        String string = "В лингвистике термин текст используется в широком значении, включая и образцы устной речи. Восприятие текста изучается в рамках лингвистики текста и психолингвистики. Так, например, И. Р. Гальперин определяет текст следующим образом: «это письменное сообщение, объективированное в виде письменного документа, состоящее из ряда высказываний, объединённых разными типами лексической, грамматической и логической связи, имеющее определённый моральный характер, прагматическую установку и соответственно литературно обработанное»[1].";

        System.out.println(mostCountedWord(string));
    }

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
