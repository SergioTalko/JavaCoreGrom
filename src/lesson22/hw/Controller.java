package lesson22.hw;

public class Controller {


    //bad way


    public static Transaction save(Transaction transaction) throws Exception {


        return TransactionDAO.save(transaction);

    }


    public static Transaction[] transactionList() throws Exception {

        return TransactionDAO.transactionList();
    }


    public static Transaction[] transactionList(String city) throws Exception {

        return TransactionDAO.transactionList(city);

    }

    public static Transaction[] transactionList(int amount) throws Exception {

        return TransactionDAO.transactionList(amount);
    }


}

