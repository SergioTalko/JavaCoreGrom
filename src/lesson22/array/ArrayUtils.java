package lesson22.array;

public class ArrayUtils {

    public static int maxElement(int[] array) {
        int max = array[0];

        for (int el : array) {
            if (el > max)
                max = el;
        }
        return max;
    }

    public static int nCount(int[] array, int n) {
        int count = 0;

        for (int el : array) {
            if (el == n)
                count++;
        }
        return count;

    }

    public static int[] sortAscending(int[] array) {

        int cycle = 0;
        boolean change = true;
        while (change) {
            change = false;
            for (int i = 0; i < array.length - 1; i++) {

                if (array[i] > array[i + 1]) {
                    int index = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = index;
                    change = true;

                }
            }
        }

        return array;
    }


    public static int[] sortDescending(int[] array) {
        int cycle = 0;
        boolean change = true;
        while (change) {
            change = false;
            for (int i = 0; i < array.length - 1; i++) {

                if (array[i] < array[i + 1]) {
                    int index = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = index;
                    change = true;
                }
            }
            cycle++;
        }

        return array;

    }
}
