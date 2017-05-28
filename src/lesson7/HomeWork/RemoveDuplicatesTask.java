package lesson7.HomeWork;

import java.util.Arrays;

public class RemoveDuplicatesTask {

    public int[] removeDuplicates(int[] arr) {
        if (arr == null) {
            return null;
        }

        Arrays.sort(arr);

        int a = 0;
        int b = 1;
        //return if the array length is less than 2
        if (arr.length < 2) {
            return arr;
        }
        while (b < arr.length) {
            if (arr[b] == arr[a]) {
                b++;
            } else {
                arr[++a] = arr[b++];
            }
        }
        int[] output = new int[a + 1];
        for (int k = 0; k < output.length; k++) {
            output[k] = arr[k];
        }
        return output;
    }
    /*
    public static int[] removeDuplicates(int[] arr) {

        Arrays.sort(arr);

        int start = arr.length;
        int[] end = new int[start];
        int a = arr[0];

        for (int i = 0; i < start; i++) {
            for (int j = i + 1; j < start; j++) {
                if (arr[i] == arr[j]) {
                    int deleteLeft = j;
                    for (int k = j + 1; k < start; k++, deleteLeft++) {
                        arr[deleteLeft] = arr[k];
                    }
                    start--;
                    j--;
                }
            }
        }
        for (int i = 0; i < start; i++) {
            end[i] = arr[i];
        }
        return end;
    }
*/

}



