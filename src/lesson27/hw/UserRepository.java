package lesson27.hw;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;
import java.util.function.UnaryOperator;

public class UserRepository {

    private ArrayList<User> users = new ArrayList<>();


    public User save(User user) throws Exception {

        if (user == null || users == null) throw new Exception("User or Array is null");

        if (!users.contains(user)) {
            users.add(user);
            return user;
        } else throw new Exception("Cant save user with name " + user.getName() + " maybe it already exist");

    }

    public User update(User user) throws Exception {
        if (user == null || users == null) throw new Exception("User or Array is null");


 /*       UnaryOperator<User> operator = new UnaryOperator<User>() {
            @Override
            public User apply(User userBeforeSave) {
                return (userBeforeSave != null && userBeforeSave.getId() == user.getId() ? user : userBeforeSave);
            }
        };*/

            users.replaceAll(userBeforeSave -> userBeforeSave != null && userBeforeSave.getId() == user.getId() ? user : userBeforeSave);


        return user;

    }

    public void delete(long id) throws Exception {

        users.remove(findById(id));
    }


    private User findById(long id) throws Exception {
        if (users == null) throw new Exception("Array is null");
        if (id <= 0) throw new Exception(id + " is incorrect");
        if (users.isEmpty()) throw new Exception("List is empty");

        int count = 0;
        for (User user : users) {
            if (user != null && user.getId() == id) {
                return users.get(count);
            }
            count++;
        }

        throw new Exception(id + " not found");
    }


    public ArrayList<User> getUsers() {
        return users;
    }
}
