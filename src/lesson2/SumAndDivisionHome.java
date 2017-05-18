package lesson2;

/**
 * Created by SERGIO on 16.03.2017.
 */
public class SumAndDivisionHome {
    public static void main(String[] args) {

        int a = 1;
        int sum = 0;

        while (a <= 1000){
            sum += a;
            a++;
        }
        int sum1 = sum / 1234;
        int sum2 = sum % 1234;
        boolean res = sum2 > sum1;
        System.out.println(res);
    }

}
