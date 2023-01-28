package allComparator;

import model.Student;

import java.util.Comparator;

public class UniversityIdComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getUniversityId().compareTo(o2.getUniversityId());
    }
 //   @Override
//    public int compare(model.Student o1, model.Student o2) {
//        return 0;
//    }
}
