package overengineered.commands;

import overengineered.BankAccount;
import overengineered.store.BankAccountStore;

import java.util.Optional;
import java.util.function.Consumer;

public class DepositCommand extends Command {
    static final String NAME = "Deposit";

    private final String SUCCESS_MESSAGE_FORMAT = "Deposited %.0f to ID%d";

    private final int accountId;
    private final double amount;

    DepositCommand(int accountId, double amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    @Override
    public void execute() {
        Consumer<BankAccount> depositConsumer = account -> {
            account.deposit(amount);

            BankAccountStore.save(account);

            this.setOutput(String.format(SUCCESS_MESSAGE_FORMAT, this.amount, account.getId()));
        };

        Optional<BankAccount> account = BankAccountStore.getById(this.accountId);

        account.ifPresentOrElse(depositConsumer, () -> this.setOutput(MISSING_ACCOUNT_MESSAGE));
    }
}
