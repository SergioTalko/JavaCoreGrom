package lesson32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFromKeyboard {
    public static void main(String[] args) throws IOException {
        readKeyboardWithScanner();
    }


    //using scanner
    public static void readKeyboardWithScanner() {
        Scanner scanner = new Scanner(System.in);


        String inputString;
        do {
            System.out.println("Please enter your name");
            inputString = scanner.nextLine();
            if (!checker(inputString))
                System.out.println("You write " + inputString + "." + "But you must write one word with letter only ");
        } while (!checker(inputString));

        System.out.println("Hello, " + inputString + "!");
        scanner.close();

    }

    public static void readKeyboardWithIOStream() throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String inputString;
        do {
            System.out.println("Please enter your name");
            inputString = bufferedReader.readLine();
            if (!checker(inputString))
                System.out.println("You write " + inputString + "." + "But you must write one word with letter only ");
        } while (!checker(inputString));

        System.out.println("Hello, " + inputString + "!");
        bufferedReader.close();


    }
    //Допускается только одно слово, без спецсимволов и цифр


    private static boolean checker(String s) {

        String[] result = s.trim().split(" ");
        if (result.length >= 2) {
            return false;
        }

        char[] characters = s.toCharArray();

        for (Character character : characters) {
            if (!Character.isLetter(character)) {
                return false;
            }
        }
        return true;
    }

}
