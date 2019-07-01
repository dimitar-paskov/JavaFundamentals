import java.util.HashMap;
import java.util.Scanner;

public class EP05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "";

        HashMap<String, String> phoneBook = new HashMap<>();

        while (!"search".equals(line = scanner.nextLine())){
            String [] parts = line.split("-");
            String name = parts[0];
            String phoneNumber = parts[1];

            phoneBook.put(name,phoneNumber);


        }

        while (!"stop".equals(line = scanner.nextLine())){

            String name = line;

            if (!phoneBook.containsKey(name)){
                System.out.printf("Contact %s does not exist.\n",name);
            }else{
                System.out.printf("%s -> %s\n", name, phoneBook.get(name));
            }

        }

    }
}
