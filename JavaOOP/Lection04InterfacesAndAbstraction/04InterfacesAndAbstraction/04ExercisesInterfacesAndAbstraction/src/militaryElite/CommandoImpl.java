package militaryElite;

import java.util.HashSet;
import java.util.Set;

public class CommandoImpl extends SpecialisedSoldier implements Commando {
    private Set<Mission> missions;
    private Corps corp;

    public CommandoImpl(String id, String firstName, String lastName, double salary, Corps corp) {
        super(id, firstName, lastName, salary);
        this.corp = corp;
        this.missions = new HashSet<>();
    }

    public void addMission(Mission mission){
        this.missions.add(mission);
    }


    @Override
    public void completeMission() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.getProperty("line.separator"));
        sb.append("Corps: ").append(this.corp).append(System.getProperty("line.separator"));
        sb.append("Missions:");

        if (this.missions!=null) {
            for (Mission mission :
                    this.missions) {
                if (mission.status.equals(MissionState.inProgress)) {
                    sb.append(System.getProperty("line.separator")).append(mission);
                }
            }
        }

        return sb.toString();
    }
}
