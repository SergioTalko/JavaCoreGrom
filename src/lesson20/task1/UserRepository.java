package lesson20.task1;

import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServerException;
import lesson20.task1.exception.UserNotFoundException;

public class UserRepository {

    private User[] users = new User[10];


    public User save(User user) throws Exception {
        if (user == null) throw new UserNotFoundException("User is null");

        if (users == null) throw new InternalServerException(" Storage is null");

        if (checkSpaceInStorage() == 0) throw new InternalServerException("Not enough space to save user");


        if (findById(user.getId()) != null)
            throw new BadRequestException("User with id " + user.getId() + " already saved in storage");

        return saveUser(user);

    }

    public User update(User user) throws Exception {
        if (user == null) throw new UserNotFoundException("User is null");

        if (users == null) throw new InternalServerException("Storage is null");

        if (findById(user.getId()) == null)
            throw new BadRequestException("User with id " + user.getId() + " cant find in storage");

        return updateUser(user);
    }

    public void delete(long id) throws Exception {
        if (users == null) throw new InternalServerException("Storage is null");


        int index = 0;
        User user = findById(id);

        if (findById(user.getId()) == null)
            throw new BadRequestException("User with id " + user.getId() + " cant find in storage");

        for (User us : users) {
            if (us == user) {
                users[index] = null;
                break;
            }
            index++;
        }
    }

    private User findById(long id) {


        for (User user : users) {
            if (user != null && user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    private int checkSpaceInStorage() {
        int count = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                count++;
            }
        }
        return count;
    }

    private User saveUser(User user) throws Exception {

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return users[i];
            }
        }
        throw new InternalServerException("Please try again later");
    }

    private User updateUser(User user) throws Exception {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == user.getId()) {
                return users[i] = user;
            }
        }
        throw new InternalServerException("Please try again later");
    }

    public User getFindUserById(long id) throws Exception {
        return findById(id);
    }

    public User[] getUsers() {
        return users;
    }

}
