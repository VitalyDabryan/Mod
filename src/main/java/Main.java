import java.util.*;

final public class Main {

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

//   выбираем тип компаратора для списка универстетов

        printMenuUniversity();
        UniversitiesComparators myUniversityComparator = null;

        Scanner scanner = new Scanner(System.in);
        int choiseUniversity = 8;

        while (choiseUniversity != 0) {
            choiseUniversity = scanner.nextInt();
                switch (choiseUniversity) {
                    case 1:
                        myUniversityComparator = UniversitiesComparators.IdComparator;
                        choiseUniversity = 0;
                        break;
                    case 2:
                        myUniversityComparator = UniversitiesComparators.UniFullNameComparator;
                        choiseUniversity = 0;
                        break;
                    case 3:
                        myUniversityComparator = UniversitiesComparators.UniShortNameComparator;
                        choiseUniversity = 0;
                        break;
                    case 4:
                        myUniversityComparator = UniversitiesComparators.UniYearOfFoundationComparator;
                        choiseUniversity = 0;
                        break;
                    case 5:
                        myUniversityComparator = UniversitiesComparators.UniProfileNameComparator;
                        choiseUniversity = 0;
                        break;
                    case 0:
                        break;
                    default: break;
                }
            if (choiseUniversity > 5) System.out.println("Make your choice again!");
        }

// Сохранить  экземпляры компараторов Universities в переменные с типом интерфейса компаратора
        ArrayList<University> universitiesId = new ArrayList<>();
        ArrayList<University> universitiesFullName = new ArrayList<>();
        ArrayList<University> universitiesShortName = new ArrayList<>();
        ArrayList<University> universitiesYearOfFoundation = new ArrayList<>();
        ArrayList<University> universitiesProfileName = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            if (i == 0) universitiesId = SelectComparator.selectUniversitiesComparator(universities, UniversitiesComparators.IdComparator);
            if (i == 1) universitiesFullName = SelectComparator.selectUniversitiesComparator(universities, UniversitiesComparators.UniFullNameComparator);
            if (i == 2) universitiesShortName = SelectComparator.selectUniversitiesComparator(universities, UniversitiesComparators.UniShortNameComparator);
            if (i == 3) universitiesYearOfFoundation = SelectComparator.selectUniversitiesComparator(universities, UniversitiesComparators.UniYearOfFoundationComparator);
            if (i == 4) universitiesProfileName = SelectComparator.selectUniversitiesComparator(universities, UniversitiesComparators.UniProfileNameComparator);
        }

       System.out.println("Collection of universities:");

       if (myUniversityComparator != null) universities = SelectComparator.selectUniversitiesComparator(universities, myUniversityComparator);
//       for (Object o: universities) {
//            System.out.println(o);
//       }
        universities.stream()
                .forEach(System.out::println);


//   выбираем тип компаратора для списка студентов
       printMenuStudents();

        ArrayList<Student> studentsUniId = new ArrayList<>();
        ArrayList<Student> studentsStudFullName = new ArrayList<>();
        ArrayList<Student> studentsCorceNumber = new ArrayList<>();
        ArrayList<Student> studentsAvgExamScore = new ArrayList<>();
// Сохранить  экземпляры компараторов Student в переменные с типом интерфейса компаратора
        for (int i = 0; i < 4; i++) {
            if (i == 0) studentsUniId = SelectComparator.selectStudentComparator(students, StudentsComparators.UniversityIdComparator);
            if (i == 1) studentsStudFullName = SelectComparator.selectStudentComparator(students, StudentsComparators.FullNameComparator);
            if (i == 2) studentsCorceNumber = SelectComparator.selectStudentComparator(students, StudentsComparators.CurrentCourseNumberComparator);
            if (i == 3) studentsAvgExamScore = SelectComparator.selectStudentComparator(students, StudentsComparators.AvgExamScoreComparator);
        }

        int choiseStudents = 8;
        StudentsComparators myStudentComparator = null;

        while (choiseStudents != 0) {
            choiseStudents = scanner.nextInt();
            switch (choiseStudents) {
                case 1:
                    myStudentComparator = StudentsComparators.UniversityIdComparator;
                    choiseStudents = 0;
                    break;
                case 2:
                    myStudentComparator = StudentsComparators.FullNameComparator;
                    choiseStudents = 0;
                    break;
                case 3:
                    myStudentComparator = StudentsComparators.CurrentCourseNumberComparator;
                    choiseStudents = 0;
                    break;
                case 4:
                    myStudentComparator = StudentsComparators.AvgExamScoreComparator;
                    choiseStudents = 0;
                    break;
                case 0:
                    break;
                default: break;
            }
            if (choiseStudents > 4) System.out.println("Make your choice again!");
        }

       System.out.println("Collection of students:");
       if (myStudentComparator != null) students = SelectComparator.selectStudentComparator(students, myStudentComparator);
       students.stream()
                .forEach(System.out::println);
//       for (Student student : students) {
//            System.out.println(student);
//       }

    }

    private static void printMenuUniversity() {
        System.out.println("Choose a way to sort the list of universities");
        System.out.println("1. Sorting by universities id");
        System.out.println("2. Sorting by full name of universities");
        System.out.println("3. Sorting by short name of universities");
        System.out.println("4. Sorting by year of foundation of universities");
        System.out.println("5. Sorting by main profile of universities");
        System.out.println("0. Displaying a list of universities without sorting and exit");
        System.out.print("Make your choise: ");
    }

    private static void printMenuStudents() {
        System.out.println("Choose a way to sort the list of student");
        System.out.println("1. Sorting by student's University id");
        System.out.println("2. Sorting by full name");
        System.out.println("3. Sorting by Current Course Number");
        System.out.println("4. Sorting by Average ExamScore");
        System.out.println("0. Displaying a list of universities without sorting and exit");
        System.out.print("Make your choise: ");
    }
}
