package lesson5.HomeWork;

public class Withdraw {

    public int withdraw(String[] clients, int[] balances, String client, int amount) {
        if (amount < 0) {
            return -1;
        }

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
