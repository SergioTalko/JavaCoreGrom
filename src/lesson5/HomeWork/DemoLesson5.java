package lesson5.HomeWork;

import java.util.Arrays;

/**
 * Created by SERGIO on 27.05.2017.
 */
public class DemoLesson5 {
    public static void main(String[] args) {
        HomeTaskOne homeTaskOne = new HomeTaskOne();
        UniqueCount uniqueCount = new UniqueCount();
        Withdraw withdraw = new Withdraw();

        //test code task 1 method 1
        int[] array = {1, 2, 3, 4, 65, 4, 33};
        int[] array2 = null;
        int[] array3 = {10};
        //1. сорування від меншого
        System.out.println(Arrays.toString(homeTaskOne.sortAscending(array)));
        //2. null
        System.out.println(Arrays.toString(homeTaskOne.sortAscending(array2)));
        //3. 1 елемент в масиві
        System.out.println(Arrays.toString(homeTaskOne.sortAscending(array3)));

        // task 1 method 2
        //1. сорування від більшого
        System.out.println(Arrays.toString(homeTaskOne.sortDescending(array)));
        //2. null
        System.out.println(Arrays.toString(homeTaskOne.sortDescending(array2)));
        //3. 1 елемент в масиві
        System.out.println(Arrays.toString(homeTaskOne.sortDescending(array3)));


        //test code task 2
        //1.простий масив
        System.out.println(uniqueCount.uniqueCount(array));
        //2. null
        System.out.println(uniqueCount.uniqueCount(array2));
        //3. 1 елемент в масиві
        System.out.println(uniqueCount.uniqueCount(array3));

        //test code task 3
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};
        //1.просте зняття
        System.out.println(withdraw.withdraw(names, balances, "Denis", 1000));
        //2. якщо сума зняття > баланс
        System.out.println(withdraw.withdraw(names, balances, "Denis", 10000));
        //3.сума зняття < 0;
        System.out.println(withdraw.withdraw(names, balances, "Denis", -100));


    }

}
