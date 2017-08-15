package lesson8.HomeWorkTaskOne;

public class Demo {
    public static void main(String[] args) {
        Adder adder = new Adder();
        int[] array = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5, 100};
        int[] array3 = null;
        int[] array4 = {100};

        //test code task "add"
        //1.додати 2 max int
        System.out.println(adder.add(2147483647, 2147483647));
        //2.от -2147483648 до 2147483647
        System.out.println(adder.add(-2147483648, 2147483647));

        //task "validate"
        //1.перший і останній < 100
        System.out.println(adder.check(array));
        //2. > 100
        System.out.println(adder.check(array2));
        //3.null
        System.out.println(adder.check(array3));
        //4. 1 element
        System.out.println(adder.check(array4));

    }
}
