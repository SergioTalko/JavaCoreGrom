package lesson10.HW.TestCode;

import lesson10.HW.Customer;
import lesson10.HW.ElectronicsOrder;

public class DemoElectronicsCalculatePrice {
    public static void main(String[] args) {
        Customer customer = new Customer("1", "Киев", "Женский");
        ElectronicsOrder electronicsOrder = new ElectronicsOrder("1", null, "Львов", 100, customer, 1);


        //test electronics order task calculatePrice
        //если доставка производится ни в Киев ни в Одессу, то комиссия - 15% от суммы заказа. В других случаях 10%.          //Так же если цена больше 1000 то скидка на заказ 5% после оплаты комиссии за доставку
        //1.price < 1000 ни в Киев ни в Одессу
        electronicsOrder.calculatePrice();
        System.out.println(electronicsOrder.getTotalPrice());
        //2 price < 1000  в Одессу
        electronicsOrder = new ElectronicsOrder("1", null, "Одесса", 100, customer, 1);
        electronicsOrder.calculatePrice();
        System.out.println(electronicsOrder.getTotalPrice());
        //3 price > 1000  в Одессу
        electronicsOrder = new ElectronicsOrder("1", null, "Одесса", 2000, customer, 1);
        electronicsOrder.calculatePrice();
        System.out.println(electronicsOrder.getTotalPrice());
        //4  price > 1000
        electronicsOrder = new ElectronicsOrder("1", null, "Львов", 2000, customer, 1);
        electronicsOrder.calculatePrice();
        System.out.println(electronicsOrder.getTotalPrice());

    }
}
