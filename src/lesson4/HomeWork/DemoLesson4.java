package lesson4.HomeWork;

/**
 * Created by SERGIO on 27.05.2017.
 */
public class DemoLesson4 {
    public static void main(String[] args) {
        HomeTaskOne homeTaskOne = new HomeTaskOne();
        HomeTaskTwo homeTaskTwo = new HomeTaskTwo();
        HomeTaskThree homeTaskThree = new HomeTaskThree();


        //test code task 1
        System.out.println(homeTaskOne.concat("Hello ", "Java ", "World"));



        //test code task 2
        //1.перевірка на простому прикладі
        System.out.println(homeTaskTwo.findDivCount((short) 1, (short) 10, 2));
        //2.значення а та b більше ніж змінна short от -32768 до 32767
        System.out.println(homeTaskTwo.findDivCount((short) -40000, (short) 40000, 10));

        //test code task 3

        //1. в межах int  от -2147483648 до 2147483647
        System.out.println(homeTaskThree.sum(-2147483648, 2147483647 ));
        //2. от 0 до 0
        System.out.println(homeTaskThree.sum(0,0));
        //3.від більшого до меншого
        System.out.println(homeTaskThree.sum(3,2));
        //4. від max int до max int
        System.out.println(homeTaskThree.sum(2147483647,2147483647));

        //1.рівні числа
        System.out.println(homeTaskThree.compareSums(2,3,2,3));
        //2. діапазон a + b > c + d
        System.out.println(homeTaskThree.compareSums(2,3,1,2));
        //3. діапазон a + b < c + d
        System.out.println(homeTaskThree.compareSums(3,3,1,4));



    }
}
