package lesson30.hw;

import java.util.ArrayList;

public class CustomerDAO {

    private static ArrayList<Customer> customers = new ArrayList<>();



    public CustomerDAO() {
        customers.add(new Customer("customer1","test",100));
        customers.add(new Customer("customer2","test",1001));
        customers.add(new Customer("customer3","test",1002));
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
}
