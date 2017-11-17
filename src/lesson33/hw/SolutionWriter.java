package lesson33.hw;


import java.io.*;

public class SolutionWriter {


    public static void writeToFileFromConsole(String path) {

        if (path == null) throw new NullPointerException("Path to file is null");

        String inputData;

        if (!checkPath(path)) {
            System.err.println("File with path " + path + " not found");
            return;
        }

        boolean isFileEmpty = checkEmptyFile(path); //flag if file is empty

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {


            System.out.println("Enter file content to write in the file:");


            while (!(inputData = bufferedReader.readLine()).equals("wr")) {

                if (isFileEmpty) {
                    bufferedWriter.append(inputData);
                    isFileEmpty = false;
                } else {
                    bufferedWriter.newLine();
                    bufferedWriter.append(inputData);
                }

            }
        } catch (IOException e) {
            System.err.println("Cant write to file");
            return;
        }
    }


    private static boolean checkPath(String path) {

        try (FileReader fileReader = new FileReader(path)) {
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    private static boolean checkEmptyFile(String path) {

        File file = new File(path);
        if (file.length() == 0) {
            return true;
        }
        return false;

    }

}