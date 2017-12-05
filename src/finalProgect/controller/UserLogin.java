package finalProgect.controller;

import finalProgect.entity.User;
import finalProgect.entity.UserType;

public class UserLogin {
    private static UserLogin instance;

    private static long id;
    private static String userName;
    private static UserType userType;

    public static UserLogin getInstance() {
        if (instance == null)
            instance = new UserLogin();
        return instance;
    }

    public static void login(long id, String name, UserType userType) {
        if (instance != null) {
            instance.id = id;
            instance.userName = name;
            instance.userType = userType;
        }
    }

    public static void logout() {
        instance.id = -1;
        instance.userName = null;
        instance.userType = null;
    }

    public static long getId() {
        return id;
    }

    public static UserType getUserType() {
        return userType;
    }

    public static String getUserName() {
        return userName;
    }


}
