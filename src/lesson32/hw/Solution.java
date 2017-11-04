package lesson32.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {


    public static void readNumbers() throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        int count = 3;
        String inputString;
        boolean inputCheckPoint = false;
        do {

            System.out.println("Please enter 10 digits: ");
            inputString = bufferedReader.readLine();
            count--;
            if (!validChecker(inputString)) {
                System.out.println("You write " + inputString + "." + "Your numbers are wrong. You have " + count + " attempts to try again");
            } else {
                System.out.println("Sum of your digits is " + sumOfDigit(inputString) + "!");
                inputCheckPoint = true;

            }
        } while (!inputCheckPoint && count > 0);


        if (!inputCheckPoint) System.out.println("Your numbers are wrong. Number of attempts exceeded");


    }


    private static boolean validChecker(String input) {

        if (input.isEmpty() || input == null) return false;

        while (input.contains("  "))
            input = input.replaceAll("  ", " ");

        String[] digits = input.split(" ");
        if (digits.length != 10) return false;

        for (String s : digits) {
            for (Character character : s.toCharArray()) {
                if (!Character.isDigit(character)) {
                    return false;

                }
            }
        }

        for (String digit : digits) {
            if (Integer.parseInt(digit) > 100) {
                return false;
            }
        }
        return true;
    }

    private static int sumOfDigit(String input) {

        String[] digits = input.split(" ");
        int sum = 0;
        for (String s : digits) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

}
