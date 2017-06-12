package lesson14.HomeWork;

public class UserRepository {
    User[] users = new User[5];


    public User saveUser(User user) {
        if (users == null) {
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

    public User updateUser(User user) {
        if (user == null) {
            return null;
        }

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

        int index = 0;
        User user = findById(id);

        for (User indexUser : users) {
            if (indexUser == user) {
                users[index] = null;
                break;
            }
            index++;
        }
    }

    public User[] view() {
        int count = 0;
        for (User user : users) {
            if (user != null) {
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Users not found ");
            return null;
        }
        User[] usersArray = new User[count];
        int index = 0;
        for (User user : users) {
            if (user != null) {
                usersArray[index] = user;
                index++;
            }
        }

        return usersArray;
    }

    private User findById(long id) {
        for (User librarian : users) {
            if (librarian != null && librarian.getId() == id) {
                return librarian;
            }
        }
        return null;
    }


}
