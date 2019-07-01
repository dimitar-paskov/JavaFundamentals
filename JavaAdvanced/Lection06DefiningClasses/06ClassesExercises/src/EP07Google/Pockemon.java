package EP07Google;

public class Pockemon {
    String name;
    String type;

    public Pockemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", this.name, this.type);
    }
}
