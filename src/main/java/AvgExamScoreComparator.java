import java.util.Comparator;
import java.lang.Double;
public class AvgExamScoreComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {

        return   Double.compare(o1.getAvgExamScore(),
                                o2.getAvgExamScore());
    }

}
