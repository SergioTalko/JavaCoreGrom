package lesson4.HomeWork;

/**
 * Created by SERGIO on 22.03.2017.
 */
public class HomeTaskThree {

    public boolean compareSums(int a, int b, int c, int d) {

        return sum(a, b) > sum(c, d) ? true : false;
    }

    public long sum(int from, int to) {
        if (from > to) {
            System.err.println("Error. from > to");
            return 0;
        }
        long res = 0;
        while (from < to) {
            res += from;
            from++;
        }
        return res + to;

    }
}

