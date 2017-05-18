package lesson5;

import java.util.Arrays;

/**
 * Created by SERGIO on 25.03.2017.
 */
public class uniqueCount2Wrong {
    public static void main(String[] args) {



        int[] array = {4, 5, 10, 11, 5, 11, 6, 6,88, 88,99,99,100};

        System.out.println(uniqueCount(array));

    }

    public static int uniqueCount(int[] array) {

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int count = 0;
        boolean uniqueNumber = true;


        for (int i = 1; i < array.length - 1; i++) {
            uniqueNumber = true;
            if (array[i] == array[i - 1]){
                uniqueNumber = false;
            }
            if (array[i] != array[i - 1]) {
                count++;
            }
        }
        for (int s = array.length -1; s < array.length;){
            uniqueNumber = true;
            if (s == array.length){
                uniqueNumber = false;
                if (s != array.length){
                    count++;
                }
            }
        }

        return count;
    }

}