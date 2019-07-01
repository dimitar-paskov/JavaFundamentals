package militaryElite;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LeutenantGeneralImpl extends PrivateImpl {

    private Set<Private> subordinates;

    public LeutenantGeneralImpl(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.subordinates = new TreeSet<>(new PrivatesComparator());
    }

    public void addSubordinate(Private aPrivate){
        subordinates.add(aPrivate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.getProperty("line.separator"));
        sb.append("Privates:");
        for (Private aPrivate :
                this.subordinates) {
            sb.append(System.getProperty("line.separator")).append(aPrivate);
        }

        return sb.toString();
    }
}
