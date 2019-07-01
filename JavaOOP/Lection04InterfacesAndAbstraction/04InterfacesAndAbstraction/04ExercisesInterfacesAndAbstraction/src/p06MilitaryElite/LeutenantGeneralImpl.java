package p06MilitaryElite;

import java.util.TreeMap;

public class LeutenantGeneralImpl extends SoldierImpl {

    private TreeMap<Integer, Private> privates;

    public LeutenantGeneralImpl(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.privates = new TreeMap<>();
    }


}
