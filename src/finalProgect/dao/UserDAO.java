package finalProgect.dao;

import finalProgect.entity.User;

import java.io.*;

public class UserDAO {

    private static final String USER_DB = "E://data//UserDB.txt";

    public User registerUser(User user) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(USER_DB, true))) {

            if (new File(USER_DB).length() == 0) {
                bufferedWriter.append(user.toString());
            } else {
                bufferedWriter.newLine();
                bufferedWriter.append(user.toString());
            }
        } catch (IOException e) {
            System.err.println("Cant add user " + user.getUserName());
        }
        return user;
    }
}
