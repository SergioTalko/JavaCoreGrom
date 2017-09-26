package lesson28;

import java.util.Calendar;
import java.util.Comparator;

public class DateComparator implements Comparator<Capability>

{


    @Override
    public int compare(Capability o1, Capability o2) {

        if (!o2.getDateCreated().equals(o1.getDateCreated())) {
            return o2.getDateCreated().compareTo(o1.getDateCreated());
        }
        return 0;
    }
}
