package lesson7;

import lesson6.HomeWork.Order;

import java.util.Date;

/**
 * Created by SERGIO on 01.04.2017.
 */
public class DemoHomeWork {

    public static Order createOrder() {
        Order createDemo = new Order();
        createDemo = createDemo.createObject();

        return createDemo;
    }

    public static Order createOrderAndCallMethods() {
        Order createCall = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        createCall.checkPrice();
        createCall.isValidType();
        createCall.confirmOrder();

        return createCall;

    }

}
