package lesson14.HomeWork;

/**
 * Created by SERGIO on 06.06.2017.
 */
public class AdminLogin implements Login {
    private String login;
    private String password;
    public boolean checkAdminLogin;

    public AdminLogin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    private void check() {
        if (login == "admin" && password == "admin123") {
            checkAdminLogin = true;
        } else checkAdminLogin = false;
    }

    @Override
    public void login() {
        check();
    }

    @Override
    public void logout() {
        checkAdminLogin = false;
    }
}
