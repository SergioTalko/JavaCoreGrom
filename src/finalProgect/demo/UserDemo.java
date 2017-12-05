package finalProgect.demo;

import finalProgect.controller.HotelController;
import finalProgect.controller.UserController;
import finalProgect.controller.UserLogin;
import finalProgect.dao.UserDAO;
import finalProgect.entity.Hotel;
import finalProgect.entity.User;


public class UserDemo {
    public static void main(String[] args) throws Exception {
        User user = new User("First1", "Test", "UK");
        UserDAO userDAO = new UserDAO();
     //  userDAO.registerUser(user);
       System.out.println((userDAO.getAllUsers()));

      UserController userController = new UserController();
        HotelController hotelController = new HotelController();
      userController.login("First1", "Test");
        userController.login("First","Test");
        Hotel hotel = new Hotel("Ritz","Spain", "Madrid", "La Cafe");
userController.logout();
        hotelController.addHotel(hotel);







    }
}
