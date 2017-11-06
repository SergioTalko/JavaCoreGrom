package lesson33;

import java.io.*;
import java.util.Scanner;

public class DemoMethods {
    public static void main(String[] args) throws IOException {
        readwriteScanner();


    }


    public static void readwriteScanner() throws IOException {

        // declarations
        Scanner scanner;
        String inputText;

        // initializations
        scanner = null;
        inputText = "";

        // attempts to create scanner for file
        try {
            scanner = new Scanner(new File("C:/read.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File Doesn't Exist");
            return;
        }

        // goes line by line and concatenates the elements of the file into a string
        while (scanner.hasNextLine())
            inputText = inputText + scanner.nextLine() + "\n";

        // prints to console
        System.out.println(inputText);

    }

    public static void readwriteBufferReader() throws IOException {

        FileReader in = new FileReader("C:/read.txt");
        BufferedReader br = new BufferedReader(in);
        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        in.close();
    }
}

