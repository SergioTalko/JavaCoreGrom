package lesson8.acounts;

/**
 * Created by SERGIO on 05.04.2017.
 */
public class ChekingAccount extends Account {
    int limitOfExpenses;

    public ChekingAccount(String bankName, String ownerName, int moneyAmount, int limitOfExpenses) {
        super(bankName, ownerName, moneyAmount);
        this.limitOfExpenses = limitOfExpenses;
    }


    void withdraw(int amount) {
        if (amount > limitOfExpenses)
            return;
        moneyAmount -= amount;
    }
}




