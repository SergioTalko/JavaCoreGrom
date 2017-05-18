package lesson4;

/**
 * Created by SERGIO on 22.03.2017.
 */
public class HomeTaskThree {
    public static void main(String[] args) {

        System.out.println(compareSums(2147483646, 2147483647, 2147483647, 2147483647));
        System.out.println(sum(2147483647, 2147483647));


    }

    public static boolean compareSums(int a, int b, int c, int d) {

        return sum(a, b) > sum(c, d) ? true : false;
    }

    public static long sum(int from, int to) {
        long res = 0;
        while (from < to) {
            res += from;
            from++;
        }
        return res + to;

    }
}

