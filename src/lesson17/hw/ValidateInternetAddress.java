package lesson17.hw;

public class ValidateInternetAddress {

    boolean validate(String address) {
        if (!validInputString(address)) return false;

        if (checkOne(address) == null) return false;

        if (checkTwo(address) == null) return false;

        if (checkThree(address) == null) return false;

        if (!onlyLetterAndNumber(address)) return false;

        return true;
    }

    //перевіриит стрінг на null та empty
    private boolean validInputString(String input) {

        return input == null || input.isEmpty() ? false : true;
    }

    private boolean onlyLetterAndNumber(String input) {

        String name = checkThree(input);

        for (char ch : name.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }

        return true;
    }

    //https http check
    private String checkOne(String address) {

        String[] arrayFirst = address.toLowerCase().split("://");

        if (arrayFirst[0].equals("https") || arrayFirst[0].equals("http")) return arrayFirst[1];

        return null;
    }


    private String[] checkTwo(String input) {

        String[] words = checkOne(input).split("\\.");

        if (words.length == 2) return words;

        if (words.length == 3 && words[0].equals("www")) {
            String[] array = {words[1], words[2]};
            words = array;
        }
        return words;
    }


    //проверить домен
    private String checkThree(String address) {

        String[] arrayFirst = checkTwo(address);


        if (arrayFirst[1].equals("com") || arrayFirst[1].equals("org") || arrayFirst[1].equals("net") && !arrayFirst[0].isEmpty())
        return arrayFirst[0];

        return null;

    }
}

