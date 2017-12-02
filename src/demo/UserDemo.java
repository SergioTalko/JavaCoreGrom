package demo;

import finalProgect.dao.UserDAO;
import finalProgect.entity.User;

public class UserDemo {
    public static void main(String[] args) throws Exception {
        User user = new User("First", "Test", "UK");
        UserDAO userDAO = new UserDAO();
        userDAO.registerUser(user);
    }
}
