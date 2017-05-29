package lesson10.HW;

public class DemoElectronicsValidate {
    public static void main(String[] args) {
        Customer customer = new Customer("1", "Киев", "Женский");
        ElectronicsOrder electronicsOrder = new ElectronicsOrder("1", null, "Киев", 800, customer, 1);


        //заказ возможен с Киева, Одессы, Днепра, Харькова и в один из этих городов. Минимальная цена заказа 100.
        //Так же имя клиента который делает заказ может быть любым, а пол только женским
        //furnitureOrder validate
        //1. валідація from Киев to Киев  Минимальная цена заказа > 100 пол == "Женский"---valid
        electronicsOrder.validateOrder();
        System.out.println(electronicsOrder.getDateConfirmed());
        electronicsOrder.setDateConfirmed(null);
        //2. валідація  wrong city  Минимальная цена заказа > 100 пол == "Женский"---not valid
        customer = new Customer("1", "Тест", "Женский");
        electronicsOrder = new ElectronicsOrder("1", null, "Киев", 6000, customer, 1);
        electronicsOrder.validateOrder();
        System.out.println(electronicsOrder.getDateConfirmed());
        electronicsOrder.setDateConfirmed(null);
        //3. валідація cities valid  Минимальная цена заказа < 100 пол == "Женский"--- not valid
        customer = new Customer("1", "Киев", "Женский");
        electronicsOrder = new ElectronicsOrder("1", null, "Киев", 90, customer, 1);
        electronicsOrder.validateOrder();
        System.out.println(electronicsOrder.getDateConfirmed());
        electronicsOrder.setDateConfirmed(null);
        //4.  валідація cities valid  Минимальная цена заказа > 100 пол == "Мужской"--- not valid
        customer = new Customer("Тест", "Киев", "Мужской");
        electronicsOrder = new ElectronicsOrder("1", null, "Киев", 700, customer, 1);
        electronicsOrder.validateOrder();
        System.out.println(electronicsOrder.getDateConfirmed());
        //5. валідація  from Днепр to Одесса  Минимальная цена заказа > 100 пол == "Женский" ---valid
        customer = new Customer("1", "Днепр", "Женский");
        electronicsOrder = new ElectronicsOrder("1", null, "Одесса", 6000, customer, 1);
        electronicsOrder.validateOrder();
        System.out.println(electronicsOrder.getDateConfirmed());
        electronicsOrder.setDateConfirmed(null);
    }
}

