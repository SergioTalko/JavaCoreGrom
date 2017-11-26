package lesson34.classWork;

import java.io.*;

public class Solution {

    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {

        checkBeforeCopy(fileFromPath, fileToPath);

        writeFile(fileToPath, readFile(fileFromPath));

    }

    private static StringBuffer readFile(String path) throws Exception {

        if (path == null) throw new NullPointerException("Path is null");

        StringBuffer stringToWrite = new StringBuffer();
        String dataFromLine;


        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((dataFromLine = br.readLine()) != null) {
                stringToWrite = stringToWrite.append("\r\n").append(dataFromLine);
            }
            if (stringToWrite.length() > 1) {
                stringToWrite = new StringBuffer(stringToWrite.substring(1));
            }
        } catch (IOException e) {
            throw new IOException("Can't read file with path  " + path);
        }
        return stringToWrite;
    }

    private static void writeFile(String path, StringBuffer content) throws Exception {

        if (path == null) throw new NullPointerException("Path is null");
        if (content == null) throw new NullPointerException("Content to write is null");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(content);
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
