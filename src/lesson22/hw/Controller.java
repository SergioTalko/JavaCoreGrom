package lesson22.hw;

public class Controller {


    //bad way


    public Transaction save(Transaction transaction) throws Exception {


        return TransactionDAO.save(transaction);

    }


    public Transaction[] transactionList() throws Exception {

        return TransactionDAO.transactionList();
    }


    public Transaction[] transactionList(String city) throws Exception {

        return TransactionDAO.transactionList(city);

    }

    public Transaction[] transactionList(int amount) throws Exception {

        return TransactionDAO.transactionList(amount);
    }


}

