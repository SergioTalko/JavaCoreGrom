package lesson34.classWork;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        copyFileContent("C:\\read.txt", "C:\\read1.txt");
    }


    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {

        checkBeforeCopy(fileFromPath, fileToPath);




        boolean isEmptyFile = checkEmptyFile(fileToPath);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileFromPath));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToPath, true))
        ) {

            String dataFromFile;
            while ((dataFromFile = bufferedReader.readLine()) != null) {

                if (isEmptyFile) {
                    bufferedWriter.append(dataFromFile);
                    isEmptyFile = false;
                }
                bufferedWriter.newLine();
                bufferedWriter.append(dataFromFile);
            }
        } catch (IOException e) {
            throw new IOException("File didn't copy.We have some problem ");
        }
    }
    

    private static void checkBeforeCopy(String fileFromPath, String fileToPath) throws Exception {

        if (fileFromPath == null || fileToPath == null) throw new NullPointerException("Path to file is null");

        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) throw new FileNotFoundException("File with path " + fileFrom + " not available");

        if (!fileTo.exists())
            throw new FileNotFoundException("File with path " + fileTo + " not available");

        if (!fileFrom.canRead()) throw new Exception("Can't read file with path " + fileFrom);

        if (!fileTo.canWrite()) throw new Exception("Can't write to file with path " + fileTo);

    }

    private static boolean checkEmptyFile(String path) {

        File file = new File(path);
        if (file.length() == 0) {
            return true;
        }
        return false;

    }
}
