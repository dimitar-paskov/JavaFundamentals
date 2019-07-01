package EP07Google;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Person> personsInfo = new LinkedHashMap<>();

        String line = "";

        while (!"End".equals(line = scanner.nextLine())){
            String[] tokens = line.split(" ");
            String name = tokens[0];
            String command = tokens[1];

            personsInfo.putIfAbsent(name, new Person(name));



            switch (command){
                case "company":{
                    String companyName = tokens[2];
                    String department = tokens[3];
                    Double salary = Double.parseDouble(tokens[4]);

                    Company company = new Company(companyName, department, salary);
                    personsInfo.get(name).setCompany(company);
                }break;
                case "pokemon": {
                    String pockemonName = tokens[2];
                    String pockemonType = tokens[3];

                    Pockemon pockemon = new Pockemon(pockemonName, pockemonType);
                    personsInfo.get(name).getPockemonList().add(pockemon);
                }break;
                case "parents":{
                    String parentName = tokens[2];
                    String birthday = tokens[3];

                    FamilyMeber parent = new FamilyMeber(parentName, birthday);
                    personsInfo.get(name).getParents().add(parent);
                }break;
                case "children":{
                    String childName = tokens[2];
                    String birthday = tokens[3];

                    FamilyMeber child  = new FamilyMeber(childName, birthday);
                    personsInfo.get(name).getChildren().add(child);
                }break;
                case "car":{
                    String model = tokens[2];
                    String carSpeed = tokens[3];

                    Car car = new Car(model, carSpeed);
                    personsInfo.get(name).setCar(car);
                }break;

            }
        }

        String target = scanner.nextLine();

        System.out.println(personsInfo.get(target).toString());

    }
}
