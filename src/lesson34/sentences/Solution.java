package lesson34.sentences;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {

        transferSentences("C:\\read.txt", "C:\\read1.txt", "hello");
    }


    public static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {

        //checking files
        checkBeforeTransfer(fileFromPath, fileToPath);

        //storage with sentences with and without word
        StringBuffer[] storage = splitText(readFile(fileFromPath), word);

        //write sentences with word
        writeFile(fileToPath, storage[0], true);

        //write sentences without word
        writeFile(fileFromPath, storage[1], false);


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

    private static StringBuffer[] splitText(StringBuffer text, String word) throws Exception {

        String[] sentences = Pattern.compile("\\.").split(text);
        System.out.println(Arrays.toString(sentences));
        StringBuffer sentencesWithWord = new StringBuffer();
        StringBuffer sentencesWithoutWord = new StringBuffer();

        for (String sentence : sentences) {
            if (sentence != null && sentence.length() > 10 && sentence.contains(word)) {
                sentencesWithWord.append(sentence).append(".");
            } else {
                sentencesWithoutWord.append(sentence).append(".");
            }
        }
        StringBuffer[] storageOfSentences = new StringBuffer[]{sentencesWithWord, sentencesWithoutWord};
        return storageOfSentences;
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
