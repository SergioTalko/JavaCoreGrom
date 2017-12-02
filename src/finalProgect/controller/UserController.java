package finalProgect.controller;

import finalProgect.entity.User;
import finalProgect.services.UserService;

public class UserController {
    UserService userService = new UserService();

  public User registerUser(User user) throws Exception {
      return userService.registerUser(user);

  }
}
