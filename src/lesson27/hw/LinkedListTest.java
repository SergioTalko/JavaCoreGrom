package lesson27.hw;

import java.util.LinkedList;

public class LinkedListTest {

    private LinkedList<Order> list = new LinkedList<>();


    public LinkedList<Order> useList(Order[] orders) throws Exception {


        if (orders == null) throw new Exception("Array is null");

        int count = 0;
        for (Order order : orders) {
            if (order == null) {
                count++;
            }
        }

        if (count == orders.length) {
            list.add(new Order(1, 1, "1", "1", "1"));
        }

        for (Order order : orders) {
            if (order != null) {
                list.add(order);      //add
            }
        }

        if (list.size() < 5) {
            list.add(null);
        }

        list.add(0, null);
        list.remove(0);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                list.remove(list.get(i)); //remove(obj) :)
            }
        }

        if (list.size() < 1) {
            list.add(new Order(1, 1, "1", "1", "1"));
        }
        LinkedList<Order> listClone = new LinkedList<>(list.subList(0, list.size()));


        list.addAll(listClone);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                list.set(i, null);
            }
        }

        while (list.contains(null)) {
            list.remove(list.indexOf(null));
        }


        list.clear();
        list.add(new Order(1, 1, "1", "1", "1"));


        while (list.size() < 5) {
            list.add(list.get(0));
        }

        Object[] array = list.toArray();

        list.clear();

        list = listClone;

        while (list.size() < 5) {
            list.add(list.get(0));
        }

        while (list.size() > 5) {
            list.remove(0);
        }


        return list;
    }


}
