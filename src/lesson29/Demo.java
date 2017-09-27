package lesson29;

import java.util.HashSet;

public class Demo {
    public static void main(String[] args) throws Exception {
        Order order = new Order(1,  "1", "1", "1");
        Order order1 = new Order(2,  "1", "1", "1");
        Order order2 = new Order(3,  "1", "1", "1");

        Order[] orders = { null,null,order};

        HashSetTest hashSetTest = new HashSetTest();

        System.out.println(hashSetTest.useHashSet(orders));



    }
}
