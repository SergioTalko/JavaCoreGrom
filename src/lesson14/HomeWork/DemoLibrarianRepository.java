package lesson14.HomeWork;

import java.util.Arrays;

/**
 * Created by SERGIO on 12.06.2017.
 */
public class DemoLibrarianRepository {
    public static void main(String[] args) {
        LibrarianRepository adminRepository = new LibrarianRepository();
        Librarian librarian1 = new Librarian(1, "1", "1", "1", "1", "1", 1);
        adminRepository.saveLibrarian(librarian1);
        System.out.println(Arrays.toString(adminRepository.view()));
    }
}
