package LabP03BankAccount;
public class BankAccount {
    private final static double DEFAULT_INTEREST = 0.02;

    private static double rate = DEFAULT_INTEREST;
    private static int bankAccountsCount;

    private int id;
    private double balance;

    // continue…
    public BankAccount() {
        this.id = ++bankAccountsCount;
        this.balance = 0;
    }

    public static void setInterest(double interest) {
        rate = interest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // TODO: override toString()

    public void deposit(double amount){
        this.balance += amount;
    }
    public static void setInterestRate(double interest){
        rate = interest;
    }
    public double getInterestRate(int years){
        return rate * years * this.balance;
    }
}
