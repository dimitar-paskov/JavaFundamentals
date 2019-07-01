package militaryElite;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Engineer extends SpecialisedSoldier {

    private Corps corp;
    private Set<Repair> repairs;

    public Engineer(String id, String firstName, String lastName, double salary, Corps corp) {
        super(id, firstName, lastName, salary);
        this.corp = corp;
        this.repairs = new LinkedHashSet<>();
    }

    public void addRepair(Repair repair){
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.getProperty("line.separator"));
        sb.append("Corps: ").append(this.corp).append(System.getProperty("line.separator"));
        sb.append("Repairs:");
        for (Repair repair :
                this.repairs) {
            sb.append(System.getProperty("line.separator")).append(repair);
        }

        return sb.toString();
    }
}
