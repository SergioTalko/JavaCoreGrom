package lesson18.exercise2;

public class Converter {
    public static void main(String[] args) {
        System.out.println(intToString(111231));
        System.out.println(stringToInt("11"));
        System.out.println();
        System.out.println(stringToInt("1050a"));
        System.out.println(intToString((short) 9.999999));
        System.out.println();
        System.out.println(intToString(111231));
        System.out.println(stringToInt("11"));
        System.out.println();
        System.out.println(intToString(2147483647+888888888));
        System.out.println(stringToInt("hello"));
        System.out.println();
        System.out.println(intToString(-2147483648));
        System.out.println(stringToInt("1899837h876738"));


    }


    public static String intToString(int input) {

        try {
            return String.valueOf(input);
        } catch (Exception e) {
            System.out.println(input + " can not be converted to string");
            return null;
        }

    }

    public static int stringToInt(String input) {

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {       //type of exception
            System.out.println(input + " can not be converted to int");
            return 0;
        }

    }
}
