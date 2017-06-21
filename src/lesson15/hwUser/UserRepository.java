package lesson15.hwUser;

public class UserRepository {

    private User[] users = new User[10];


    public User save(User user) {
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
            if (users[i] != null && users[i].equals(user) && users[i].hashCode() == user.hashCode()) {
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
        if (user == null) return null;

        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == user.getId()) {
                return users[i] = user;
            }
        }
        return null;
    }


    public void delete(User user) {

        int index = 0;
        for (User us : users) {
            if (us != null && us.equals(user) && us.hashCode() == user.hashCode()) {
                users[index] = null;
                break;
            }
            index++;
        }
    }


    public User[] getUsers() {
        return users;
    }
}
