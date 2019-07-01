package militaryElite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, Private> soldiers = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        while (!"End".equals(input = br.readLine())){
            String[] tokens = input.split("\\s+");
            String typeOfSoldier = tokens[0];



            switch (typeOfSoldier){
                case "Private":{
                    String id = tokens[1];
                    String firstName = tokens[2];
                    String lastName = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    PrivateImpl aPrivate = new PrivateImpl(id, firstName, lastName, salary );
                    soldiers.putIfAbsent(id, aPrivate);
                    System.out.println(aPrivate);

                }break;
                case "Spy":{
                    String id = tokens[1];
                    String firstName = tokens[2];
                    String lastName = tokens[3];
                    String codeNumber = tokens[4];

                    Spy spy = new Spy(id, firstName, lastName, codeNumber);
                    System.out.println(spy);

                }break;
                case "LeutenantGeneral":{
                    String id = tokens[1];
                    String firstName = tokens[2];
                    String lastName = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    LeutenantGeneralImpl leutenantGeneral = new LeutenantGeneralImpl(id, firstName, lastName, salary );

                    for (int i = 5; i < tokens.length ; i++) {
                        leutenantGeneral.addSubordinate(soldiers.get(tokens[i]));

                    }
                    soldiers.putIfAbsent(id, leutenantGeneral);

                    System.out.println(leutenantGeneral);

                }break;
                case "Engineer":{
                    String id = tokens[1];
                    String firstName = tokens[2];
                    String lastName = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    Corps corp = null;
                    try{

                        corp = Corps.valueOf(tokens[5]);
                    }catch (EnumConstantNotPresentException e){
                        break;
                    }

                    Engineer engineer = new Engineer(id, firstName, lastName, salary, corp );

                    for (int i = 6; i < tokens.length ; i += 2) {

                        String repairPart = tokens[i];
                        int hours = Integer.parseInt(tokens[i+1]);

                        Repair repair = new Repair(repairPart, hours);

                        engineer.addRepair(repair);

                    }
                    soldiers.putIfAbsent(id, engineer);

                    System.out.println(engineer);

                }break;
                case "Commando":{
                    String id = tokens[1];
                    String firstName = tokens[2];
                    String lastName = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    Corps corp = null;
                    try{

                        corp = Corps.valueOf(tokens[5]);
                    }catch (EnumConstantNotPresentException e){
                        break;
                    }

                    CommandoImpl commando = new CommandoImpl(id,firstName, lastName, salary, corp);

                    for (int i = 6; i < tokens.length ; i += 2) {

                        String missionName = tokens[i];

                        MissionState status = null;
                        try{

                            status = MissionState.valueOf(tokens[i+1]);
                        }catch (EnumConstantNotPresentException e){
                            continue;
                        }


                        Mission mission = new Mission(missionName, status);
                        commando.addMission(mission);




                    }
                    soldiers.putIfAbsent(id, commando);
                    System.out.println(commando);





                }break;
            }

        }
    }
}
