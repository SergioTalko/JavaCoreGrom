package lesson7.HomeWork;

import java.util.Arrays;

public class SecondLargest {

    public int secondLargest(int[] array) {
        if (array == null) {
            System.err.println("array == null");
            return 0;
        }

        if (array.length < 2){
            System.err.println("Array have 1 element " + array[0] );
            return 0;
        }

        int max = array[0];
        int secondLargest = max;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                secondLargest = max;
                max = array[i];
            }
            if (secondLargest < array[i] && array[i] < max || secondLargest >= max) {
                secondLargest = array[i];
            }
        }
        return secondLargest;
    }

    public static int secondLargest2(int[] array) {

        Arrays.sort(array);
        int max = array[0];
        int secondLargest = max;

        for (int i : array) {
            if (i > max)
                max = i;
        }
        for (int s : array) {
            if (s != max) {
                secondLargest = s;
            }
        }
        return secondLargest;
    }
}