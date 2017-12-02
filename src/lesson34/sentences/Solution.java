package lesson34.sentences;

import java.io.*;
import java.util.regex.Pattern;

public class Solution {


    public static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {

        //checking files
        checkBeforeTransfer(fileFromPath, fileToPath);

        //split text and write to storageWith and storageWithout
        StringBuffer storageWithWord = new StringBuffer();
        StringBuffer storageWithoutWord = new StringBuffer();
        String[] sentences = Pattern.compile("\\.").split(readFile(fileFromPath));

        for (String sentence : sentences) {
            if (sentence != null && sentence.length() > 10 && sentence.contains(word)) {
                storageWithWord.append(sentence).append(".");
            } else {
                storageWithoutWord.append(sentence).append(".");
            }
        }

        //check if file doesnt contain this word
        if (storageWithWord.length() == 0) {
            System.out.println("File doesn't contains this word " + word);
            return;
        }


        StringBuffer backupFrom = readFile(fileFromPath);
        StringBuffer backupTo = readFile(fileToPath);

        try {
            //write sentences with word
            writeFile(fileToPath, storageWithWord, true);

            //write sentences without word
            writeFile(fileFromPath, storageWithoutWord, false);
        } catch (Exception e) {

            writeFile(fileToPath, backupTo, false);
            writeFile(fileFromPath, backupFrom, false);
            System.err.println("Writing to destination file was incorrect.Please try again");
        }


    }

    private static StringBuffer readFile(String path) throws Exception {

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

    private static void writeFile(String path, StringBuffer content, boolean isAppend) throws Exception {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, isAppend))) {
            bufferedWriter.append(content);
        } catch (IOException e) {
            throw new IOException("Can't write file with path  " + path);
        }
    }


    private static void checkBeforeTransfer(String fileFromPath, String fileToPath) throws Exception {

        if (fileFromPath == null || fileToPath == null) throw new NullPointerException("Path to file is null");

        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) throw new FileNotFoundException("File with path " + fileFrom + " not available");

        if (!fileTo.exists())
            throw new FileNotFoundException("File with path " + fileTo + " not available");

        if (!fileFrom.canRead() || !fileFrom.canWrite())
            throw new Exception("Can't read or write to file with path " + fileFrom);

        if (!fileTo.canWrite() || !fileTo.canRead())
            throw new Exception("Can't write or read file with path " + fileTo);

    }
}
