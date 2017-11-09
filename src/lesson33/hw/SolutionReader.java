package lesson33.hw;


import java.io.*;

public class SolutionReader {


    public static void readFileByConsolePath() {

        String path = inputPath();


        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
            return;
        } catch (IOException e) {
            System.err.println("Can't read file by path " + path);
        }

    }

    private static String inputPath() {
        String path = null;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please, enter file path to enter:");
            path = bufferedReader.readLine();
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        }
        return path;
    }

}
