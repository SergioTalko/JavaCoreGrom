package lesson14.HomeWork;

import java.util.Arrays;

public class DemoController {
    public static void main(String[] args) {
        Controller controller = new Controller();
        User librarian1 = new User(2, "1", "1", "1", "1", "1", 1, UserType.librarian, false);
        Book book = new Book(1, "1", "1", "1", "1", 1, 1, null);

        User[] us = controller.getUserRepository().getUsers();


        //admin login
        controller.userLogin(us[0]);
        //array users
        System.out.println(Arrays.toString(controller.viewLibrarian(1)));
        //save librarian
        controller.saveLibrarian(1, librarian1);
        //array user
        System.out.println(Arrays.toString(controller.viewLibrarian(1)));
        //admin logout
        controller.userLogout(us[0]);
        //librarian login
        controller.userLogin(librarian1);
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
