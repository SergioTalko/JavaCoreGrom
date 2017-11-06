package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {
    public static void main(String[] args) {

        //   readFile("C:\\read.txt");
        writeFile("C:\\read.txt", "NewLine");
    }


    public static void readFile(String path) {


        FileReader fileReader;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
            return;
        }

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        } finally {
            IOUtils.closeQuietly(bufferedReader);
            IOUtils.closeQuietly(fileReader);
        }

    }


    public static void writeFile(String path, String content) {


        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            //TODO USe other constructor
            fileWriter = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.newLine();
            bufferedWriter.append(content);
        } catch (IOException e) {
            System.err.println("Cant write to file");
            return;
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(fileWriter);

        }


    }

}
