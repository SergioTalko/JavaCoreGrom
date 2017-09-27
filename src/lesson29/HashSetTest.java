package lesson29;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

    HashSet<Order> orderHashSet = new HashSet<>();

    public HashSet<Order> useHashSet(Order[] orders) throws Exception {
        if (orders == null) throw new Exception("Input array cant be null");
        for (Order order : orders) {
            if (order != null) {
                orderHashSet.add(order);
            }
        }

        HashSet<Order> secondSet = new HashSet<>();

        secondSet.addAll(orderHashSet);


        int price = 100;
        while (orderHashSet.size() < 10) {
            orderHashSet.add(new Order(price, "1", "1", "1"));
            price++;
        }


        Object[] objects = orderHashSet.toArray();

        orderHashSet.retainAll(secondSet);

        price = 2;
        while (orderHashSet.size() < 10) {
            orderHashSet.add(new Order(price, "1", "1", "1"));
            price++;
        }

        Iterator<Order> orderIterator = orderHashSet.iterator();


        price = 1;
        while (orderHashSet.size() > 5) {
            orderHashSet.remove(findByPrice(price));
            price++;
        }

        return orderHashSet;
    }

    private Order findByPrice(int price) throws Exception {

        for (Order order1 : orderHashSet) {
            if (price == order1.getPrice()) {
                return order1;
            }
        }
        throw new Exception("We dont have this order with price " + price);
    }

}
