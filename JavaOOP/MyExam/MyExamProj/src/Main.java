import core.ManagerControllerImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ManagerControllerImpl manager = new ManagerControllerImpl();

        String input="";

        while (!"Exit".equals(input= br.readLine())){

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            String result = "";
            switch (command){
                case "AddPlayer":{
                    try {
                        result = manager.addPlayer(tokens[1], tokens[2]);
                    }catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                }break;
                case "AddCard":{
                    try {
                        result = manager.addCard(tokens[1], tokens[2]);
                    }catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                }break;
                case "AddPlayerCard":{
                    try {
                        result = manager.addPlayerCard(tokens[1], tokens[2]);
                    }catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                }break;
                case "Fight":{
                    try {
                        result = manager.fight(tokens[1], tokens[2]);
                    }catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                }break;
                case "Report":{
                    try {
                        result = manager.report();
                    }catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                }break;
            }

            if (!result.isEmpty()){
                System.out.println(result);
            }

        }
    }
}
