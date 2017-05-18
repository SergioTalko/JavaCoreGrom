package lesson12;

/**
 * Created by SERGIO on 12.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank(456, "USA", Currency.USD, 150, 2000, 3,44434343);
        Bank euBank = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4,44434343);
        Bank chinaBank = new USBank(124, "China", Currency.EUR, 130, 1550, 6,444343434 );
        User user1 = new User(1001, "Denis", 12000, 40, "GMD", 1500 , euBank);
        User user2 = new User(1044, "Jack", 10000, 40, "GMD", 1700 , euBank);
        User user3 = new User(1055, "Mao", 200, 40, "GMD", 1500 , usBank);
        User user4 = new User(1088, "Pit", 900, 40, "GMD", 1700 , usBank);
        User user5 = new User(1077, "Alex", 7000, 40, "GMD", 1500 , chinaBank);
        User user6 = new User(1099, "John", 8000, 40, "GMD", 1700 , chinaBank);

        BankSystem bankSystem = new UkrainianBankSystem();

        bankSystem.withdraw(user1, 100);
        bankSystem.fund(user1, 20);
        bankSystem.paySalary(user1);
        bankSystem.transferMoney(user1,user2,100);

        bankSystem.withdraw(user2, 100);
        bankSystem.fund(user2, 20);
        bankSystem.paySalary(user2);
        bankSystem.transferMoney(user2,user3,100);

        bankSystem.withdraw(user3, 100);
        bankSystem.fund(user3, 20);
        bankSystem.paySalary(user3);
        bankSystem.transferMoney(user3,user4,1000);

        bankSystem.withdraw(user4, 100);
        bankSystem.fund(user4, 20);
        bankSystem.paySalary(user4);
        bankSystem.transferMoney(user4,user5,1000);

        bankSystem.withdraw(user5, 100);
        bankSystem.fund(user5, 20);
        bankSystem.paySalary(user5);
        bankSystem.transferMoney(user5,user6,50);

        bankSystem.withdraw(user6, 100);
        bankSystem.fund(user6, 20);
        bankSystem.paySalary(user6);
        bankSystem.transferMoney(user6,user1,50);

        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println(user3.toString());
        System.out.println(user4.toString());
        System.out.println(user5.toString());
        System.out.println(user6.toString());

    }
}
