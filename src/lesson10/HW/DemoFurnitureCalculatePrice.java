package lesson10.HW;

import java.util.Date;

/**
 * Created by SERGIO on 21.04.2017.
 */
public class DemoFurnitureCalculatePrice {
    public static void main(String[] args) {
        Customer customer = new Customer("1", "Киев", "Женский");
        FurnitureOrder furnitureOrder = new FurnitureOrder("1", null, "Киев", 800, customer, "1");


        //test furniture order task calculatePrice
        //1.price < 5000
        furnitureOrder.calculatePrice();
        System.out.println(furnitureOrder.getTotalPrice());
        //2.price > 5000
        furnitureOrder = new FurnitureOrder("1", null, "Киев", 6000, customer, "1");
        furnitureOrder.calculatePrice();
        System.out.println(furnitureOrder.getTotalPrice());









        System.out.println("");
        furnitureOrder.confirmShipping();
        System.out.println(furnitureOrder.getDateShipped());

        ElectronicsOrder electronicsOrder = new ElectronicsOrder("1", new Date(), "Харьков", 1001, customer, 1);
        electronicsOrder.calculatePrice();
        System.out.println(electronicsOrder.getTotalPrice());

        electronicsOrder.validateOrder();
        System.out.println(electronicsOrder.getDateConfirmed());

        electronicsOrder.confirmShipping();
        System.out.println(electronicsOrder.getDateShipped());

    }
}
