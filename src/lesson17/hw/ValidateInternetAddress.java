package lesson17.hw;

public class ValidateInternetAddress {

    boolean validate(String address) {              //https google.com

        boolean isValid = false;
        if (address.substring(0, 8).equals("https://") || address.substring(0, 5).equals("https") && address.substring((address.length() - 4), address.length()).equals(".com") || address.substring((address.length() - 4), address.length()).equals(".org") || address.substring((address.length() - 4), address.length()).equals(".net")) {
            isValid = true;
        } else
            System.err.println("Інтернет адреса не відповідає заданим параметрам");

        if (address.indexOf('.') != address.length() - 4) {
            System.err.println("Допускається тільки одна крапка в інтернет адрессі");
            isValid = false;
        }

        return isValid;
    }
}
