package lesson34.classWork;

import java.io.*;
import java.util.ArrayList;

public class SolutionStringJoin {


    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {

         checkBeforeCopy(fileFromPath, fileToPath);

         writeFile(fileToPath, readFile(fileFromPath));

    }

    private static String readFile(String path) throws Exception {

        if (path == null) throw new NullPointerException("Path is null");

        ArrayList<String> stringToWrite = new ArrayList<>();
        String dataFromLine;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((dataFromLine = br.readLine()) != null) {
                stringToWrite.add(dataFromLine);
            }
        } catch (IOException e) {
            throw new IOException("Can't read file with path  " + path);
        }


        return new String(String.join("\r\n", stringToWrite));
    }

    private static void writeFile(String path, String text) throws Exception {

        if (path == null) throw new NullPointerException("Path is null");
        if (text == null) throw new NullPointerException("Text to write is null");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(text);
        } catch (IOException e) {
            throw new IOException("Can't write file with path  " + path);
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

}
