package lesson20.task1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception {
        UserRepository userRepository = new UserRepository();
        User user = new User(1, "1", "1");
        userRepository.save(user);
        user = new User(2, "1", "1");
        System.out.println(Arrays.toString(userRepository.getUsers()));
        userRepository.save(user);
        System.out.println(Arrays.toString(userRepository.getUsers()));
    }
}
