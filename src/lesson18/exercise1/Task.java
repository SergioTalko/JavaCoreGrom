package lesson18.exercise1;

public class Task {
    public static void main(String[] args) {
        FileStorage fileStorage = new FileStorage();
        PictureStorage pictureStorage = new PictureStorage();
        CodeStorage codeStorage = new CodeStorage();
        String[] fileNames = {"test1", "test2"};
        String[] fileNames2 = {"test1", "test2", "test3", "test4"};
        String[] fileNames3 = {"test1", "test2", "test3", "test4", "test5"};


        fileStorage.setFiles(fileNames);
        pictureStorage.setFiles(fileNames2);
        codeStorage.setFiles(fileNames3);

        System.out.println("Start printing name...");
        printer(fileStorage);
        printer(pictureStorage);
        printer(codeStorage);
        System.out.println("Done");
    }

    static public void printer(Storage storage) {

        String[] names = storage.getFiles();

        try {
            System.out.println("5th name is " + names[4]);
        } catch (Exception e) {
            System.out.println("5th name can not be found...");
            //System.err.println(e.getMessage());
        }


    }
}
