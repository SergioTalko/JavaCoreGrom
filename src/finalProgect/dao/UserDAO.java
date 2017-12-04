package finalProgect.dao;

import finalProgect.entity.User;
import finalProgect.exceptions.HasDuplicateException;
import finalProgect.exceptions.UserNotFoundException;

import java.io.*;
import java.util.ArrayList;

public class UserDAO extends GeneralDAO<User> {

    public static final String USER_DB = "E://data//UserDB.txt";

    public User registerUser(User user) throws Exception {
        if (findDuplicate(user))
            throw new HasDuplicateException("User with name " + user.getUserName() + " already exists");
        return add(USER_DB, user);
    }


    public ArrayList<User> getAllUsers() throws Exception {
        ArrayList<User> users = new ArrayList<>();
        String stringUser;


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(USER_DB))) {
            while ((stringUser = bufferedReader.readLine()) != null) {
                users.add(User.createObjectFromString(stringUser));

                //TODO
            }

        } catch (IOException e) {
            System.err.println("Method " + getAllUsers() + " is closed.Try again later");
        }catch (Exception e){
            System.err.println("Please check data in User_DB " + USER_DB + " You have wrong format data there");
        }
        return users;


    }

    private boolean findDuplicate(User user) throws Exception {
        if (user == null) throw new NullPointerException("User in is null");
        for (User user1 : getAllUsers()) {
            if (user1.equals(user)) {
                return true;
            }
        }
        return false;
    }


}
