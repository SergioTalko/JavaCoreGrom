package lesson14.HomeWork;

import java.util.Date;

public class BookRepository {
    private Book[] books = new Book[5];


    public Book save(Book book) {
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
                book.setAddedDate(new Date());
                books[i] = book;
                return books[i];
            }

        }
        return null;
    }

    public Book update(Book book) {
        if (book == null) {
            return null;
        }

        Book findBookById = this.findById(book.getId());

        if (findBookById == null) {
            return null;
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == book.getId()) {
                return books[i] = book;
            }
        }
        return null;
    }

    public void issue(long id) {
        Book book = findById(id);
        if (book == null) {
            System.err.println("Invalid id");
            return;
        }
        if (book.getQuantity() == 0) {
            System.err.println("This book quantity is 0");
            return;
        }
        book.setQuantity(book.getQuantity() - 1);
        book.setIssued(book.getIssued() + 1);

    }

    public void returnBook(long id) {
        Book book = findById(id);
        if (book == null) {
            System.err.println("Invalid id");
            return;
        }
        if (book.getIssued() == 0) {
            System.err.println("Check id, book not issued");
            return;
        }

        book.setQuantity(book.getQuantity() + 1);
        book.setIssued(book.getIssued() - 1);

    }

    public Book[] viewIssuedBooks() {
        int count = 0;
        for (Book book : books) {
            if (book != null && book.getIssued() != 0) {
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Issued books not found");
            return null;
        }
        Book[] issuedBooks = new Book[count];
        int index = 0;
        for (Book book : books) {
            if (book != null && book.getIssued() > 0) {
                issuedBooks[index] = book;
                index++;
            }
        }

        return issuedBooks;
    }

    public Book[] view() {
        int count = 0;
        for (Book book : books) {
            if (book != null) {
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Books not found ");
            return null;
        }
        Book[] booksArray = new Book[count];
        int index = 0;
        for (Book book : books) {
            if (book != null) {
                booksArray[index] = book;
                index++;
            }
        }

        return booksArray;
    }

    public void delete(long id) {

        int index = 0;
        Book book = findById(id);

        for (Book indexBook : books) {
            if (indexBook == book) {
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
