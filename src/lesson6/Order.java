package lesson6;


import java.util.Date;

/**
 * Created by SERGIO on 29.03.2017.
 */
public class Order {

    long id;
    int price;
    Date dateCreated;
    boolean isConfirmed;
    Date dateConfirmed;
    String city;
    String country;
    String type;


    public Order(int price, Date dateCreated, boolean isConfirmed, Date dateConfirmed, String city, String country, String type) {
        this.price = price;
        this.dateCreated = dateCreated;
        this.isConfirmed = isConfirmed;
        this.dateConfirmed = dateConfirmed;
        this.city = city;
        this.country = country;
        this.type = type;
    }

    public Order() {
    }

    public void confirmOrder() {
        if (isConfirmed == false) {
            isConfirmed = true;
            dateConfirmed = new Date();
        }

    }

    public boolean checkPrice() {

        return price > 1000 ? true : false;
    }

    public boolean isValidType() {
        boolean isValid = false;

        if (type == "Buy") {
            isValid = true;
        }
        if (type == "Sale") {
            isValid = true;
        }
        return isValid;
    }

    public Order createObject() {
        Order create = new Order(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");

        return create;
    }

}


