package lesson20.task2;

public class Utils {

    private long limitSimpleTransactionAmount;
    private long limitTransactionsPerDayAmount;
    private long limitTransactionsPerDayCount;

    private String[] cities;

    public Utils() {
        this.limitSimpleTransactionAmount = 100;
        this.limitTransactionsPerDayAmount = 1000;
        this.limitTransactionsPerDayCount = 10;
        this.cities = new String[]{"Test", "Test2", "Lviv"};
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

    public void setLimitSimpleTransactionAmount(long limitSimpleTransactionAmount) {
        this.limitSimpleTransactionAmount = limitSimpleTransactionAmount;
    }

    public void setLimitTransactionsPerDayAmount(long limitTransactionsPerDayAmount) {
        this.limitTransactionsPerDayAmount = limitTransactionsPerDayAmount;
    }

    public void setLimitOperationsPerDay(long limitOperationsPerDay) {
        this.limitTransactionsPerDayCount = limitOperationsPerDay;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }
}


