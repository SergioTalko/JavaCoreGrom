package finalProgect.services;

import finalProgect.controller.Session;
import finalProgect.dao.UserDAO;
import finalProgect.entity.User;



public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User registerUser(User user) throws Exception {

        return userDAO.registerUser(user);
    }

    public void login(String name, String password) throws Exception {
        if (name == null || password == null) throw new NullPointerException("You put null for checking");
        for (User user : userDAO.getAll()) {
            if (user.getUserName().equals(name) && user.getPassword().equals(password)) {
                 Session.getInstance().login(user);
            }
        }

    }


}
