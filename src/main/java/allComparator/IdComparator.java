package allComparator;

import model.University;

import java.util.Comparator;

public class IdComparator implements Comparator<University> {

    @Override
    public int compare(University o1, University o2) {

        return o1.getId().compareTo(o2.getId());
    }

}
