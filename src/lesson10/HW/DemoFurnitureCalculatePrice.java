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
        //коммисия за доставку - 5% от суммы заказа если сумма меньше 5000 и 2% в других случаях
        //1.price < 5000
        furnitureOrder.calculatePrice();
        System.out.println(furnitureOrder.getTotalPrice());
        //2.price > 5000
        furnitureOrder = new FurnitureOrder("1", null, "Киев", 6000, customer, "1");
        furnitureOrder.calculatePrice();
        System.out.println(furnitureOrder.getTotalPrice());

    }
}
