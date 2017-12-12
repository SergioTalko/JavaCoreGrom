package finalProgect.dao;

import finalProgect.entity.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OrderDAO extends GeneralDAO<Order> {


    public static final String ORDER_DB = "E://data//Order.txt";

    public Order addOrder(Order order) throws Exception {
        return add(ORDER_DB, order);
    }


    public ArrayList<Order> getAll() throws Exception {
        ArrayList<Order> orders = new ArrayList<>();
        String stringOrder;


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ORDER_DB))) {
            while ((stringOrder = bufferedReader.readLine()) != null) {
                orders.add(Order.createObjectFromString(stringOrder));
                //TODO
            }

        } catch (IOException e) {
            System.err.println("Method " + getAll() + " is closed.Try again later");
        }catch (NumberFormatException e) {
            System.err.println("Please check data on this path " + ORDER_DB + " You have wrong format data there");
        }
        return orders;
    }


    public void deleteOrder(Order order) throws Exception {
        delete(ORDER_DB, order);
    }
}
