package lesson7;

import java.util.Arrays;

/**
 * Created by SERGIO on 03.04.2017.
 */
public class SecondLargest {
    public static void main(String[] args) {

        int[] array = {1, 11, 12, 0, -2, 11, 0, -2, 35, 99, 9, 10, 1};
        int[] array2 = {1, 11, 12, 0, -2, 11, 0, -2, 35, 99, 9, 10, 1, 99, 99};


        System.out.println(secondLargest(array2));
        System.out.println(secondLargest2(array));

    }

    public static int secondLargest(int[] array) {

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

    public static int secondLargest2(int[] array){

        Arrays.sort(array);
        int max = array[0];
        int secondLargest = max;

        for(int i : array){
            if(i > max)
                max = i;
        }
        for (int s : array){
            if(s != max){
                secondLargest = s;
            }
        }
        return secondLargest;
    }
}