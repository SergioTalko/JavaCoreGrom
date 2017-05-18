package lesson2;

/**
 * Created by SERGIO on 16.03.2017.
 */
public class SumOfNumbersHome {
    public static void main(String[] args) {

        int a = 0;
        long sum = 0;
        while (a <= 10000000) {
            sum = sum + a;
            a++;
        }
        System.out.println(sum);
    }
}
