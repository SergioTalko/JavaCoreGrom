package finalProgect.services;

import finalProgect.dao.HotelDAO;
import finalProgect.dao.OrderDAO;
import finalProgect.dao.RoomDAO;
import finalProgect.dao.UserDAO;
import finalProgect.entity.Hotel;
import finalProgect.entity.Order;
import finalProgect.entity.Room;
import finalProgect.entity.User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderService {

    private OrderDAO orderDAO = new OrderDAO();
    private UserDAO userDAO = new UserDAO();
    private RoomDAO roomDAO = new RoomDAO();


    public void bookRoom(long roomId, long userId) throws Exception {

        User user = userDAO.findUserById(userId);
        Room room = roomDAO.findRoomById(roomId);


        Order order = orderDAO.addOrder(new Order(user, room, room.getDateAvailableFrom(),new Date(), room.getPrice()) );


        long difference = order.getDateTo().getTime()  - order.getDateFrom().getTime();
        long days = difference/(24*60*60*1000);
        order.setMoneyPaid(order.getMoneyPaid() * days); // price and int days in order
        room.setDateAvailableFrom(order.getDateTo()); //change availible date to room

        roomDAO.updateRoom(room); //update availible date in DB


    }

    public void cancelReservation(long roomId, long userId) throws Exception {

        Room roomForCancel = roomDAO.findRoomById(roomId);

        for (Order order : orderDAO.getAll()) {
            if (order.getRoom().getId() == roomId && order.getUser().getId() == userId) {
                roomForCancel.setDateAvailableFrom(order.getDateFrom());
                orderDAO.deleteOrder(order);
                roomDAO.updateRoom(roomForCancel);
                break;
            }


        }


    }


}
