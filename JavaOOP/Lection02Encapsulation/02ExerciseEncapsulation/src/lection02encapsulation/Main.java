import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String,Person> persons = new LinkedHashMap<>();
        Map<String,Product> products = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(";");

        for (String token :
                tokens) {
            String[] parts = token.split("=");
            String name = parts[0];
            double money = Double.parseDouble(parts[1]);

            try {
                Person person = new Person(name, money);
                System.out.println(person.hashCode());
                persons.put(name, person);

            }catch (ValidationException ex){
                System.out.println(ex.getMessage());
                return;
            }
        }

        tokens = scanner.nextLine().split(";");

        for (String token :
                tokens) {
            String[] parts = token.split("=");
            String name = parts[0];
            double money = Double.parseDouble(parts[1]);

            try {
                Product product = new Product(name, money);
                products.put(name, product);
            }catch (ValidationException ex){
                System.out.println(ex.getMessage());
                return;
            }
        }

        String line;

        while (!"END".equals(line = scanner.nextLine())){
            String name = line.split(" ")[0];
            String product = line.split(" ")[1];
            try{
                persons.get(name).buyProduct(products.get(product));
            }catch (ValidationException ex){
                System.out.println(ex.getMessage());
            }

        }

        for (Person person :
                persons.values()) {
            System.out.println(person.toString());
        }




    }
}
