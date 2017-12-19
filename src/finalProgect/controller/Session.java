package finalProgect.controller;

import finalProgect.entity.User;
import finalProgect.entity.UserType;

public class Session {
    private static Session instance;

    private static User user;

    public static Session getInstance() {
        if (instance == null)
            instance = new Session();
        return instance;
    }

    public static void login(User user) {
        if (instance != null) {
            instance.user = user;
        }
    }

    public static void logout() {
        instance.user = null;
    }

    public static User getUser() {
        return user;
    }
}
