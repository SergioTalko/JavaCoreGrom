package lesson14.HomeWork;

public class Controller {
    private BookRepository bookRepository = new BookRepository();
    private UserRepository userRepository;

    public UserRepository getInstance() {
        if (userRepository == null)
            userRepository = new UserRepository();

        return userRepository;
    }


    public void saveBook(long idUser, Book book) {
        if (checkLibrarian(idUser))
            bookRepository.save(book);

    }

    public void deleteBook(long idUser, long idBook) {
        if (checkLibrarian(idUser))
            bookRepository.delete(idBook);
    }

    public Book[] viewBooks(long idUser) {

        if (checkLibrarian(idUser)) {
            return bookRepository.view();
        }
        return null;
    }

    public void updateBook(long idUser, Book book) {
        if (checkLibrarian(idUser))
            bookRepository.update(book);
    }

    public void issueBook(long idUser, long idBook) {
        if (checkLibrarian(idUser))
            bookRepository.issue(idBook);
    }

    public void returnBook(long idUser, long idBook) {
        if (checkLibrarian(idUser))
            bookRepository.returnBook(idBook);
    }

    public Book[] viewIssuedBooks(long idUser) {
        if (checkLibrarian(idUser)) {
            return bookRepository.viewIssuedBooks();
        }
        return null;
    }

    public void saveLibrarian(long idUser, User user) {
        if (checkAdmin(idUser))
            getInstance().saveUser(user);
    }

    public void deleteLibrarian(long idAdmin, long idLibrarian) {
        if (checkAdmin(idAdmin))
            getInstance().delete(idLibrarian);
    }

    public void updateLibrarian(long idUser, User user) {
        if (checkAdmin(idUser))
            getInstance().updateUser(user);
    }

    public User[] viewLibrarian(long idUser) {
        if (checkAdmin(idUser)) {
            return getInstance().view();
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
        for (User us : getInstance().getUsers()) {
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
