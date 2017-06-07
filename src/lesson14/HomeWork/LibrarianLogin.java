package lesson14.HomeWork;

/**
 * Created by SERGIO on 06.06.2017.
 */
public class LibrarianLogin implements Login {
    private String login;
    private String password;
    public boolean checkLoginLibrarian;
    Librarian[] librarians;

    public LibrarianLogin(String login, String password, Librarian[] librarians) {
        this.login = login;
        this.password = password;
        this.librarians = librarians;
    }

    private void check() {
        for (Librarian librarian : librarians) {
            if (librarian != null && librarian.getName() == login && librarian.getPassword() == password) {
                checkLoginLibrarian = true;
                break;
            }else
                checkLoginLibrarian = false;
        }

    }

    @Override
    public void login() {
        check();

    }

    @Override
    public void logout() {
        checkLoginLibrarian = false;

    }
}
