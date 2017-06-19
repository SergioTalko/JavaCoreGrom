package lesson14.HomeWork;

import java.util.Arrays;

public class DemoUsersRepository {
    public static void main(String[] args) {
        UserRepository adminRepository = UserRepository.getInstance();
        User librarian1 = new User(1, "1", "1", "1", "1", "1", 1, UserType.librarian, false);
        User librarian2 = new User(2, "2", "2", "1", "1", "1", 1, UserType.librarian, false);

        librarian2 = new User(2, "2", "3", "1", "1", "1", 1, UserType.librarian, false);
        //System.out.println(Arrays.toString(adminRepository.view()));
        adminRepository.saveUser(librarian1);
        adminRepository.saveUser(librarian2);
        System.out.println(Arrays.toString(adminRepository.view()));

        /*adminRepository.updateUser(librarian2);
        System.out.println(Arrays.toString(adminRepository.view()));
        adminRepository.delete(2);
        System.out.println(Arrays.toString(adminRepository.view()));
        System.out.println("");
        adminRepository.userLogin(3, "admin", "admin123");
        System.out.println(Arrays.toString(adminRepository.view()));
        adminRepository.userLogout(3);
        System.out.println(Arrays.toString(adminRepository.view()));*/

    }
}
