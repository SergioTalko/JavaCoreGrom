package lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by SERGIO on 11.05.2017.
 */
public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(),TransactionType.WITHDRAWAL,amount,"sfhj");
    }


    @Override
    public void fund(User user, int amount) {
        if (!checkFundLimit(user, amount)) {
            return;
        }
        user.setBalance(user.getBalance() + amount);


        createAndSaveTransaction(new Date(),TransactionType.FUNDING,amount,"sfhj");
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {

        if (!checkWithdraw(fromUser, amount))
            return;
        if (!checkFundLimit(toUser, amount))
            return;
        if (!checkCurrency(fromUser, toUser))
            return;

        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        toUser.setBalance(toUser.getBalance() + amount);


        createAndSaveTransaction(new Date(),TransactionType.TRANSFER,amount,"sfhj");
    }

    @Override
    public void paySalary(User user) {
        fund(user, user.getSalary());

        createAndSaveTransaction(new Date(),TransactionType.SALARY_INCOME,user.getSalary(),"sfhj");
    }


    private void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Can`t Withdraw money " + amount + " from user " + user.toString());
    }

    private void printFundErrorMsg(User user, int amount) {
        System.err.println("Can`t fund money " + amount + " from user " + user.toString());

    }

    private boolean checkFundLimit(User user, int amount) {
        if (amount > user.getBank().getLimitOfFunding()) {
            printFundErrorMsg(user, amount);
            return false;
        }
        return true;
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private boolean checkCurrency(User fromUser, User toUser) {
        if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency()) {
            errMsgCurrency(fromUser, toUser);
            return false;
        }
        return true;
    }

    private void errMsgCurrency(User fromUser, User toUser) {
        System.err.println(fromUser.getId() + " currency is " + fromUser.getBank().getCurrency() + " and " + toUser.getId() + " currency is " + toUser.getBank().getCurrency());
    }

    private Transaction createAndSaveTransaction(Date dateCreated, TransactionType transactionType,int amount,String desc ) {

        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), dateCreated, null, transactionType, amount, desc);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
