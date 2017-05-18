package lesson12;

/**
 * Created by SERGIO on 11.05.2017.
 */
public class UkrainianBankSystem implements BankSystem {

    @Override
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getComission(amount));
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

        if (!checkTransferOperation(toUser, fromUser, amount)) {
            return;
        }
        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getComission(amount));
        toUser.setBalance(toUser.getBalance() + amount);

    }

    @Override
    public void paySalary(User user) {
        user.setBalance(user.getBalance() + user.getSalary());
    }


    private void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Can`t withdraw money " + amount + " from user " + user.toString());
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
        if (amount + user.getBank().getComission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private boolean checkTransferOperation(User toUser, User fromUser, int amount) {
        if (!checkWithdraw(fromUser, amount) || !checkFundLimit(toUser, amount)) {
            return false;
        }
        return true;

    }
}
