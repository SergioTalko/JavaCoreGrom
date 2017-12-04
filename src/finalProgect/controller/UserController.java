package finalProgect.controller;

import finalProgect.entity.User;
import finalProgect.services.UserService;

public class UserController {
    private UserService userService = new UserService();
    public static User isLogin = null;

    public User registerUser(User user) throws Exception {
        return userService.registerUser(user);

    }

    public void login(String name, String password) throws Exception {
      isLogin = userService.login(name, password);
    }

    public void logout() {
        isLogin = null;
    }
}
