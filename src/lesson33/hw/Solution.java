package lesson33.hw;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        readFileByConsolePath();
    }

    public static void readFileByConsolePath() {

        String path = null;
        try {
            System.out.println("Please, enter file path to enter:");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            path = bufferedReader.readLine();
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        }


        FileReader fileReader;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
            return;
        }

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Can't read file by path " + path);
        } finally {
            IOUtils.closeQuietly(bufferedReader);
            IOUtils.closeQuietly(fileReader);
        }


    }

}
