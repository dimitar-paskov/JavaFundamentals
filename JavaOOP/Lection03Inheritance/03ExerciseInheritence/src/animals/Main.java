package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line= "";

        while (!"Beast!".equals(line = br.readLine())){
            String secondLine = br.readLine();
            String[] tokens = secondLine.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String gender = tokens[2];
            SoundProducible animal = null;
            switch (line){
                case "Cat":{
                    try {
                        animal = new Cat(name,age,gender);
                        System.out.println(line);
                        System.out.println(secondLine);
                        System.out.println(animal.produceSound());
                    } catch (ValidationException e) {
                        System.out.println(e.getMessage());
                    }
                }break;
                case "Dog":{
                    try {
                        animal = new Dog(name,age,gender);
                        System.out.println(line);
                        System.out.println(secondLine);
                        System.out.println(animal.produceSound());
                    } catch (ValidationException e) {
                        System.out.println(e.getMessage());
                    }
                }break;
                case "Frog":{
                    try {
                        animal = new Frog(name,age,gender);
                        System.out.println(line);
                        System.out.println(secondLine);
                        System.out.println(animal.produceSound());
                    } catch (ValidationException e) {
                        System.out.println(e.getMessage());
                    }
                }break;
                case "Kitten":{
                    try {
                        animal = new Kitten(name,age,gender);
                        System.out.println(line);
                        System.out.println(secondLine);
                        System.out.println(animal.produceSound());
                    } catch (ValidationException e) {
                        System.out.println(e.getMessage());
                    }
                }break;
                case "Tomccat":{
                    try {
                        animal = new Tomcat(name,age,gender);
                        System.out.println(line);
                        System.out.println(secondLine);
                        System.out.println(animal.produceSound());
                    } catch (ValidationException e) {
                        System.out.println(e.getMessage());
                    }
                }break;
            }

        }
    }
}
