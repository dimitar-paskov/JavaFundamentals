package cresla;

import cresla.entities.ManagerImpl;
import cresla.interfaces.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Manager manager = new ManagerImpl();



        while (true){
            String input = br.readLine();
            List<String> arguments = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());
            String command = arguments.get(0);

            String result = "";
            switch (command){
                case "Reactor":{
                    result = manager.reactorCommand(arguments);
                }break;
                case "Module":{
                    result = manager.moduleCommand(arguments);
                }break;
                case "Report":{
                    result = manager.reportCommand(arguments);
                }break;
                case "Exit":{
                    result = manager.exitCommand(arguments);
                    System.out.println(result);
                    return;
                }
            }

            System.out.println(result);


        }
    }
}
