package allComparator;

import model.University;

import java.util.Comparator;

public class UniFullNameComparator implements Comparator<University> {

    @Override
    public int compare(University o1, University o2) {

        return o1.getUniFullName().compareTo(o2.getUniFullName());
    }

}