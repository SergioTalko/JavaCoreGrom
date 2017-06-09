package lesson14.HomeWork;

import java.util.Arrays;

/**
 * Created by SERGIO on 08.06.2017.
 */
public class Controller {
    Book[] books = new Book[20];
    Librarian[] librarians = new Librarian[5];
    public boolean checkAdminLogin;
    public boolean checkLibrarianLogin;


    public void adminLogin(String login, String password) {
        checkAdmin(login, password);
    }

    public void adminLogout() {
        checkAdminLogin = false;
    }

    public void librarianLogin(String login, String password) {
        checkLoginLibrarian(login, password);
    }

    public void librarianLogout() {
        checkLibrarianLogin = false;
    }

    public Librarian saveLibrarian(Librarian librarian) {
        save(librarian, checkAdminLogin, librarians);
        return librarian;
    }

    public Book saveBook(Book book) {
        save(book, checkLibrarianLogin, books);
        return book;
    }

    public Librarian updateLibrarian(Librarian librarian) {
        update(librarian, checkAdminLogin, librarians);
        return librarian;
    }

    public Book updateBook(Book book) {
        update(book, checkLibrarianLogin, books);
        return book;
    }


    public void viewLibrarians() {
        view(checkAdminLogin, librarians);
    }

    public void viewBooks() {
        view(checkLibrarianLogin, books);
    }

    public void deleteLibrarian(long id){
        delete(id,librarians, checkAdminLogin);
    }


    private Object findById(long id, Object[] objects) {
        for (Object obj : objects) {
            if (obj != null && obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }

    private Object update(Object object, boolean check, Object[] objects) {
        if (check != true) {
            System.err.println("You must login");
            return null;
        }
        if (object == null) {
            return null;
        }

        Object findUserById = this.findById(object.getId(), objects);

        if (findUserById == null) {
            return null;
        }
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].getId() == object.getId()) {
                return objects[i] = object;
            }
        }
        return null;
    }

    private void view(boolean check, Object[] logins) {
        if (check != true) {
            System.err.println("You must login");

        } else
            System.out.println(Arrays.toString(logins));
    }

    private Object save(Object object, boolean check, Object[] objects) {

        if (check != true) {
            return null;
        }
        if (object == null) {
            return null;
        }
        int count = 0;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }

        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == object) {
                return null;
            }
            if (objects[i] == null) {
                objects[i] = object;
                return objects[i];
            }
        }
        return null;
    }

    private void delete(long id, Object[] objects, boolean check) {
        if (check != true) {
            return;

        }

        int index = 0;
        Object object = findById(id, objects);

        for (Object indexObject : objects) {
            if (object == indexObject) {
                objects[index] = null;
                break;
            }
            index++;
        }
    }


    private void checkAdmin(String login, String password) {
        if (login == "admin" && password == "admin123") {
            checkAdminLogin = true;
        } else checkAdminLogin = false;
    }

    private void checkLoginLibrarian(String login, String password) {
        for (Librarian librarian : librarians) {
            if (librarian != null && librarian.getName() == login && librarian.getPassword() == password) {
                checkLibrarianLogin = true;
                break;
            } else
                checkLibrarianLogin = false;
        }

    }


}
