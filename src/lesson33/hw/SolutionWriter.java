package lesson33.hw;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;

public class SolutionWriter {


    public static void writeToFileFromConsole(String path) {


        ArrayList<String> arrayOfInputsStrings = inputDataArray();


        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            //TODO USe other constructor
            fileWriter = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(fileWriter);


            for (String s : arrayOfInputsStrings) {
                if (s != null) {
                    bufferedWriter.append(s);
                    bufferedWriter.newLine();
                }
            }


        } catch (IOException e) {
            System.err.println("Cant write to file");
            return;
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(fileWriter);

        }
    }

    private static ArrayList<String> inputDataArray() {
        String write = "wr";
        String inputData = "";
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        ArrayList<String> arrayOfInputsStrings = new ArrayList<>();


        try {
            inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);
            System.out.println("Enter file content to write in the file:");

            while (!inputData.equals(write)) {
                inputData = bufferedReader.readLine();
                arrayOfInputsStrings.add(inputData);
            }
            arrayOfInputsStrings.remove(arrayOfInputsStrings.size() - 1); //TODO maybe smth else


        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(inputStreamReader);
            IOUtils.closeQuietly(bufferedReader);
        }
        return arrayOfInputsStrings;
    }

}