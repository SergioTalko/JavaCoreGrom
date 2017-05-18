package lesson8.ads;

import java.util.Date;

/**
 * Created by SERGIO on 05.04.2017.
 */
public class CarAd extends Ad {
    int price;
    int yearOfManufacturing;
    String color;
    String ownerName;
    double weight;
    int horsePower;

    public CarAd(long id, int price) {
        super(id, price);
    }

    void confirmAd(){
        // some logic
    }
}


