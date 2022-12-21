import java.util.*;

public class Main {

    private Main() {
    }

    public static void main(String[] args) {

        ArrayList<University> universities = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        String id = "";
        String fullName = "";
        String shortName = "";
        double yearOfFoundation = 0.0;
        StudyProfile mainProfile = null;
        int countRow = 0;

        String universityId = "";
        double currentCourseNumber = 0.0;
        double avgExamScore = 0.0;

//     Чтение списка университетов, заполнение коллекции
       ReadFile.readFileUniversity
               (universities, id, fullName, shortName, yearOfFoundation, mainProfile, countRow);
//     Чтение списка студентов, заполнение коллекции
       ReadFile.readFileStudents
               (students, fullName, countRow, universityId, currentCourseNumber, avgExamScore);

       UniversitiesComparators myUniversityComparator = UniversitiesComparators.UniShortNameComparator;
       System.out.println("Collection of universities:");

       universities = SelectComparator.selectUniversitiesComparator(universities, myUniversityComparator);
       for (Object o: universities) {
            System.out.println(o);
       }

       StudentsComparators myStudentComparator = StudentsComparators.AvgExamScoreComparator;
       System.out.println("Collection of students:");
       students = SelectComparator.selectStudentComparator(students, myStudentComparator);
       students.stream()
                .forEach(System.out::println);
//       for (Student student : students) {
//            System.out.println(student);
//       }

    }
}
