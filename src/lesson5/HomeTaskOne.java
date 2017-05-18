package lesson5;

import java.util.Arrays;

/**
 * Created by SERGIO on 24.03.2017.
 */
public class HomeTaskOne {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 65, 4, 33};
        System.out.println(Arrays.toString(sortAscending(array)));
        System.out.println(Arrays.toString(sortDescending(array)));


    }

    public static int[] sortAscending(int[] arr) {

        //zminna int min hranit znachenie minimalnogo inta masiva
        for (int first = 0; first < arr.length; first++) {
            int min = arr[first];

            for (int second = first + 1; second < arr.length; second++) {
                int index = first;

                if (arr[second] < min) {
                    min = arr[second];
                    index = second;
                }
                if (index != first) {
                    arr[index] = arr[first];
                    arr[first] = min;
                }
            }
        }
        return arr;
    }

    public static int[] sortDescending(int[] array) {
        for (int first = 0; first < array.length; first++) {
            int min = array[first];

            for (int second = first + 1; second < array.length; second++) {
                int index = first;

                if (array[second] > min) {
                    min = array[second];
                    index = second;
                }
                if (index != first) {
                    array[index] = array[first];
                    array[first] = min;
                }
            }
        }
        return array;
    }
}

