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




        int[] array = {1, 2, 3, 4, 65, 4, 33};
        System.out.println(Arrays.toString(homeTaskOne.sortAscending(array)));
        System.out.println(Arrays.toString(homeTaskOne.sortDescending(array)));
        System.out.println(uniqueCount.uniqueCount(array));

        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};

        System.out.println(Arrays.toString(balances));
        System.out.println(withdraw.withdraw(names, balances, "Denis", 8436));

    }

}
