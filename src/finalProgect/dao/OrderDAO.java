package finalProgect.dao;

import finalProgect.entity.Order;
import finalProgect.entity.Room;
import finalProgect.entity.User;
import finalProgect.exceptions.FormatDataInDatabaseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderDAO extends GeneralDAO<Order> {

    private UserDAO userDAO = new UserDAO();
    private RoomDAO roomDAO = new RoomDAO();

    public OrderDAO() {
        super.setPath("E://data//Order.txt");
    }

    public Order addOrder(Order order) throws Exception {
        return add( order);
    }


    public ArrayList<Order> getAll() throws Exception {
       return super.getAll();
    }


    public void deleteOrder(Order order) throws Exception {
        delete( order);
    }

    public void update(Order order) throws Exception {
        super.update(order);
    }

    public Order createObjectFromString(String stringOrder) throws Exception {
        String[] orderFields = stringOrder.split(",");
        if (orderFields.length != 6) throw new FormatDataInDatabaseException("Please check data in DB");
        String changeCharsUser = orderFields[1].replace(":", ",");
        String changeCharsRoom =   orderFields[2].replace(":", ",");

        // System.out.println(changeCharsRoom.length());
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        long id = Long.parseLong(orderFields[0]);
        User user = userDAO.createObjectFromString(changeCharsUser);
        Room room = roomDAO.createObjectFromString(changeCharsRoom);
        Date dateFrom = df.parse(orderFields[3]);
        Date dateTo = df.parse(orderFields[4]);
        double moneyPaid = Double.parseDouble(orderFields[5]);


        Order order = new Order(user, room, dateFrom, dateTo, moneyPaid);
        order.setId(id);
        return order;

    }
}
