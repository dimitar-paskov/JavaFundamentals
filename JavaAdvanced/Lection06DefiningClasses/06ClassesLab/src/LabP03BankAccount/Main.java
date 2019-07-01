package LabP03BankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();


        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String cmdType = tokens[0];

            switch (cmdType) {
                case "Create": {
                    createBankAccount();
                    break;
                }
                case "Deposit":  {
                    depositSum(Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
                    break;
                }
                case "SetInterest": {
                    setInterest(Double.parseDouble(tokens[1]));
                    break;
                }
                case "GetInterest": {
                    getInterest(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                }


            }

            command = scanner.nextLine();
        }
    }

    private static void getInterest(int id, int years) {
        BankAccount account = bankAccounts.get(id);

        if(account != null) {
            System.out.printf("%.2f%n", account.getInterestRate(years));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void depositSum(int id, double amount) {
        BankAccount account = bankAccounts.get(id);

        if (account == null) {
            System.out.println("Account does not exist");
            return;
        }

        account.deposit(amount);
        System.out.printf("Deposited %.0f to ID%d%n", amount, id);

    }

    private static void createBankAccount() {
        BankAccount account = new BankAccount();
        bankAccounts.put(account.getId(), account);

        System.out.println("Account ID" + account.getId() + " created");
    }

    private static void setInterest(double interest) {
        BankAccount.setInterestRate(interest);
    }
}
