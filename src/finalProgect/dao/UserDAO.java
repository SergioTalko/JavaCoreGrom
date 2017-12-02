package finalProgect.dao;

import finalProgect.entity.User;

import java.io.*;

public class UserDAO  extends GeneralDAO<User>{

    public static final String USER_DB = "E://data//UserDB.txt";

    public User registerUser(User user) throws Exception {
        return add(USER_DB,user);
    }

    private boolean findDuplicate(User user){
        //TODO
       return false;
    }
}
