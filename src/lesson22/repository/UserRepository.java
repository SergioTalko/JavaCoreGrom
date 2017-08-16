package lesson22.repository;

public class UserRepository {

    private static User[] users = new User[10];


    public static User save(User user) {
        if (user == null) {
            return null;
        }
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
            if (users[i] == user) return null;

            if (users[i] == null) {
                users[i] = user;
                return users[i];
            }
        }
        return null;
    }

    public static User update(User user) {
        if (user == null) {
            return null;
        }

        User findUserById = findById(user.getId());

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

    public static void delete(long id) {

        int index = 0;
        User user = findById(id);

        for (User us : users) {
            if (us == user) {
                users[index] = null;
                break;
            }
            index++;
        }
    }

    public static User getFindUserById(long id) {
        return findById(id);
    }

    public static User[] getUsers() {
        return users;
    }

    private static User findById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
