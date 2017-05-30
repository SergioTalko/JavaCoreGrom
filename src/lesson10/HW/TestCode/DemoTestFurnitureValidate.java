package lesson10.HW.TestCode;

import lesson10.HW.Customer;
import lesson10.HW.FurnitureOrder;

public class DemoTestFurnitureValidate {
    public static void main(String[] args) {
        Customer customer = new Customer("1", "Киев", "Женский");
        FurnitureOrder furnitureOrder = new FurnitureOrder("1", null, "Киев", 800, customer, "1");

        //furnitureOrder validate заказ возможен только с Киева и Львова и в любой город. Минимальная цена заказа 500.        //Так же имя клиента который делает заказ не может быть "Тест", а пол может быть любым
        //1. валідація по Киев  Минимальная цена заказа > 500 Имя != "Тест"
        furnitureOrder = new FurnitureOrder("1", null, "Киев", 6000, customer, "1");
        furnitureOrder.validateOrder();
        System.out.println(furnitureOrder.getDateConfirmed());
        furnitureOrder.setDateConfirmed(null);
        //2. валідація  wrong city  Минимальная цена заказа > 500 Имя != "Тест"
        customer = new Customer("1", "Тест", "Женский");
        furnitureOrder = new FurnitureOrder("1", null, "Киев", 6000, customer, "1");
        furnitureOrder.validateOrder();
        System.out.println(furnitureOrder.getDateConfirmed());
        furnitureOrder.setDateConfirmed(null);
        //3. валідація Киев  Минимальная цена заказа < 500 Имя != "Тест"
        customer = new Customer("1", "Киев", "Женский");
        furnitureOrder = new FurnitureOrder("1", null, "Киев", 400, customer, "1");
        furnitureOrder.validateOrder();
        System.out.println(furnitureOrder.getDateConfirmed());
        furnitureOrder.setDateConfirmed(null);
        //4. валідація Киев  Минимальная цена заказа > 500 Имя == "Тест"
        customer = new Customer("Тест", "Киев", "Женский");
        furnitureOrder = new FurnitureOrder("1", null, "Киев", 700, customer, "1");
        furnitureOrder.validateOrder();
        System.out.println(furnitureOrder.getDateConfirmed());
        //5. валідація  Львов  Минимальная цена заказа > 500 Имя != "Тест"
        customer = new Customer("1", "Львов", "Женский");
        furnitureOrder = new FurnitureOrder("1", null, "Киев", 6000, customer, "1");
        furnitureOrder.validateOrder();
        System.out.println(furnitureOrder.getDateConfirmed());

    }
}
