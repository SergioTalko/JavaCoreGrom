package lesson2;

/**
 * Created by SERGIO on 16.03.2017.
 */
public class OperatorExample {
    public static void main(String[] args) {
        int a = 100;
        int b = 30;

        int c = a / b;
        int c2 = a % b;

        System.out.println(c);
        System.out.println(c2);
        a++;
        System.out.println(a);

        int n =10;
        a += n;
        System.out.println(a);

        a -= 1000;
        System.out.println(a);

    }
}
