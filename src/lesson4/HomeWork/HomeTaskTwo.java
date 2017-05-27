package lesson4.HomeWork;

/**
 * Created by SERGIO on 21.03.2017.
 */
public class HomeTaskTwo {

    public int findDivCount(short a, short b, int n) {

        int count = 0;

        for (int i = a; i <= b; i++) {
            if (i % n == 0)
                count++;
        }
        return count;
    }
}
