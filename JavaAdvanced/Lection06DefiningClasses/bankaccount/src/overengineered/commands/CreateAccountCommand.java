package overengineered.commands;

import overengineered.BankAccount;
import overengineered.store.BankAccountStore;

public class CreateAccountCommand extends Command {
    static final String NAME = "Create";

    @Override
    public void execute() {
        BankAccount account = new BankAccount();

        BankAccountStore.save(account);

        this.setOutput("Account ID" + account.getId() + " created");
    }
}
