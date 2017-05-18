package lesson5;

import java.util.Arrays;

/**
 * Created by SERGIO on 27.03.2017.
 */
public class withdraw {
    public static void main(String[] args) {

        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};

        System.out.println(Arrays.toString(balances));
        System.out.println(withdraw(names, balances, "Denis", 8432));

    }

        static int  withdraw (String[]clients, int[] balances, String client, int amount){

            int clientIndex = 0;

            for (String cl : clients) {
                if (cl == client) {
                    break;
                }
                clientIndex++;
            }

            int balance = balances[clientIndex] >= amount ? (balances[clientIndex] -= amount) : -1;

            return balance;
        }
}
