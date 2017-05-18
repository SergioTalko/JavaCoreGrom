package lesson10.abstractbigexample;

/**
 * Created by SERGIO on 25.04.2017.
 */
public class DeveloperEmployee extends Employee {
    String[] frameworks = new String[10];


    @Override
    void paySalary() {
        int newBalance = getBankAccount().getBalance() + getSalaryPerMonth() + 1000;
        getBankAccount().setBalance(newBalance);
    }
}
