package lesson15.hwUser;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        User[] users = userRepository.getUsers();
        User user = new User(1, "1", "1");


        //test code method save
        //1.save
        userRepository.save(user);
        System.out.println(Arrays.toString(users));
        //2.same user
        System.out.println(userRepository.save(user));
        System.out.println(Arrays.toString(users));
        //3.null
        userRepository.save(null);
        System.out.println(Arrays.toString(users));
        //4.full array
        int n = 2;
        while (n < 15) {
            User user1 = new User(n, "Test", "1jf");
            System.out.println(userRepository.save(user1));
            n++;
        }
        userRepository.save(user);
        System.out.println(Arrays.toString(users));


        //task method update
        //1.update user
        user = new User(1, "Test", "asjhk");
        userRepository.update(user);
        System.out.println(Arrays.toString(users));
        //2.null
        userRepository.update(null);
        System.out.println(Arrays.toString(users));
        //3.not user in array
        user = new User(1999, "Test", "asjhk");
        System.out.println(userRepository.update(user));
        System.out.println(Arrays.toString(users));



        //task method delete
        //1.delete
        user = new User(1, "Test", "asjhk");
        userRepository.delete(user);
        System.out.println(Arrays.toString(users));
        //2.dont have user in array
        userRepository.delete(null);
        System.out.println(Arrays.toString(users));
        //3. видалення в пустому масиві


       /* n = 2;
        while (n < 15) {
            userRepository.delete(user);
            n++;
        }
        System.out.println(Arrays.toString(users));*/

    }

}
