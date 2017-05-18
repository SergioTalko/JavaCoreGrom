package lesson5;

import java.util.Arrays;

/**
 * Created by SERGIO on 26.03.2017.
 */
public class uniqueCount3 {

    public static void main(String[] args) {

        int[] array = {1, 7, 9 , 80, 99, 99};

        System.out.println(uniqueCount(array));

    }


    public static int uniqueCount(int[] array) {

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int count = 1;

        for (int first = 1; first < array.length; first++) {
                if (array[first] != array[first - 1]) {
                    count++;
                }
            }

        return count ;
    }
}

