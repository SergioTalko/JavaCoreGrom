package lesson14.HomeWork;

public class Controller {
    BookRepository bookRepository = new BookRepository();
    UserRepository userRepository = new UserRepository();


    public void saveBook(long idUser, Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(long idUser, long idBook) {
        bookRepository.delete(idBook);
    }

    public Book[] viewBooks(long idUser) {
        return bookRepository.view();
    }

    public void userLogin(long idUser, String login, String password){
        userRepository.userLogin(idUser,login,password);
    }

    public void userLogout(long idUser){
        userRepository.userLogout(idUser);
    }

    public void updateBook(long idUser, Book book) {
        bookRepository.update(book);
    }

    public void issueBook(long idUser, long idBook) {
        bookRepository.issue(idBook);
    }

    public void returnBook(long idUser, long idBook) {
        bookRepository.returnBook(idBook);
    }

    public Book[] viewIssuedBooks(long idUser) {
        return bookRepository.viewIssuedBooks();
    }


}
