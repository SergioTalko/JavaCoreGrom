package lesson8.HomeWorkTaskOne;

/**
 * Created by SERGIO on 05.04.2017.
 */
public class Arithmetic {

    public static boolean check(int[] array) {

        int max = array[0];
        int min = max;
        for (int i : array) {
            if (i > max)
                max = i;
        }
        for (int s : array) {
            if (s < min)
                min = s;
        }
        return max + min > 100 ? true : false;
    }
}
