package footballTeamGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void addPlayer(Player player){
        players.add( player);

    }

    public void removePlayer(String name) throws ValidationException {
        int playersCount = this.players.size();
        this.players = this.players.stream().filter(p->!p.getName().equals(name)).collect(Collectors.toList());
        int playersNewCount = this.players.size();

        if (playersCount == playersNewCount){
            throw new ValidationException(String.format("Player %s is not in %s team. ",name, this.name));
        }


    }

    public double getRating(){
        return this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }

    @Override
    public String toString() {
        return String.format("%s - %d",this.name, Math.round(this.getRating()));
    }
}
