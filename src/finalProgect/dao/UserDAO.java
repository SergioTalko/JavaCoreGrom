package finalProgect.dao;

import finalProgect.entity.User;
import finalProgect.entity.UserType;
import finalProgect.exceptions.BadRequestException;
import finalProgect.exceptions.FormatDataInDatabaseException;
import finalProgect.exceptions.HasDuplicateException;

import java.io.*;
import java.util.ArrayList;

public class UserDAO extends GeneralDAO<User> {

    public UserDAO() {
        super.setPath("E://data//UserDB.txt");
    }

    public User registerUser(User user) throws Exception {
        if (findDuplicate(user))
            throw new HasDuplicateException("User with name " + user.getUserName() + " already exists");
        return add(user);
    }


    public ArrayList<User> getAll() throws Exception {

        return super.getAll();
    }


    public User findUserById(long id) throws Exception {
        if (id <= 0) throw new BadRequestException("Please check you id " + id);

        for (User user : getAll()) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new BadRequestException("Cant find user with id " + id);
    }

    private boolean findDuplicate(User user) throws Exception {
        if (user == null) throw new NullPointerException("User in is null");
        for (User user1 : getAll()) {
            if (user1.equals(user)) {
                return true;
            }
        }
        return false;
    }

    public User createObjectFromString(String stringUser) throws FormatDataInDatabaseException {
        String[] userFields = stringUser.split(",");
        if (userFields.length != 5) throw new FormatDataInDatabaseException("Please check data in DB");

        long id = Long.parseLong(userFields[0]);
        String name = userFields[1];
        String password = userFields[2];
        String country = userFields[3];
        UserType type = UserType.valueOf(userFields[4]);


        User resultUser = new User(name, password, country);
        resultUser.setId(id);
        resultUser.setUserType(type);
        return resultUser;

    }
}
