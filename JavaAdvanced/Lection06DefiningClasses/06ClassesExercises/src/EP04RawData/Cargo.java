package EP04RawData;

public class Cargo {
    Integer weight;
    String type;

    public Cargo(Integer weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
