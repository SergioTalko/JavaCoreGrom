package lesson22.repository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        User user = new User(1001, "Daniil", "32hdjgfhbfjb");
        userRepository.save(user);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        User user2 = new User(1002, "Andrey", "3gfgfgfg");
        userRepository.save(user2);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        User user3 = new User(1001, "Tset", "3gfgfgfvcfdg");
        userRepository.update(user3);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        userRepository = new UserRepository();
        System.out.println(Arrays.deepToString(userRepository.getUsers()));



    }
}
