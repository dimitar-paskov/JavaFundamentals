package militaryElite;

public class Mission {
    String name;
    MissionState status;

    public Mission(String name, MissionState status) {
        this.name = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.name, this.status);
    }
}
