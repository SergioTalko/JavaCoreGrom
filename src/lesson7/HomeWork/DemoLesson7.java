package lesson7.HomeWork;

import java.util.Arrays;

public class DemoLesson7 {
    public static void main(String[] args) {
        RemoveDuplicatesTask removeDuplicatesTask = new RemoveDuplicatesTask();
        SecondLargest secondLargest = new SecondLargest();

        int[] array = {1, 4, 5, 3, 5, 7, 4, -2, -2, 6, 9, 10};
        int[] array2 = null;
        int[] array3 = {10};
        int[] array4 = {1, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 3};

        //test code task 1
        //1. видалення дублікатів в несортованому масиві
        System.out.println(Arrays.toString(removeDuplicatesTask.removeDuplicates(array)));
        //2. null
        System.out.println(Arrays.toString(removeDuplicatesTask.removeDuplicates(array2)));
        //3. 1 element
        System.out.println(Arrays.toString(removeDuplicatesTask.removeDuplicates(array3)));

        //task 2
        //1.перевірка в несортованому масиві
        System.out.println(secondLargest.secondLargest(array));
        //2. null
        System.out.println(secondLargest.secondLargest(array2));
        //3.повтори на початку і вкінці
        System.out.println(secondLargest.secondLargest(array4));

    }
}
