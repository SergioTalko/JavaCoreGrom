package lesson17.hw;

public class Demo {
    public static void main(String[] args) {
        String str = "hhhh j jj j j jjjj jjj jjj";
        String str2 = null;
        String str3 = "HJJJJHJJJKklljkkfjkfkfkk KJfjjfjjckcjvjjvhjv";
        String str4 = "         ";
        CountWords countWords = new CountWords();
        System.out.println(countWords.countWords(str));
        System.out.println(countWords.countWords(str2));
        System.out.println(countWords.countWords(str3));
        System.out.println(countWords.countWords(str4));

    }
}
