package lesson33.hw;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {


    public static void readFileByConsolePath() {

        String path = inputPath();


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

    private static String inputPath() {
        String path = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            System.out.println("Please, enter file path to enter:");
            inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);
            path = bufferedReader.readLine();
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(inputStreamReader);
            IOUtils.closeQuietly(bufferedReader);
        }
        return path;
    }

}
