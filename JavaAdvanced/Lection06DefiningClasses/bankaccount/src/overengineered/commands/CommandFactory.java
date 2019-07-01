package overengineered.commands;

public class CommandFactory {

    public static Command createCommand(String name, String[] arguments) {
        Command result = null;

        int accountId;
        switch (name) {
            case CreateAccountCommand.NAME: result = new CreateAccountCommand(); break;
            case DepositCommand.NAME:
                accountId = Integer.parseInt(arguments[1]);
                double amount = Double.parseDouble(arguments[2]);

                result = new DepositCommand(accountId, amount);
                break;
            case SetInterestCommand.NAME:
                double interestRate = Double.parseDouble(arguments[1]);

                result = new SetInterestCommand(interestRate);
                break;
            case GetInterestCommand.NAME:
                accountId = Integer.parseInt(arguments[1]);
                int years = Integer.parseInt(arguments[2]);

                result = new GetInterestCommand(accountId, years);
                break;
        }

        return result;
    }
}
