package EP07Google;

public class FamilyMeber {
    String name;
    String birthDay;

    public FamilyMeber(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", this.name, this.birthDay);
    }
}
