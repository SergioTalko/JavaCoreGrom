package lesson8.HomeWorkTaskOne;

public class Arithmetic {

    public boolean check(int[] array) {
        if (array == null) {
            System.err.println("Array == null");
            return false;
        }
        if (array.length < 2) {
            System.err.println("Array have 1 element " + array[0]);
            return false;
        }

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
