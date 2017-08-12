package lesson20.task2;

public class Utils {

    private long limitSimpleTransactionAmount = 50;
    private long limitTransactionsPerDayAmount = 150;
    private long limitTransactionsPerDayCount = 6;

    private String[] cities = new String[]{"Test", "Test2", "Lviv"};

    public Utils() {

    }

    public long getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public long getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public long getLimitOperationsPerDay() {
        return limitTransactionsPerDayCount;
    }

    public String[] getCities() {
        return cities;
    }


}


