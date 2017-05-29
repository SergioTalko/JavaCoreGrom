package lesson10.HW;

public class DemoConfirmShipping {
    public static void main(String[] args) {
        Customer customer = new Customer("1", "Киев", "Женский");
        ElectronicsOrder electronicsOrder = new ElectronicsOrder("1", null, "Львов", 100, customer, 1);


        //test code confirm shipping
        //1.Date shipped == null
        System.out.println(electronicsOrder.getDateShipped());
        //2. Проставить поточну дату якщо null
        electronicsOrder.confirmShipping();
        System.out.println(electronicsOrder.getDateShipped());
        //3. Проставить поточну дату якщо вона вже стоїть
        electronicsOrder.confirmShipping();
        System.out.println(electronicsOrder.getDateShipped());


    }
}
