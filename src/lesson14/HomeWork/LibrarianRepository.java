package lesson14.HomeWork;

import java.util.Arrays;

/**
 * Created by SERGIO on 05.06.2017.
 */
public class LibrarianRepository {
    private Librarian[] librarians = new Librarian[10];
    AdminLogin admin;

    public LibrarianRepository(AdminLogin admin) {
        this.admin = admin;
    }

    private Librarian findById(long id) {
        for (Librarian user : librarians) {
            if (user != null && user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public Librarian save(Librarian librarian) {
        if (admin.checkLogin != true) {
            return null;
        }
        if (librarian == null) {
            return null;
        }
        int count = 0;
        for (int i = 0; i < librarians.length; i++) {
            if (librarians[i] == null) {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }

        for (int i = 0; i < librarians.length; i++) {
            if (librarians[i] == librarian) {
                return null;
            }
            if (librarians[i] == null) {
                librarians[i] = librarian;
                return librarians[i];
            }
        }
        return null;
    }

    public Librarian update(Librarian librarian) {
        if (admin.checkLogin != true) {
            return null;
        }
        if (librarian == null) {
            return null;
        }

        Librarian findUserById = this.findById(librarian.getId());

        if (findUserById == null) {
            return null;
        }
        for (int i = 0; i < librarians.length; i++) {
            if (librarians[i].getId() == librarian.getId()) {
                return librarians[i] = librarian;
            }
        }
        return null;
    }

    public void view() {
        if (admin.checkLogin != true) {
            System.err.println("You must login");

        } else
            System.out.println(Arrays.toString(librarians));
    }

    public void delete(long id) {
        if (admin.checkLogin != true) {
            return;
        }

        int index = 0;
        Librarian librarian = findById(id);

        for (Librarian us : librarians) {
            if (us == librarian) {
                librarians[index] = null;
                break;
            }
            index++;
        }
    }


    public Librarian[] getLibrarians() {
        return librarians;
    }
}
