import org.apache.poi.ss.formula.functions.T;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.Comparator;

public class IdComparator implements Comparator<University> {

    @Override
    public int compare(University o1, University o2) {

        return o1.getId().compareTo(o2.getId());
    }

}
