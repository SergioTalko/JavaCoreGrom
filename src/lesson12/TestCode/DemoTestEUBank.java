package lesson12.TestCode;

import lesson12.*;

/**
 * Created by SERGIO on 30.05.2017.
 */
public class DemoTestEUBank {
    public static void main(String[] args) {
        Bank euBank = new EUBank(456, "USA", Currency.EUR, 150, 2000, 3, 44434343);
        Bank usBank = new USBank(456, "USA", Currency.USD, 150, 2000, 3, 44434343);


        User user = new User(1001, "Mao", 4000, 40, "GMD", 1500, euBank);
        User user2 = new User(1002, "Pit", -100, 40, "GMD", 1700, euBank);
        User user3 = new User(1003, "Peter", 200, 40, "GMD", 1700, usBank);


        UkrainianBankSystem ukrainianBankSystem = new UkrainianBankSystem();

        //test code method withdraw
        // : limit of withdrawal = 2000 if currency is USD and 2200 if currency is EUR
        //commision - 5% if USD and up to 1000, 7% if USD and more than 1000
        //2% if EUR and up to 1000 and 4% if EUR and more than 1000

        //1.Зняття
        ukrainianBankSystem.withdraw(user, 100);
        System.out.println(user.getBalance());
        //2.негативний баланс
        ukrainianBankSystem.withdraw(user2, 100);
        System.out.println(user2.getBalance());
        //3.over limit
        ukrainianBankSystem.withdraw(user, 2300);
        System.out.println(user.getBalance());

        //test fund
        //limit of funding - 20000 if EUR and 10000 if USD
        //1.fund
        ukrainianBankSystem.fund(user2, 1000);
        System.out.println(user2.getBalance());
        System.out.println("");
        //2.over limit
        ukrainianBankSystem.fund(user2, 20001);
        System.out.println(user2.getBalance());
        System.out.println("");

        //test transfer
        //1.одна валюта
        ukrainianBankSystem.transferMoney(user,user2,100);
        System.out.println(user.getBalance());
        System.out.println(user2.getBalance());
        //2. різні валюти
        ukrainianBankSystem.transferMoney(user,user3,100);
        System.out.println(user.getBalance());
        System.out.println(user3.getBalance());
        System.out.println("");

        //test paySalary
        ukrainianBankSystem.paySalary(user2);
        System.out.println(user2.getBalance());

    }

}
