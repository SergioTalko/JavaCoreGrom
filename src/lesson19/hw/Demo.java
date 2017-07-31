package lesson19.hw;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {
        File file1 = null;
        File file2 = new File(1, "11111111", "txt", 2);
        File file3 = new File(3, "3", "jp", 3);
        File file4 = new File(-1, "4", "doc", 4);
        File file5 = new File(5, "4", "doc", -4);

        File file6 = new File(6, "5", "xml", 1);
        File file7 = new File(7, "5", "xml", 1);
        File file8 = new File(8, "5", "xml", 1);
        File file9 = new File(8, "5", "xml", 1);
        File file10 = new File(10, "5", "xml", 10000);
        File file11 = new File(11, "5", "xml", 1);

        File file12 = new File(12, "5", "xml", 1);
        File file13 = new File(8, "5", "xml", 1);
        File file14 = new File(14, "5", "xml", 1);
        File file15 = new File(15, "5", "xml", 1);
        File file16 = new File(15, "5", "xml", 1);
        File file17 = new File(17, "5", "xml", 991);


        File[] files = {null, file8, file7, null};
        File[] files2 = new File[2];
        String[] formats = {"txt", "doc", "jpg", "xml"};
        String[] formats2 = {"txt", "doc", "jpg", "xml"};


        Storage storage2 = new Storage(2, files2, formats2, "test", 900);

        Controller controller = new Controller();

        Storage storage1 = new Storage(1, files, formats, "test", 100);
        //    Storage storage2 = null;
        Storage storage3 = new Storage(3, files2, formats, "test", 100);


        //  controller.put(storage1, file2); // імя більше 10 символів
        //   controller.put(storage1, file1); // file null
        //  controller.put(storage1, file3); // не підходить формат
        //   controller.put(storage1, file4); // id < 0
        //   controller.put(storage1, file5); // size < 0
      //  controller.put(storage1, file6); // storage null
        //   controller.put(storage3, file7); //storage empty
          controller.put(storage1, file15); //valid
        //  controller.put(storage1, file13); // same id
        //  controller.put(storage1, file9); //full
        //  controller.delete(storage1,file9); //delete valid
        // controller.put(storage1, file10); // oversize file
        //   controller.put(storage2, file11); //valid

       /* controller.put(storage2, file12);
        controller.put(storage2, file13);
        controller.put(storage2, file14);
        controller.put(storage2, file15);
        controller.put(storage2, file16);
        controller.put(storage2, file17);*/

        // controller.delete(storage1,file3);


     /*   System.out.println(Arrays.toString(files));*/

        //  System.out.println(Arrays.toString(storage1.getFiles()));
        //   System.out.println(Arrays.toString(storage2.getFiles()));

        //   controller.transferAll(storage2,storage1);

        //   System.out.println(Arrays.toString(storage1.getFiles()));
        //   System.out.println(Arrays.toString(storage2.getFiles()));

        controller.transferFile(storage1, storage2, 8);

        System.out.println(Arrays.toString(storage1.getFiles()));
        System.out.println(Arrays.toString(storage2.getFiles()));

    }
}
