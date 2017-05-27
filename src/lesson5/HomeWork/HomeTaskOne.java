package lesson5.HomeWork;

public class HomeTaskOne {

    public int[] sortAscending(int[] arr) {

        if (arr == null) {
            return null;
        }
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

    public int[] sortDescending(int[] array) {
        if (array == null) {
            return null;
        }

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

