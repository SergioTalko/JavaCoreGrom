package lesson20.task2;

import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServerException;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];


    public Transaction save(Transaction transaction) throws Exception {
        if (transaction == null) throw new BadRequestException("Cant save null");

        if (transactions == null) throw new BadRequestException("Storage is null");

        if (transaction.getAmount() < 0) throw new BadRequestException(transaction.getAmount() + " value is incorrect");

        if (transaction.getCity() == null) throw new BadRequestException("List of cities is null");

        if (transaction.getId() <= 0) throw new InternalServerException(transaction.getId() + " id is incorrect");

        if (transaction.getDateCreated() == null) throw new BadRequestException("Date cant be null");

        findSameTransaction(transaction);

        if (checkSpaceInStorage() == 0)
            throw new BadRequestException("In storage not enough space to save transaction");


        return saveTransaction(transaction);

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

            int trMonth = calendar.get(Calendar.MONTH);
            int trDay = calendar.get(Calendar.DAY_OF_MONTH);

            if (tr != null && trMonth == month && trDay == day)
                count++;
        }
        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null) calendar.setTime(tr.getDateCreated());
            int trMonth = calendar.get(Calendar.MONTH);
            int trDay = calendar.get(Calendar.DAY_OF_MONTH);

            if (tr != null && trMonth == month && trDay == day) {
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

}
