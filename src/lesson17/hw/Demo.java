package lesson17.hw;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        String str = "                 hhGGGGhh j jj j j jjjj jjj jjj ;    f0...         ";
        String str2 = null;
        String str3 = "HJJJJHJJJKklljkkfjkfkfkk  00  &&  l123d  KJfjjfjjckcjvjjvhjv";
        String str4 = ".l";
        CountWords countWords = new CountWords();
        System.out.println(countWords.countWords(str));
        System.out.println(countWords.countWords(str2));
        System.out.println(countWords.countWords(str3));
        System.out.println(countWords.countWords(str4));

    }
}
