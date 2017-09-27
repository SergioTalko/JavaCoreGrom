package lesson28;

import java.util.Comparator;

public class DateComparator implements Comparator<Capability>

{


    @Override
    public int compare(Capability o1, Capability o2) throws NullPointerException {

        if (o1 == null || o2 == null) throw new NullPointerException("Please check input info.We have null there");

        if (o1.getDateCreated() != null && o2.getDateCreated() != null && !o2.getDateCreated().equals(o1.getDateCreated())) {
            return o2.getDateCreated().compareTo(o1.getDateCreated());
        }
        return 0;
    }
}
