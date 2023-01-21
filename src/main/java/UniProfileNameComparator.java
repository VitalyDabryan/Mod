import java.util.Comparator;
import org.apache.commons.lang3.StringUtils;
import java.lang.String;



public class UniProfileNameComparator implements Comparator<University> {

    @Override
    public int compare(University o1, University o2) {

//        System.out.println(o1.getMainProfile() + "   " + o2.getMainProfile());
//        int compare = (int)(o1.getMainProfile()).compareTo((o2.getMainProfile()));
//        return  compare;
//        o1 = readEnum(mainProfile);
          return (o1.getMainProfile()).compareTo((o2.getMainProfile()));
 //       int compare = (int) Double.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
//        return compare;
    }

    @Override
    public Comparator<University> reversed() {
        return Comparator.super.reversed();
    }
}
