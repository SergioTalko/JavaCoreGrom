package lesson14.HomeWork;

import java.util.Arrays;

/**
 * Created by SERGIO on 05.06.2017.
 */
public class Demo {
    public static void main(String[] args) {
        AdminLogin admin = new AdminLogin("admin", "admin123");
        //логин
        admin.login();
        System.out.println(admin.checkLogin);
        //logout
        admin.logout();
        System.out.println(admin.checkLogin);
        admin.login();
        System.out.println(admin.checkLogin);
        System.out.println("");



        LibrarianRepository librarianRepository = new LibrarianRepository(admin);
        Librarian[] librarians = librarianRepository.getLibrarians();
        System.out.println(Arrays.toString(librarians));

        Librarian librarian1 = new Librarian(1, "1", "1", "1", "1", "1", 1);

        //сейв якщо логін успішний
        librarianRepository.save(librarian1);
        System.out.println(Arrays.toString(librarians));
        admin.logout();
        //апдейт після логауту
        System.out.println("");
        librarian1 = new Librarian(1, "2", "2", "2", "1", "1", 1);
        librarianRepository.update(librarian1);
        System.out.println(Arrays.toString(librarians));
        //перегляд бібліотекарів після логауту
        librarianRepository.view();
        System.out.println("");
        admin.login();
        //видалення бібліотекаря після логіна
        librarianRepository.delete(1);
        librarianRepository.view();





    }
}
