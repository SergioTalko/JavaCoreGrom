package lesson22.hw;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {

        TransactionDAO transactionDAO = new TransactionDAO();
        Controller controller = new Controller();
        Transaction transaction = new Transaction(1, "Test", 10, "test", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(2, "Lviv", 50, "test", TransactionType.INCOME, new Date());
        Transaction transaction3 = new Transaction(3, "Test2", 10, "test", TransactionType.INCOME, new Date());
        Transaction transaction4 = new Transaction(4, "Test2", 50, "test", TransactionType.INCOME, new Date());
        Transaction transaction5 = new Transaction(5, "Test", 20, "test", TransactionType.INCOME, new Date());
        Transaction transaction6 = new Transaction(6, "Test", 10, "test", TransactionType.INCOME, new Date());
        Transaction transaction7 = new Transaction(7, "Lviv", 20, "test", TransactionType.INCOME, new Date(100));
        Transaction transaction8 = new Transaction(8, "Test2", 50, "test", TransactionType.INCOME, new Date(100));


        // controller.save(transaction);

        controller.save(transaction2);
        controller.save(transaction3);
        controller.save(transaction4);
        controller.save(transaction5);
        controller.save(transaction6);
        controller.save(transaction7);
        controller.save(transaction8);

        // System.out.println(Arrays.toString(transactionDAO.getTransactionsPerDay(new Date())));
        System.out.println(Arrays.toString(controller.transactionList()));
        System.out.println("");
        System.out.println(Arrays.toString(controller.transactionList(40)));
        System.out.println("");
        System.out.println(Arrays.toString(controller.transactionList("Lviv")));


    }
}
