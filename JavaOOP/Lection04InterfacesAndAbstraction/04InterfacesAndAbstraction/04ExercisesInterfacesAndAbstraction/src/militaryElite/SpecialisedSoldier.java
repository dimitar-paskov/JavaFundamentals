package militaryElite;

public abstract class SpecialisedSoldier extends PrivateImpl {

    private Corps corp;

    public SpecialisedSoldier(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
    }
}
