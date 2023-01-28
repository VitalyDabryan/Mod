package allComparator;

import enums.StudentsComparators;
import enums.UniversitiesComparators;
import model.Student;
import model.University;

import java.util.ArrayList;
import java.util.Collections;

//утилитный класс, в котором реализовать два метода, принимающих на вход enum с типом компаратора,
// определяющих и возвращающих необходимый из реализованных компараторов
final public class SelectComparator {
    static ArrayList<University> selectUniversitiesComparator(ArrayList<University> universities, UniversitiesComparators myUniversityComparator) {
        if (myUniversityComparator == UniversitiesComparators.IdComparator) {
            Collections.sort(universities, new IdComparator());
        } else
            if (myUniversityComparator == UniversitiesComparators.UniFullNameComparator) {
                Collections.sort(universities, new UniFullNameComparator());
            } else
                if (myUniversityComparator == UniversitiesComparators.UniYearOfFoundationComparator) {
                Collections.sort(universities, new UniYearOfFoundationComparator());
                } else
                if (myUniversityComparator == UniversitiesComparators.UniShortNameComparator) {
                    Collections.sort(universities, new UniShortNameComparator());
                    } else
                         if (myUniversityComparator == UniversitiesComparators.UniProfileNameComparator) {
                         Collections.sort(universities, new UniProfileNameComparator());
                          }
        return universities;
    }

    static ArrayList <Student> selectStudentComparator(ArrayList<Student> students, StudentsComparators myStudentComparator) {
        if (myStudentComparator == StudentsComparators.UniversityIdComparator) {
            Collections.sort(students, new UniversityIdComparator());
        } else
        if (myStudentComparator == StudentsComparators.AvgExamScoreComparator) {
            Collections.sort(students, new StudAvgExamScoreComparator().reversed());
        } else
        if (myStudentComparator == StudentsComparators.CurrentCourseNumberComparator) {
            Collections.sort(students, new CurrentCourseNumberComparator());
        } else
        if (myStudentComparator == StudentsComparators.FullNameComparator) {
            Collections.sort(students, new FullNameComparator());
        }
        return students;
    }

}
