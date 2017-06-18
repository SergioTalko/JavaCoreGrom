package lesson14.HomeWork;

import java.util.Arrays;

public class DemoController {
    public static void main(String[] args) {
        Controller controller = new Controller();
        User librarian1 = new User(2, "1", "1", "1", "1", "1", 1, UserType.librarian, false);
        Book book = new Book(1, "1", "1", "1", "1", 1, 1, null);

        User[] us = controller.getUserRepository().getUsers();


        //admin login
        controller.userRepository.userLogin(1, "admin", "admin123");
        //check login
        System.out.println(controller.checkLogin(us[0]));
        //array users
        System.out.println(Arrays.toString(controller.viewLibrarian(1)));
        //save librarian
        controller.saveLibrarian(1, librarian1);
        //array user
        System.out.println(Arrays.toString(controller.viewLibrarian(1)));
        //admin logout
        controller.userRepository.userLogout(1);
        //check logout
        System.out.println(controller.checkLogin(us[0]));
        //librarian login
        controller.userRepository.userLogin(2, "1", "1");
        //check librarian login
        System.out.println(controller.checkLogin(librarian1));
        //array users(admin logout)
        System.out.println(Arrays.toString(controller.viewLibrarian(1)));
        //array books(array is empty)
        System.out.println(Arrays.toString(controller.viewBooks(1)));
        //save book
        controller.saveBook(2, book);
        //array books
        System.out.println(Arrays.toString(controller.viewBooks(2)));




    }
}
