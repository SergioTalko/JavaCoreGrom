package lesson5.HomeWork;

public class HomeTaskOne2Bubbles {

    public int[] sortAscending(int[] array) {

        int cycle = 0;
        boolean change = true;
        while (change) {
            change = false;   // poka
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


    public int[] sortDescending(int[] array) {
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
