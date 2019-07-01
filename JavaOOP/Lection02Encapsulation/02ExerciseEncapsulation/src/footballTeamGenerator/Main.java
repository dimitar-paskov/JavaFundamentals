package footballTeamGenerator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Team> teams = new ArrayList<>();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        while (!"END".equals(line=br.readLine())){
            String[] tokens = line.split(";");
            String command = tokens[0];

            switch (command){
                case "Team": {
                    Team team = new Team(tokens[1]);
                    teams.add(team);
                }break;
                case "Add":{ //adds player to team
                    String teamName = tokens[1];
                    String playerName = tokens[2];
                    int endurance = Integer.parseInt(tokens[3]);
                    int sprint = Integer.parseInt(tokens[4]);
                    int dribble = Integer.parseInt(tokens[5]);
                    int passing = Integer.parseInt(tokens[6]);
                    int shooting = Integer.parseInt(tokens[7]);
                    Player player = null;
                    try {
                        player = new Player(playerName, endurance,sprint, dribble, passing, shooting);
                    } catch (ValidationException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    Team team = teams.stream().filter(t -> t.getName().equals(teamName)).collect(Collectors.toList()).get(0);
                    if (team == null){
                        System.out.printf("Team %s does not exist.%n", teamName);
                    }else {
                        team.addPlayer(player);
                    }



                }break;
                case "Remove":{
                    String teamName = tokens[1];
                    String playerName = tokens[2];


                    Team team = teams.stream().filter(t -> t.getName().equals(teamName)).collect(Collectors.toList()).get(0);
                    if (team==null){
                        System.out.printf("Team %s does not exist.%n", teamName);
                    }else{
                        try {
                            team.removePlayer(playerName);
                        } catch (ValidationException e) {
                            System.out.println(e.getMessage());
                        }

                    }



                }break;
                case "Rating":{
                    String teamName = tokens[1];
                    Team team = teams.stream().filter(t -> t.getName().equals(teamName)).collect(Collectors.toList()).get(0);

                    if (team==null){
                        System.out.printf("Team %s does not exist.%n",teamName);
                    }else{
                        System.out.println(team);
                    }

                }break;

            }

        }





    }
}
