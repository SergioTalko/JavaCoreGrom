package lesson9.HomeWork;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by SERGIO on 12.04.2017.
 */
public class UserRepository {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        User[] users1 = userRepository.users;

        System.out.println(Arrays.toString(users1));

        User user = new User(1, "1", "1");
        System.out.println(userRepository.save(user));
        System.out.println(users1[0].getName());

        System.out.println(Arrays.toString(users1));
        user = new User(1, "2", "1");
        userRepository.update(user);
        System.out.println(user.getName());
        userRepository.delete(1);
        System.out.println(Arrays.toString(users1));


    }

    User[] users;


    public UserRepository() {
        users = new User[10];

    }


    private User findById(long id) {
        int index = 0;
        for (int i = index; i < users.length; i++) {
            if (id == users[i].getId()) {
                return users[i];
            }
            index++;
        }
        return null;
    }


    public User save(User user) {
        int count = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i] == user) {
                return null;
            }
            if (users[i] == null) {
                users[i] = user;
                return users[i];
            }
        }
        return null;
    }

    public User update(User user) {


        User findUserById = this.findById(user.getId());

        if (findUserById == null) {
            return null;
        }
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == user.getId()) {
                return users[i] = user;
            }
        }
        return null;
    }


    public void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == id) {
                users[i] = null;
                break;
            }
        }
    }
}
