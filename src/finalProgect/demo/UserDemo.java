package finalProgect.demo;

import finalProgect.controller.HotelController;
import finalProgect.controller.RoomController;
import finalProgect.controller.UserController;
import finalProgect.dao.UserDAO;
import finalProgect.entity.Hotel;
import finalProgect.entity.Room;
import finalProgect.entity.User;

import java.util.Date;


public class UserDemo {
    public static void main(String[] args) throws Exception {
        User user = new User("First1", "Test", "UK");
        UserDAO userDAO = new UserDAO();
        //  userDAO.registerUser(user);
        System.out.println((userDAO.getAll()));

        UserController userController = new UserController();
        HotelController hotelController = new HotelController();
        userController.login("First1", "Test");

        Hotel hotel = new Hotel("Ritz", "Spain", "Madrid", "La Cafe");
        Hotel hotel1 = new Hotel("Ritz1", "Spain", "Madrid", "La Cafe");

    //    hotelController.addHotel(hotel);
     //  hotelController.addHotel(hotel1);
    //   hotelController.deleteHotel(hotel);
        Hotel hotel2 = new Hotel("R","R","R","R");
        Room room = new Room(10,200.5,false,true, new Date(), hotel2);
        RoomController roomController = new RoomController();
        roomController.addRoom(room);


    }
}
