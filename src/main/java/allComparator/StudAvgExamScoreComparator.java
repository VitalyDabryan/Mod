package allComparator;

import model.Student;

import java.util.Comparator;
import java.lang.Double;
public class StudAvgExamScoreComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
         return   Double.compare(o1.getAvgExamScore(), o2.getAvgExamScore());
    }

}
