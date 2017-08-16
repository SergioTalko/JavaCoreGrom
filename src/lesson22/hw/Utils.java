package lesson22.hw;

public class Utils {

    private static long limitSimpleTransactionAmount = 50;
    private static long limitTransactionsPerDayAmount = 150;
    private static long limitTransactionsPerDayCount = 6;

    private static String[] cities = new String[]{"Test", "Test2", "Lviv"};


    public static long getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public static long getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public static long getLimitOperationsPerDay() {
        return limitTransactionsPerDayCount;
    }

    public static String[] getCities() {
        return cities;
    }


}


