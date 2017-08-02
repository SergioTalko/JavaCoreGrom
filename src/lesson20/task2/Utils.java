package lesson20.task2;

public class Utils {

    private long limitMoneyForOperation;
    private long limitMoneyPerDay;
    private long limitOperationsPerDay;
    private String[] validCity;

    public Utils() {
        this.limitMoneyForOperation = 100;
        this.limitMoneyPerDay = 1000;
        this.limitOperationsPerDay = 10;
        this.validCity = new String[]{"Test", "Test2", "Lviv"};
    }

    public long getLimitMoneyForOperation() {
        return limitMoneyForOperation;
    }

    public long getLimitMoneyPerDay() {
        return limitMoneyPerDay;
    }

    public long getLimitOperationsPerDay() {
        return limitOperationsPerDay;
    }

    public String[] getValidCity() {
        return validCity;
    }

    public void setLimitMoneyForOperation(long limitMoneyForOperation) {
        this.limitMoneyForOperation = limitMoneyForOperation;
    }

    public void setLimitMoneyPerDay(long limitMoneyPerDay) {
        this.limitMoneyPerDay = limitMoneyPerDay;
    }

    public void setLimitOperationsPerDay(long limitOperationsPerDay) {
        this.limitOperationsPerDay = limitOperationsPerDay;
    }

    public void setValidCity(String[] validCity) {
        this.validCity = validCity;
    }
}
