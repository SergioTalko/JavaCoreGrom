package lesson3;

/**
 * Created by SERGIO on 17.03.2017.
 */
public class FindOdd {
    public static void main(String[] args) {


        for (int a = 0; a <= 1000; a++) {

            if (a % 2 != 0)
                System.out.println("Found");
        }
            int sum = 0;
            for (int a = 0; a <= 1000; a++) {
                if (a % 2 != 0)
                    sum += a;
            }
             System.out.println(sum);

            int sum1 = sum * 5;

            if(sum1 > 5000)
                System.out.println("Bigger");
            else
                System.out.println("Smaller or equal");


    }

}










