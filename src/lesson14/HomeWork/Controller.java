package lesson14.HomeWork;

public class Controller {
    private BookRepository bookRepository;
    private UserRepository userRepository;

    public BookRepository getInstanceBook() {
        if (bookRepository == null)
            bookRepository = new BookRepository();

        return bookRepository;
    }

    public UserRepository getInstanceUser() {
        if (userRepository == null)
            userRepository = new UserRepository();

        return userRepository;
    }


    public void saveBook(long idUser, Book book) {
        if (checkLibrarian(idUser))
            getInstanceBook().save(book);

    }

    public void deleteBook(long idUser, long idBook) {
        if (checkLibrarian(idUser))
            getInstanceBook().delete(idBook);
    }

    public Book[] viewBooks(long idUser) {

        if (checkLibrarian(idUser)) {
            return getInstanceBook().view();
        }
        return null;
    }

    public void updateBook(long idUser, Book book) {
        if (checkLibrarian(idUser))
            getInstanceBook().update(book);
    }

    public void issueBook(long idUser, long idBook) {
        if (checkLibrarian(idUser))
            getInstanceBook().issue(idBook);
    }

    public void returnBook(long idUser, long idBook) {
        if (checkLibrarian(idUser))
            getInstanceBook().returnBook(idBook);
    }

    public Book[] viewIssuedBooks(long idUser) {
        if (checkLibrarian(idUser)) {
            return bookRepository.viewIssuedBooks();
        }
        return null;
    }

    public void saveLibrarian(long idUser, User user) {
        if (checkAdmin(idUser))
            getInstanceUser().saveUser(user);
    }

    public void deleteLibrarian(long idAdmin, long idLibrarian) {
        if (checkAdmin(idAdmin))
            getInstanceUser().delete(idLibrarian);
    }

    public void updateLibrarian(long idUser, User user) {
        if (checkAdmin(idUser))
            getInstanceUser().updateUser(user);
    }

    public User[] viewLibrarian(long idUser) {
        if (checkAdmin(idUser)) {
            return getInstanceUser().view();
        }
        return null;
    }

    public boolean checkLogin(User user) {
        if (user == null) {
            return false;
        }
        return user.isLogin();

    }

    private User findById(long id) {
        for (User us : getInstanceUser().getUsers()) {
            if (us != null && us.getId() == id) {
                return us;
            }
        }
        return null;
    }

    private boolean checkAdmin(long idUser) {
        boolean valid = false;


        User us = findById(idUser);

        if (us != null && us.getUserType() == UserType.admin && checkLogin(us)) {
            valid = true;
        }
        return valid;
    }

    private boolean checkLibrarian(long idUser) {
        boolean valid = false;


        User us = findById(idUser);

        if (us != null && us.getUserType() == UserType.librarian && checkLogin(us)) {
            valid = true;
        }
        return valid;
    }


}
