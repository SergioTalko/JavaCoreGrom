package lesson22.hw;

import lesson22.hw.exception.BadRequestException;
import lesson22.hw.exception.InternalServerException;
import lesson22.hw.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {

    private static Transaction[] transactions = new Transaction[10];



    public static Transaction save(Transaction transaction) throws Exception {

        checkBeforeSave(transaction);
        checkAllLimits(transaction);


        return saveTransaction(transaction);

    } //save

    public static Transaction[] transactionList() throws Exception {
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

    public  static Transaction[] transactionList(String city) throws Exception {
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

    public static Transaction[] transactionList(int amount) throws Exception {
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

    public static Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) throws InternalServerException {

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

                if (trMonth == month && trDay == day) {
                    count++;
                }
            }
        }
        Transaction[] result = new Transaction[count];

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                calendar.setTime(tr.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = tr;
                    index++;
                }
            }
        }
        return result;
    }

    //private
    private static void checkBeforeSave(Transaction transaction) throws Exception {
        if (transaction == null) throw new BadRequestException("Cant save null");

        if (transactions == null) throw new InternalServerException("Please try again later.Storage is null");

        if (transaction.getAmount() < 0)
            throw new BadRequestException("Transaction with id " + transaction.getId() + " have incorrect value");

        if (transaction.getCity() == null)
            throw new BadRequestException("Field City cant be null");

        if (transaction.getId() <= 0) throw new InternalServerException(transaction.getId() + " id is incorrect");

        if (transaction.getDescription() == null)
            throw new BadRequestException("Transaction with id " + transaction.getId() + " have null in field description");

        if (transaction.getType() == null)
            throw new BadRequestException("Transaction with id " + transaction.getId() + " have null in field type");

        if (transaction.getDateCreated() == null)
            throw new InternalServerException("Transaction with id " + transaction.getId() + " have null in field date");

        findSameTransaction(transaction);

        if (checkSpaceInStorage() == 0)
            throw new InternalServerException("For transaction with id " + transaction.getId() + " not enough space in storage");


    }

    private static void checkAllLimits(Transaction transaction) throws Exception {

        Transaction[] transactionsPerDay = getTransactionsPerDay(transaction.getDateCreated());

        if (transaction.getAmount() > Utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Cant save transaction with id " + transaction.getId() + " Please validate your amount limit for operation");

        if (transactionsPerDay.length + 1 >  Utils.getLimitOperationsPerDay())
            throw new LimitExceeded("Cant save transaction with id " + transaction.getId() + "Too much operations per day");

        if ((amountTransactionsPerDay(transactionsPerDay) + transaction.getAmount()) > Utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Cant save transaction with id " + transaction.getId() + "You have used the amount daily limit");

        if (!checkValidCity(transaction))
            throw new BadRequestException("Cant save transaction with id " + transaction.getId() + transaction.getCity() + " city is not allowed here");

    }

    private static void findSameTransaction(Transaction transaction) throws Exception {

        for (Transaction tr : transactions) {
            if (tr != null && tr.equals(transaction)) {
                throw new BadRequestException("Transaction with id " + transaction.getId() + " already saved");
            }
        }
    }

    private static int checkSpaceInStorage() {

        int count = 0;
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                count++;
            }
        }
        return count;
    }

    private static Transaction saveTransaction(Transaction transaction) throws Exception {

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr == null) {
                transactions[index] = transaction;
                return transactions[index];
            }
            index++;
        }

        throw new InternalServerException("Cant save transaction with id " + transaction.getId() + "Please try again later");

    }

    private static int amountTransactionsPerDay(Transaction[] transactions) {

        int amount = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                amount += tr.getAmount();
            }
        }


        return amount;
    }

    private static boolean checkValidCity(Transaction transaction) {

        for (String city : Utils.getCities()) {
            if (transaction.getCity().equals(city)) {
                return true;
            }
        }
        return false;
    }


}

//