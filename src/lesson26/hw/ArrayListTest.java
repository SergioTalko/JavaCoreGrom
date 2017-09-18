package lesson26.hw;

import java.util.ArrayList;


public class ArrayListTest {

    private ArrayList<Order> list = new ArrayList<>();


    public ArrayList<Order> useList(Order[] orders) throws Exception {


        if (orders == null) throw new Exception("Array is null");

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
            list.add(null);
        }
        ArrayList<Order> listClone = new ArrayList<>(list.subList(0, list.size()));


        list.addAll(listClone);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                list.set(i, null);
            }
        }

        while (list.contains(null)) {
            list.remove(list.indexOf(null));
        }


        for (Order order : orders) {
            if (order != null) {
                list.add(order);
            }
        }

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






