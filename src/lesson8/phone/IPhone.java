package lesson8.phone;

/**
 * Created by SERGIO on 05.04.2017.
 */
public class IPhone extends Phone {
    boolean fingerprint;

    public IPhone(int price, double weight, String countryProduced, boolean fingerprint) {
        super(price, weight, countryProduced);
        this.fingerprint = fingerprint;
    }

    void deleteIphoneFromDb(){
        //some logic
    }
}
