package lesson14.HomeWork;

import java.util.Arrays;

public class Controller extends BookRepository {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Librarian librarian1 = new Librarian(1, "1", "1", "1", "1", "1", 1);
        Book book = new Book(1, "1", "1", "1", "1", 1, 1, null);
        controller.saveBook(librarian1.getId(), book);
        System.out.println(Arrays.toString(controller.view()));
        controller.issueBook(librarian1.getId(), 1);
        System.out.println(Arrays.toString(controller.view()));
    }


    public void saveBook(long idLibrarian, Book book) {
        save(book);
    }

    public void deleteBook(long idLibrarian, long idBook) {
        delete(idBook);
    }

    public void viewBooks(long idLibrarian) {
        view();
    }

    public void updateBook(long idLibrarian, Book book) {
        update(book);
    }

    public void issueBook(long idLibrarian, long idBook) {
        issue(idBook);
    }

    public void returnBook(long idLibrarian, long idBook) {
        returnBook(idBook);
    }

    public void viewIssuedBooks(long idLibrarian) {
        viewIssuedBooks();
    }


}
