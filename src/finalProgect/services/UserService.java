package finalProgect.services;

import finalProgect.dao.UserDAO;
import finalProgect.entity.User;

public class UserService {
    UserDAO userDAO = new UserDAO();

    public User registerUser(User user){
        //busines logic
        return userDAO.registerUser(user);
    }
}
