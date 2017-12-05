package finalProgect.controller;

import finalProgect.entity.User;
import finalProgect.services.UserService;

public class UserController {
    private UserService userService = new UserService();




    public User registerUser(User user) throws Exception {
        return userService.registerUser(user);

    }

    public void login(String name, String password) throws Exception {
     userService.login(name, password);
    }

    public void logout() {
       UserLogin.logout();
    }
}
