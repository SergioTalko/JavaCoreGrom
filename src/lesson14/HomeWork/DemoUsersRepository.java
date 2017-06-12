package lesson14.HomeWork;

import java.util.Arrays;

/**
 * Created by SERGIO on 12.06.2017.
 */
public class DemoUsersRepository {
    public static void main(String[] args) {
        UserRepository adminRepository = new UserRepository();
        User librarian1 = new User(1, "1", "1", "1", "1", "1", 1, "librarian", false);
        User librarian2 = new User(2, "2", "2", "1", "1", "1", 1, "librarian", false);
        adminRepository.saveUser(librarian1);
        adminRepository.saveUser(librarian2);
        librarian2 = new User(2, "2", "3", "1", "1", "1", 1, "librarian", false);
        System.out.println(Arrays.toString(adminRepository.view()));
        adminRepository.updateUser(librarian2);
        System.out.println(Arrays.toString(adminRepository.view()));
        adminRepository.delete(2);
        System.out.println(Arrays.toString(adminRepository.view()));

    }
}
