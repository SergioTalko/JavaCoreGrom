package lesson10.polyexample;

/**
 * Created by SERGIO on 25.04.2017.
 */
public class User extends Human {

    public User(String name) {
        super(name);
    }

    @Override
    void run() {
        System.out.println("User class is called...");
        super.run();

    }
}
