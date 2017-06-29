package lesson17.hw;

public class Demo {
    public static void main(String[] args) {
        String str = "                 one one two one two two two One                                 one   ";
        String str2 = null;
        String str3 = "    HJJJJHJJJ Kklljkkfjkfkfkk 00 && l123d KJfjjfjjckcjvjjvhjvG #hfjdkdkufufu&fufufufufuGGr 00 .  . . . . . 9999 99 99999999999999999999 99 99 99 99 99    99 99 99 99 99 - - - - - - - - - - - - - - - - - - - 8888j 88  88  88 88 88j 88 88 88 88 88 88 ";
        String str4 = "             hello k k            ";
        String str5 = "    998r9t79r8t9er8t      ";


        /*String[] s= str5.trim().split(" ");
        System.out.println(s[0].toCharArray().length);*/
        Solution countWords = new Solution();
        MostCountedWord mostCountedWord = new MostCountedWord();
        System.out.println(mostCountedWord.mostCountedWord(str));
        System.out.println(mostCountedWord.mostCountedWord(str2));
        System.out.println(mostCountedWord.mostCountedWord(str3));
        System.out.println(mostCountedWord.mostCountedWord(str4));
        System.out.println(mostCountedWord.mostCountedWord(str5));










        /*System.out.println(countWords.countWords(str));
        System.out.println(countWords.countWords(str2));
        System.out.println(countWords.countWords(str3));
        System.out.println(countWords.countWords(str4));
        System.out.println(countWords.countWords(str5));*/

        MaxMinWord maxMinWord = new MaxMinWord();

        /*System.out.println(maxMinWord.maxWord(str));
        System.out.println(maxMinWord.maxWord(str2));
        System.out.println(maxMinWord.maxWord(str3));
        System.out.println(maxMinWord.maxWord(str4));
        System.out.println(maxMinWord.maxWord(str5));*/

    }
}
