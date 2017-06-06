package lesson14.HomeWork;

/**
 * Created by SERGIO on 06.06.2017.
 */
public class AdminLogin {
    private String login;
    private String password;
    public boolean checkLogin;

    public AdminLogin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    private void check() {
        if (login == "admin" && password == "admin123") {
            checkLogin = true;
        }
        else checkLogin = false;
    }


    public void login() {
        check();
    }


    public void logout() {
        checkLogin = false;
    }
}
