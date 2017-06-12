package lesson14.HomeWork;

public class Controller {
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
