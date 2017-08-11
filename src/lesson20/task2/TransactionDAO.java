package lesson20.task2;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();


    public Transaction save(Transaction transaction) throws Exception {


        checkAllLimits(transaction);
        //


        return saveTransaction(transaction);

    } //save

    public Transaction[] transactionList() throws Exception {
        if (transactions == null)
            throw new InternalServerException("Please try again later.Array is null");
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null)
                count++;
        }

        Transaction[] result = new Transaction[count];
        if (count == 0)
            return result;


        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                result[index] = transaction;
                index++;
            }
        }


        return result;


    } //all

    public Transaction[] transactionList(String city) throws Exception {
        if (transactions == null)
            throw new InternalServerException("Please try again later.Storage is null");

        int count = 0;
        if (city == null)
            throw new InternalServerException("Please try again later.City is null");
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getCity().equals(city)) {
                count++;
            }
        }

        Transaction[] result = new Transaction[count];
        if (count == 0)
            return result;


        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getCity().equals(city)) {
                result[index] = transaction;
                index++;
            }
        }


        return result;


    } //city

    public Transaction[] transactionList(int amount) throws Exception {
        if (transactions == null)
            throw new InternalServerException("Please try again later.Array is null");

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getAmount() == amount)
                count++;
        }

        Transaction[] result = new Transaction[count];
        if (count == 0)
            return result;


        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getAmount() == amount) {
                result[index] = transaction;
                index++;
            }
        }


        return result;


    } //amount

    //private
    private void checkBeforeSave(Transaction transaction) throws Exception {
        if (transaction == null) throw new BadRequestException("Cant save null");

        if (transactions == null) throw new InternalServerException("Please try again later.Storage is null");

        if (transaction.getAmount() < 0) throw new BadRequestException(transaction.getAmount() + " value is incorrect");

        if (transaction.getCity() == null)
            throw new BadRequestException("Field City cant be null");

        if (transaction.getId() <= 0) throw new InternalServerException(transaction.getId() + " id is incorrect");

        if (transaction.getDateCreated() == null) throw new InternalServerException("Date cant be null");

        findSameTransaction(transaction);

        if (checkSpaceInStorage() == 0)
            throw new InternalServerException("In storage not enough space to save transaction");

        if (!validTransactionType(transaction))
            throw new BadRequestException("Type of transaction must be INCOME or OUTCOME");

    }

    private void checkAllLimits(Transaction transaction) throws Exception {
        checkBeforeSave(transaction);
        Transaction[] transactions = getTransactionsPerDay(transaction.getDateCreated());

        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Please check your amount limit for operation");

        if (transactions.length >= utils.getLimitOperationsPerDay())
            throw new LimitExceeded("Too much operations per day");

        if ((amountTransactionsPerDay(transactions) + transaction.getAmount()) > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("You have used the amount daily limit");

        if (!checkValidCity(transaction))
            throw new BadRequestException(transaction.getCity() + " city is not allowed here");

    }

    private void findSameTransaction(Transaction transaction) throws Exception {

        for (Transaction tr : transactions) {
            if (tr != null && tr.equals(transaction)) {
                throw new BadRequestException("Transaction with id " + transaction.getId() + " already saved");
            }
        }
    }

    private int checkSpaceInStorage() {

        int count = 0;
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                count++;
            }
        }
        return count;
    }

    private Transaction saveTransaction(Transaction transaction) throws Exception {

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr == null) {
                transactions[index] = transaction;
                return transactions[index];
            }
            index++;
        }

        throw new InternalServerException("Please try again later");

    }


    public Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                calendar.setTime(tr.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }
        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                calendar.setTime(tr.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    result[index] = tr;
            }
            index++;
        }
        return result;
    }

    public Transaction[] resultValidCity(String city) throws Exception {

        if (city == null) throw new BadRequestException("City cant be null");

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(city)) {
                count++;
            }
        }

        if (count == 0) return new Transaction[]{};

        Transaction[] result = new Transaction[count];

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(city)) {
                result[index] = tr;
                index++;
            }

        }
        return result;
    }

    public Transaction[] resultValidAmount(int amount) throws Exception {

        if (amount <= 0) throw new BadRequestException("Amount must be more than zero");

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                count++;
            }
        }

        if (count == 0) return new Transaction[]{};

        Transaction[] result = new Transaction[count];

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                result[index] = tr;
                index++;
            }

        }
        return result;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    private int amountTransactionsPerDay(Transaction[] transactions) {

        int amount = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                amount += tr.getAmount();
            }
        }


        return amount;
    }

    private boolean checkValidCity(Transaction transaction) {

        for (String city : utils.getCities()) {
            if (transaction.getCity().equals(city)) {
                return true;
            }
        }
        return false;
    }

    private boolean validTransactionType(Transaction transaction) {
        return (transaction.getType() == TransactionType.INCOME || transaction.getType() == TransactionType.OUTCOME);

    }


}

//Calendar wrong logic