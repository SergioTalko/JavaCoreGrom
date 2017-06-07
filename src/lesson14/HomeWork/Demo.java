package lesson14.HomeWork;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        AdminLogin admin = new AdminLogin("admin", "admin123");
        //логин admin
        admin.login();
        System.out.println(admin.checkAdminLogin);
        //logout admin
        admin.logout();
        System.out.println(admin.checkAdminLogin);
        //login admin
        admin.login();
        System.out.println(admin.checkAdminLogin);
        System.out.println("");


        LibrarianRepository librarianRepository  = new LibrarianRepository(admin);
        Librarian[] librarians = librarianRepository.getLibrarians();
        System.out.println(Arrays.toString(librarians));

        Librarian librarian1 = new Librarian(1, "1", "1", "1", "1", "1", 1);

        //сейв якщо логін успішний
        librarianRepository.save(librarian1);
        System.out.println(Arrays.toString(librarians));
        System.out.println("");

        //логін librarian якщо він є в системі
        LibrarianLogin librarianLogin = new LibrarianLogin("1", "1",librarians);
        librarianLogin.login();
        System.out.println(librarianLogin.checkLoginLibrarian);
        //logout librarian
        librarianLogin.logout();
        System.out.println(librarianLogin.checkLoginLibrarian);
        System.out.println("");
        //login якщо librarian not found
        LibrarianLogin librarianLogin2 = new LibrarianLogin("1", "2",librarians);
        librarianLogin2.login();
        System.out.println(librarianLogin2.checkLoginLibrarian);



    }
}
