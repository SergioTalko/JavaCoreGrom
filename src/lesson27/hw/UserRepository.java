package lesson27.hw;


import java.util.ArrayList;

public class UserRepository {

    private ArrayList<User> users = new ArrayList<>();


    public User save(User user) throws Exception {
        if (user == null) throw new Exception("User is null");

        if (!users.contains(user)) {
            users.add(user);
            return user;
        } else throw new Exception("Cant save user with name " + user.getName() + " maybe it already exist");

    }

    public User update(User user) throws Exception {
        if (user == null) throw new Exception("User is null");


        if (users.contains(findById(user.getId()))) {
            users.set(users.indexOf(findById(user.getId())), user);
            return user;
        }


        throw new Exception("Cant update user with namme " + user.getName());
    }

    public void delete(long id) throws Exception {

        users.remove(findById(id));
    }


    private User findById(long id) throws Exception {

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
