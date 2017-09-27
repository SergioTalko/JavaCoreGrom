package lesson27;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class TestPerformance {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        testAddMethod();
        testReoveMethod();
        //  testGetMethod();


        LinkedList<String> linkedList = new LinkedList<>();


    }

    private static void testGetMethod() {
        ArrayList<String> arrayList = new ArrayList<>();


        for (int i = 0; i < 100000; i++) {
            arrayList.add(i, String.valueOf(i));

        }
        Date start = new Date();
        for (int i = 0; i < 100000; i++) {
            arrayList.get(50000);

        }

        Date finish = new Date();

        long diff = finish.getTime() - start.getTime();
        System.out.println("array list got " + diff);

        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            linkedList.add(0, String.valueOf(i));

        }
        Date start1 = new Date();

        for (int i = 0; i < 100000; i++) {
            linkedList.get(50000);

        }

        Date finish1 = new Date();

        diff = finish1.getTime() - start1.getTime();
        System.out.println("linked list got " + diff);
    }

    private static void testAddMethod() {
        ArrayList<String> arrayList = new ArrayList<>();

        Date start = new Date();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(i, String.valueOf(i));

        }

        Date finish = new Date();

        long diff = finish.getTime() - start.getTime();
        System.out.println("array list added " + diff);

        LinkedList<String> linkedList = new LinkedList<>();

        Date start1 = new Date();

        for (int i = 0; i < 100000; i++) {
            linkedList.add(i, String.valueOf(i));

        }

        Date finish1 = new Date();

        diff = finish1.getTime() - start1.getTime();
        System.out.println("linked list added " + diff);
    }

    private static void testReoveMethod() {
        ArrayList<String> arrayList = new ArrayList<>();


        for (int i = 0; i < 100000; i++) {
            arrayList.add(0, String.valueOf(i));

        }
        Date start = new Date();
        for (int i = 0; i < 90000; i++) {
            arrayList.remove(10000);

        }

        Date finish = new Date();

        long diff = finish.getTime() - start.getTime();
        System.out.println("array list removed " + diff);

        LinkedList<String> linkedList = new LinkedList<>();


        for (int i = 0; i < 100000; i++) {
            linkedList.add(0, String.valueOf(i));

        }
        Date start1 = new Date();
        for (int i = 0; i < 90000; i++) {
            linkedList.remove(10000);

        }

        Date finish1 = new Date();

        diff = finish1.getTime() - start1.getTime();
        System.out.println("linked list removed " + diff);
    }


}
