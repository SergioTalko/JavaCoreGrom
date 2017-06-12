package lesson14.HomeWork;

import java.util.Arrays;

public class DemoController {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Librarian librarian1 = new Librarian(1, "1", "1", "1", "1", "1", 1);
        Book book = new Book(1, "1", "1", "1", "1", 1, 1, null);
        controller.saveBook(librarian1.getId(), book);
        System.out.println(Arrays.toString(controller.viewBooks(1)));
        controller.issueBook(librarian1.getId(), 1);
        System.out.println(Arrays.toString(controller.viewBooks(1)));
        System.out.println(Arrays.toString(controller.viewIssuedBooks(1)));
    }
}
