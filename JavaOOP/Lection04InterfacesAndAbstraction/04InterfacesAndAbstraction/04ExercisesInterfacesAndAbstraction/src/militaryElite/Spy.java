package militaryElite;

public class Spy extends SoldierImpl {

    String codeNumber;

    public Spy(String id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        //Code Number: <codeNumber>
        StringBuilder sb = new StringBuilder(String.format("Name: %s %s Id: %s ", this.getFirstName(), this.getLastName(), this.getId()));
        sb.append(System.getProperty("line.separator"));
        sb.append("Code Number: " + this.codeNumber);
        return sb.toString();

    }
}
