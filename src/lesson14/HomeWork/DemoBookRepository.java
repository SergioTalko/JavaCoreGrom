package lesson14.HomeWork;

import java.util.Arrays;

/**
 * Created by SERGIO on 10.06.2017.
 */
public class DemoBookRepository {
    public static void main(String[] args) {
        Book book = new Book(1, "1", "One", "1", "1", 1, 0, null);
        Book book2 = new Book(2, "2", "Two", "2", "2", 1, 0, null);
        Book book3 = new Book(3, "3", "Three", "3", "3", 1, 0, null);
        Book book4 = new Book(4, "4", "Four", "4", "4", 1, 0, null);

        BookRepository bookRepository = new BookRepository();
        Book[] books = bookRepository.getBooks();
        bookRepository.save(book);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
        //view books in array
        System.out.println(Arrays.toString(bookRepository.viewBooks()));
        //view issued books
        System.out.println(Arrays.toString(bookRepository.viewIssuedBooks()));
        //issue book
        bookRepository.issueBook(1);
        //return book, but this book not issued
        bookRepository.returnBook(2);
        //view issued books
        System.out.println(Arrays.toString(bookRepository.viewIssuedBooks()));
        //delete book
        bookRepository.delete(3);
        System.out.println(Arrays.toString(bookRepository.viewBooks()));


    }
}
