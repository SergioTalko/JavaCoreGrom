package lesson19.hw;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {
        File file1 = new File(1, "1", "txt", 1);
        File file2 = new File(2, "1111111111", "txt", 2);
        File file3 = new File(3, "3", "jpg", 3);
        File file4 = new File(4, "4", "doc", 4);
        File file5 = new File(5, "4", "doc", 4);

        File file6 = new File(6, "5", "xml", 1);
        File file7 = new File(7, "5", "xml", 1);
        File file8 = new File(8, "5", "xml", 1);
        File file9 = new File(9, "5", "xml", 1);
        File file10 = new File(10, "5", "xml", 1);
        File file11 = new File(11, "5", "xml", 1);

        File file12 = new File(12, "5", "xml", 1);
        File file13 = new File(13, "5", "xml", 1);
        File file14 = new File(14, "5", "xml", 1);
        File file15 = new File(15, "5", "xml", 1);
        File file16 = new File(16, "5", "xml", 1);
        File file17 = new File(17, "5", "xml", 1);


        File[] files = new File[10];
        File[] files2 = new File[11];
        String[] formats = {"txt", "doc", "jpg", "xml"};
        String[] formats2 = {"txt", "doc", "jpg", "xml"};

        Storage storage1 = new Storage(1, files, formats, "test", 1000);
        Storage storage2 = new Storage(2, files2, formats2, "test", 1000);

        Controller controller = new Controller();

        controller.put(storage1, file6);
        controller.put(storage1, file1);
        controller.put(storage1, file2);
        controller.put(storage1, file3);
        controller.put(storage1, file4);
        controller.put(storage1, file5);
        //   System.out.println(controller.put(storage1, file7));
        controller.put(storage1, file8);
        controller.put(storage1, file9);
        controller.put(storage1, file10);
        controller.put(storage1, file11);

        controller.put(storage2, file12);
        controller.put(storage2, file13);
        controller.put(storage2, file14);
        controller.put(storage2, file15);
        controller.put(storage2, file16);
        controller.put(storage2, file17);


        // controller.delete(storage1,file3);






     /*   System.out.println(Arrays.toString(files));*/

        //  System.out.println(Arrays.toString(storage1.getFiles()));
        //   System.out.println(Arrays.toString(storage2.getFiles()));


        //  controller.transferAll(storage1,storage2);

        //   System.out.println(Arrays.toString(storage1.getFiles()));
        //   System.out.println(Arrays.toString(storage2.getFiles()));

        controller.transferFile(storage1, storage2, 6);

        System.out.println(Arrays.toString(storage1.getFiles()));
        System.out.println(Arrays.toString(storage2.getFiles()));

    }


}
