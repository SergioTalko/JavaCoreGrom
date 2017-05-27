package lesson6.HomeWork;

import java.util.Date;

public class DemoLesson6 {
    public static void main(String[] args) {
        Order order = new Order(900, new Date(), false, null, "Test", "Test", "Test");
        Order order2 = new Order(1200, new Date(), true, new Date(), "Test", "Test", "Buy");
        Order order3 = new Order(1200, new Date(), true, new Date(), "Test", "Test", "Sale");

        //test code method 1
        //1.сума < 1000
        System.out.println(order.checkPrice());
        //2.сума > 1000
        System.out.println(order2.checkPrice());

        //method 2
        //1.Confirmed false and dateConfirmed != new Date
        order.confirmOrder();
        System.out.println(order.isConfirmed);
        System.out.println(order.dateConfirmed);
        //2.Confirmed true and dateConfirmed == new Date
        order2.confirmOrder();
        System.out.println(order2.isConfirmed);
        System.out.println(order2.dateConfirmed);

        //method 3
        //1.type != Buy or Sale
        System.out.println(order.isValidType());
        //2. type == Buy
        System.out.println(order2.isValidType());
        //2. type == Sale
        System.out.println(order3.isValidType());

    }
}
