package lesson14.HomeWork;

public class LibrarianRepository {
    Librarian[] librarians = new Librarian[5];


    public Librarian saveLibrarian(Librarian librarian) {
        if (librarians == null) {
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

    public Librarian updateLibrarian(Librarian librarian) {
        if (librarian == null) {
            return null;
        }

        Librarian findLibrarianById = this.findById(librarian.getId());

        if (findLibrarianById == null) {
            return null;
        }
        for (int i = 0; i < librarians.length; i++) {
            if (librarians[i].getId() == librarian.getId()) {
                return librarians[i] = librarian;
            }
        }
        return null;
    }

    public void delete(long id) {

        int index = 0;
        Librarian librarian = findById(id);

        for (Librarian indexLibrarian : librarians) {
            if (indexLibrarian == librarian) {
                librarians[index] = null;
                break;
            }
            index++;
        }
    }

    public Librarian[] view() {
        int count = 0;
        for (Librarian librarian : librarians) {
            if (librarian != null) {
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Librarians not found ");
            return null;
        }
        Librarian[] librarianArray = new Librarian[count];
        int index = 0;
        for (Librarian librarian : librarians) {
            if (librarian != null) {
                librarianArray[index] = librarian;
                index++;
            }
        }

        return librarianArray;
    }

    private Librarian findById(long id) {
        for (Librarian librarian : librarians) {
            if (librarian != null && librarian.getId() == id) {
                return librarian;
            }
        }
        return null;
    }


}
