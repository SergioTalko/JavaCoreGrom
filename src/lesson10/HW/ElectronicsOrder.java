package lesson10.HW;

import java.util.Date;

/**
 * Created by SERGIO on 21.04.2017.
 */
public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }


    @Override
    public void validateOrder() {

        boolean isValidCity = false;
        boolean isValidShipCity = false;
        String[] validCityCustomer = {"Киев", "Днепр", "Одесса", "Харьков"};
        String[] validCityShiped = {"Киев", "Днепр", "Одесса", "Харьков"};

        for (int i = 0; i < validCityCustomer.length; i++) {
            if (getCustomerOwned().getCity() == validCityCustomer[i]) {
                isValidCity = true;
            }
        }
        for (int i = 0; i < validCityShiped.length; i++) {
            if (getShipToCity() == validCityShiped[i]) {
                isValidShipCity = true;
            }
        }

        if (isValidCity && isValidShipCity && getBasePrice() > 100 && getCustomerOwned().getGender() == "Женский") {
            setDateConfirmed(new Date());
        }
    }

    @Override
    public void calculatePrice() {
        double comission;
        String[] cityLowComission = {"Киев", "Одесса"};
        for (int i = 0; i < cityLowComission.length; i++) {
            if (getShipToCity() == cityLowComission[i]) {
                comission = getBasePrice() * 0.1;
            } else {
                comission = getBasePrice() * 0.15;
            }
            setTotalPrice(getBasePrice() + comission);


            if (getBasePrice() > 1000) {
                setTotalPrice(getTotalPrice() - (getTotalPrice() * 0.05));
            }
        }

    }

    @Override
    public void confirmShipping() {
        super.confirmShipping();
    }
}

