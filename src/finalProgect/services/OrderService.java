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
    private HotelDAO hotelDAO = new HotelDAO();


    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {

        User user = userDAO.findUserById(userId);
        Room room = roomDAO.findRoomById(roomId);
        Hotel hotel = hotelDAO.findHotelById(hotelId);

        Order order = orderDAO.addOrder(new Order(user, room, new Date(), new Date(), 0));

        room.setDateAvailableFrom(order.getDateTo()); //change availible date to room

        roomDAO.updateRoom(room); //update availible date in DB


    }

    public void cancelReservation(long roomId, long userId, long hotelId) throws Exception {


        for (Order order : orderDAO.getAll()) {
            if (order.getRoom().getId() == roomId && order.getUser().getId() == userId && order.getRoom().getHotel().getId() == hotelId) {
                roomDAO.findRoomById(roomId).setDateAvailableFrom(order.getDateFrom());
                orderDAO.deleteOrder(order);
                roomDAO.updateRoom(roomDAO.findRoomById(roomId));
            }

        }


    }


}
