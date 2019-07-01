package overengineered.commands;

import overengineered.BankAccount;

public class SetInterestCommand extends Command {
    static final String NAME = "SetInterest";

    private final double interestRate;

    SetInterestCommand(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void execute() {
        BankAccount.setInterestRate(this.interestRate);
    }
}
