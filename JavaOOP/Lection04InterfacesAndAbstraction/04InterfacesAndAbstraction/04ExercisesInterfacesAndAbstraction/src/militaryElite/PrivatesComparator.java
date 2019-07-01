package militaryElite;

import java.util.Comparator;

public class PrivatesComparator implements Comparator<Private> {
    public int compare(Private prv1, Private prv2)
    {

        return Integer.parseInt(prv2.getId()) - Integer.parseInt(prv1.getId());
    }
}
