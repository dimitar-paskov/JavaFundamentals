package overengineered.store;

import overengineered.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BankAccountStore {

    private static  Map<Integer, BankAccount> accounts;

    public static void initializeStore() {
        accounts = new HashMap<>();
    }

    public static Optional<BankAccount> getById(int id) {
        BankAccount bankAccount = accounts.get(id);

        Optional<BankAccount> result = Optional.empty();
        if (bankAccount != null) {
            result = Optional.of(bankAccount);
        }

        return result;
    }

    public static void save(BankAccount account) {
        accounts.put(account.getId(), account);
    }
}
