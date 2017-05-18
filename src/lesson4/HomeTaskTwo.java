package lesson4;

/**
 * Created by SERGIO on 21.03.2017.
 */
public class HomeTaskTwo {
    public static void main(String[] args) {

        System.out.println(findDivCount((short) 1, (short) 10, 2));
    }

    public static int findDivCount(short a, short b, int n) {

        int count = 0;

        for (int i = a; i <= b; i++) {
            if (i % n == 0)
                count++;
        }
            return count;
    }
}
