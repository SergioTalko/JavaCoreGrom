package lesson20.task2;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {

        TransactionDAO transactionDAO = new TransactionDAO();
        Controller controller = new Controller();
        Transaction transaction = new Transaction(1, "Test", 10, "test", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(2, "Lviv", 100, "test", TransactionType.INCOME, new Date());
        Transaction transaction3 = new Transaction(3, "Test2", 10, "test", TransactionType.INCOME, new Date());
        Transaction transaction4 = new Transaction(4, "Test2", 16, "test", TransactionType.INCOME, new Date());
        Transaction transaction5 = new Transaction(5, "Test", 16, "test", TransactionType.INCOME, new Date());
        Transaction transaction6 = new Transaction(6, "Test", 10, "test", TransactionType.INCOME, new Date());
        Transaction transaction7 = new Transaction(7, "Lviv", 20, "test", TransactionType.INCOME, new Date());
        Transaction transaction8 = new Transaction(8, "Test2", 40, "test", TransactionType.INCOME, new Date());


        controller.saveTransaction(transaction);

        controller.saveTransaction(transaction2);
        controller.saveTransaction(transaction3);
        controller.saveTransaction(transaction4);
        controller.saveTransaction(transaction5);
        controller.saveTransaction(transaction6);
        controller.saveTransaction(transaction7);
        controller.saveTransaction(transaction8);

        System.out.println(Arrays.toString(controller.transactionList()));
        System.out.println("");
        System.out.println(Arrays.toString(controller.transactionList(10)));
        System.out.println("");
        System.out.println(Arrays.toString(controller.transactionList("Lviv")));


    }
}
