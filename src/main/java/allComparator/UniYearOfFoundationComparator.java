package allComparator;

import model.University;

import java.util.Comparator;
import java.lang.Double;

public class UniYearOfFoundationComparator implements Comparator<University> {

    @Override
    public int compare(University o1, University o2) {
        int compare = (int) Double.compare(o1.getYearOfFoundation(),
                                           o2.getYearOfFoundation());
        return compare;
    }

}
