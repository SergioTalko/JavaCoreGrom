package lesson8.phone;

/**
 * Created by SERGIO on 05.04.2017.
 */
public class Phone {
    int price;
    double weight;
    String countryProduced;

    public Phone(int price, double weight, String countryProduced) {
        this.price = price;
        this.weight = weight;
        this.countryProduced = countryProduced;
    }

    void orderPhone(){
        //some logic
        System.out.println("Order");
    }
}
