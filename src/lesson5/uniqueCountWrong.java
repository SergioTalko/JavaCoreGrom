package lesson5;

import java.util.Arrays;

/**
 * Created by SERGIO on 25.03.2017.
 */
public class uniqueCountWrong {
    public static void main(String[] args) {

        int[] array = {1, 7, 1, 1, 9, 1, 3, 4 ,1, 2, 2};
        int[] sort = sortAscending(array);
        System.out.println(Arrays.toString(sort));
        System.out.println(uniqueCount(sort));

    }

    public static int uniqueCount(int[] sort) {

        int count = 0;
        boolean uniqueNumber = true;
        for (int first = 1; first < sort.length; first++) {
            uniqueNumber = true;
            for (int second = first - 1; second >= 0; second--) {
                if (sort[second] == sort[first]) {
                    uniqueNumber = false;
                }
            }

            if (uniqueNumber) {
                count++;
            }
        }
        return count;

    }

    public static int[] sortAscending(int[] array) {

        int cycle = 0;
        boolean change = true;
        while (change) {
            change = false;
            for (int i = 0; i < array.length - 1; i++) {

                if (array[i] > array[i + 1]) { //porivnynnya 1 i 2 elementa massiva
                    int index = array[i];      // perenos 1 elementa massiva v zminniy index
                    array[i] = array[i + 1];   // 2 element stae na mesto 1 elementa masiva
                    array[i + 1] = index;        // vremenny index zapisuem na 2 mesto masiva
                    change = true;               // perenos vidbuvsya

                }
            }
        }

        return array;
    }
}
