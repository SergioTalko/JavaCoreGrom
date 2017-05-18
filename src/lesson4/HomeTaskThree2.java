package lesson4;

/**
 * Created by SERGIO on 22.03.2017.
 */
public class HomeTaskThree2 {
    public static void main(String[] args) {
         System.out.println(sum(2, 2));
        System.out.println(compareSums( 1,10, 10,100));

    }
    public static int compareSums(int a, int b, int c, int d) {
         int res = 0;
         int res2 = 0;
         for (int i = a; i <= b; i++) {
             res += i;
        }
         for (int s = c; s <= d; s++) {
             res2 += s;
        }
        if(res > res2)
         return res;
         else
             return res2;

    }
    public static long sum(int a, int b) {
        long res = 0;
        for (long i = a; i <= b; i++) {
            res += i;
        }
        return res;
    }
}

