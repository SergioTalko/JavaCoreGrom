package lesson7.HomeWork;

import lesson6.HomeWork.Order;

import java.util.Date;

public class DemoHomeWork {

    public Order createOrder() {
        Order createDemo = new Order();
        createDemo = createDemo.createObject();

        return createDemo;
    }

    public Order createOrderAndCallMethods() {
        Order createCall = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        createCall.checkPrice();
        createCall.isValidType();
        createCall.confirmOrder();

        return createCall;

    }

}
