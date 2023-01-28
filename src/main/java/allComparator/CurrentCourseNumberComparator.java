package allComparator;

import model.Student;

import java.util.Comparator;
import java.lang.Double;

public class CurrentCourseNumberComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            int compare = (int) Double.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
            return compare;

    }

}
