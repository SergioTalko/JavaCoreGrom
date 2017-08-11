package lesson20.task2;

public class Controller {


    //bad way
    private TransactionDAO transactionDAO = new TransactionDAO();

    private Utils utils = new Utils();


    public Transaction saveTransaction(Transaction transaction) throws Exception {
        Transaction[] transactions = transactionDAO.getTransactionsPerDay(transaction.getDateCreated());


        if (transaction.getAmount() > utils.getLimitMoneyForOperation())
            throw new LimitExceeded("Please check your amount limit for operation");

        if (transactions.length >= utils.getLimitOperationsPerDay())
            throw new LimitExceeded("Too much operations per day");

        if ((amountTransactionsPerDay(transactions) + transaction.getAmount()) > utils.getLimitMoneyPerDay())
            throw new LimitExceeded("You have used the amount daily limit");

        if (!checkValidCity(transaction)) throw new LimitExceeded(transaction.getCity() + " city is not allowed here");

        return transactionDAO.save(transaction);


    }

    public Transaction[] transactionList() throws Exception {
        if (transactionDAO.getTransactions() == null) throw new InternalServerException("Storage is null");
        return transactionDAO.getTransactions();

    }

    public Transaction[] transactionList(String city) throws Exception {
        if (transactionDAO.getTransactions() == null) throw new InternalServerException("Storage is null");

        return transactionDAO.resultValidCity(city);

    }

    public Transaction[] transactionList(int amount) throws Exception {
        if (transactionDAO.getTransactions() == null) throw new InternalServerException("Storage is null");

        return transactionDAO.resultValidAmount(amount);

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


}

