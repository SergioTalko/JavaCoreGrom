package lesson14.HomeWork;

import java.util.Arrays;

public class BookRepository {
    Book[] books = new Book[100];
    LibrarianLogin librarianLogin;

    public BookRepository(LibrarianLogin librarianLogin) {
        this.librarianLogin = librarianLogin;
    }

    public Book save(Book book) {

        if (librarianLogin.checkLoginLibrarian != true) {
            return null;
        }
        if (book == null) {
            return null;
        }
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i] == book) {
                return null;
            }
            if (books[i] == null) {
                books[i] = book;
                return books[i];
            }
        }
        return null;
    }

    public Book update(Book book) {
        if (librarianLogin.checkLoginLibrarian != true) {
            return null;
        }
        if (book == null) {
            return null;
        }

        Book findUserById = this.findById(book.getId());

        if (findUserById == null) {
            return null;
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == book.getId()) {
                return books[i] = book;
            }
        }
        return null;
    }

    public void view() {
        if (librarianLogin.checkLoginLibrarian != true) {
            System.err.println("You must login");

        } else
            System.out.println(Arrays.toString(books));
    }

    public void delete(long id) {
        if (librarianLogin.checkLoginLibrarian != true) {
            return;

        }

        int index = 0;
        Book book = findById(id);

        for (Book indexBook : books) {
            if (book == indexBook) {
                books[index] = null;
                break;
            }
            index++;
        }
    }

    private Book findById(long id) {
        for (Book book : books) {
            if (book != null && book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public Book[] getBooks() {
        return books;
    }
}
