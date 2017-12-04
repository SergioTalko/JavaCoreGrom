package finalProgect.services;

import finalProgect.dao.UserDAO;
import finalProgect.entity.User;
import lesson20.task1.exception.UserNotFoundException;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User registerUser(User user) throws Exception {
        //busines logic
        //validation
        return userDAO.registerUser(user);
    }

    public User login(String name, String password) throws Exception {
        if (name == null || password == null) throw new NullPointerException("You put null for checking");
        for (User user : userDAO.getAllUsers()) {
            if (user.getUserName().equals(name) && user.getPassword().equals(password)) {
                return user;
            }
        }
       throw new UserNotFoundException("This user not found.Please login or register");
    }





}
