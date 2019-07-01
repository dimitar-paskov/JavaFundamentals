package overengineered;

import overengineered.commands.Command;
import overengineered.commands.CommandFactory;
import overengineered.store.BankAccountStore;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lineArguments = scanner.nextLine().split(" ");
        String command = lineArguments[0];


        BankAccountStore.initializeStore();
        while (!command.equals("End")) {
            Command current = CommandFactory.createCommand(command, lineArguments);

            current.execute();

            String result = current.getOutput();

            if (result != null) {
                System.out.println(result);
            }

            lineArguments = scanner.nextLine().split(" ");
            command = lineArguments[0];
        }
    }
}