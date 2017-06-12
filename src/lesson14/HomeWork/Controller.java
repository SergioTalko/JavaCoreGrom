package lesson14.HomeWork;

import java.util.Arrays;

public class Controller {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Librarian librarian1 = new Librarian(1, "1", "1", "1", "1", "1", 1);
        Book book = new Book(1, "1", "1", "1", "1", 1, 1, null);
        controller.saveBook(librarian1.getId(), book);
        System.out.println( Arrays.toString(controller.viewBooks(1)));
        controller.issueBook(librarian1.getId(), 1);
        System.out.println( Arrays.toString(controller.viewBooks(1)));
        System.out.println( Arrays.toString(controller.viewIssuedBooks(1)));
    }

    BookRepository bookRepository = new BookRepository();


    public void saveBook(long idLibrarian, Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(long idLibrarian, long idBook) {
        bookRepository.delete(idBook);
    }

    public Book[] viewBooks(long idLibrarian) {
        return bookRepository.view();

    }

    public void updateBook(long idLibrarian, Book book) {
        bookRepository.update(book);
    }

    public void issueBook(long idLibrarian, long idBook) {
        bookRepository.issue(idBook);
    }

    public void returnBook(long idLibrarian, long idBook) {
        bookRepository.returnBook(idBook);
    }

    public Book[] viewIssuedBooks(long idLibrarian) {
        return bookRepository.viewIssuedBooks();
    }


}
