package lesson10.HW;

import java.util.Date;

/**
 * Created by SERGIO on 21.04.2017.
 */
public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        String[] validCity = {"Киев", "Львов"};
        for (int i = 0; i < validCity.length; i++) {
            if (validCity[i] == getCustomerOwned().getCity() && getBasePrice() > 500 && getCustomerOwned().getName() != "Тест") {
                setDateConfirmed(new Date());
            }
        }
    }

    @Override
    public void calculatePrice() {
        double comission;
        if (getBasePrice() < 5000.0) {
            comission = getBasePrice() * 0.05;
        } else {
            comission = getBasePrice() * 0.02;
        }
        setTotalPrice(getBasePrice() + comission);
    }

    @Override
    public void confirmShipping() {
        super.confirmShipping();
    }
}
