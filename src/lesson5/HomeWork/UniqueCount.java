package lesson5.HomeWork;

import java.util.Arrays;

public class UniqueCount {

    public int uniqueCount(int[] array) {
        if (array == null){
            return 0;
        }

        Arrays.sort(array);

        int count = 1;

        for (int first = 1; first < array.length; first++) {
            if (array[first] != array[first - 1]) {
                count++;
            }
        }

        return count;
    }
}

