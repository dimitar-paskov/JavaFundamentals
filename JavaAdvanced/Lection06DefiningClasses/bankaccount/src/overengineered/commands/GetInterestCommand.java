package overengineered.commands;

import overengineered.BankAccount;
import overengineered.store.BankAccountStore;

import java.util.NoSuchElementException;
import java.util.Optional;

public class GetInterestCommand extends Command {
    static final String NAME = "GetInterest";

    private final int accountId;
    private final int years;

    GetInterestCommand(int accountId, int years) {
        this.accountId = accountId;
        this.years = years;
    }

    @Override
    public void execute() {
        Optional<BankAccount> account = BankAccountStore.getById(this.accountId);

        try {
            double accountInterest = account.get().getInterestRate(years);

            this.setOutput(String.format("%.2f", accountInterest));
        } catch (NoSuchElementException e) {
            this.setOutput(MISSING_ACCOUNT_MESSAGE);
        }
    }
}
