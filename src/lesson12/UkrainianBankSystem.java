package lesson12;

/**
 * Created by SERGIO on 11.05.2017.
 */
public class UkrainianBankSystem implements BankSystem {

    @Override
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    }


    @Override
    public void fund(User user, int amount) {
        if (!checkFundLimit(user, amount)) {
            return;
        }
        user.setBalance(user.getBalance() + amount);
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

    }

    @Override
    public void paySalary(User user) {
        fund(user, user.getSalary());
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

}
