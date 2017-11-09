package lesson33.hw;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;

public class SolutionWriter {


    public static void writeToFileFromConsole(String path) {

        if (!checkPath(path)) {
            System.err.println("File with path " + path + " not found");
            return;
        }

        ArrayList<String> arrayOfInputsStrings = inputDataArray();


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {

            for (String s : arrayOfInputsStrings) {
                if (s != null) {
                    bufferedWriter.append(s);
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Cant write to file");
            return;
        }
    }

    private static ArrayList<String> inputDataArray() {
        String write = "wr";
        String inputData = "";

        ArrayList<String> arrayOfInputsStrings = new ArrayList<>();


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Enter file content to write in the file:");

            while (!inputData.equals(write)) {
                inputData = bufferedReader.readLine();
                arrayOfInputsStrings.add(inputData);
            }
            arrayOfInputsStrings.remove(arrayOfInputsStrings.size() - 1); //TODO maybe smth else


        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        }

        return arrayOfInputsStrings;
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

}