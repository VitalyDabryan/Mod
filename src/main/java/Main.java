import MarshDemarshOperation.MarshStudent;
import allJSON.JsonUtil;
import allJSON.WriteJSONFile;
import enums.StudyProfile;
import model.Statistics;
import model.Student;
import model.University;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import readWriteFile.ReadFile;
import readWriteFile.WriteFile;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

final public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);
    public static <E> void main(String[] args) throws JAXBException {

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


        log.info ("Time: " + System.currentTimeMillis());
        log.info("Это информационное сообщение!");

//     Чтение списка университетов, заполнение коллекции
       ReadFile.readFileUniversity
               (universities, id, fullName, shortName, yearOfFoundation, mainProfile, countRow);
        log.info("The Universities file was read successfully!");
       //     Чтение списка студентов, заполнение коллекции
       ReadFile.readFileStudents
               (students, fullName, countRow, universityId, currentCourseNumber, avgExamScore);
        log.info("The Students file was read successfully!");
        int kindOfUniversities = 3;
        int kindOfStudents = 2;

        new File("C:\\Users\\100nout\\Downloads\\xmlReqs").mkdirs();
        new File("C:\\Users\\100nout\\Downloads\\jsonReqs").mkdirs();

        MarshStudent.marshStudents(students);
        log.info("The collection of students was made successfully!");
      //  MarshUniversity.marshUniversity(universities);

        System.out.println(JsonUtil.jsonAllUniversities(universities)); // сериализация коллекции университетов
        log.info("Serialization of the collection of universities was made successfully!");
        System.out.println(JsonUtil.jsonAllStudents(students)); // сериализация коллекции студентов
        log.info("Serialization of the collection of students was made successfully!");
        System.out.println(JsonUtil.jsonKindOfUniversities(universities, kindOfUniversities)); // сериализация элемента коллекции университетов
        log.info("Serialization object of university was made successfully!");
        System.out.println(JsonUtil.jsonKindOfStudents(students, kindOfStudents));  // сериализация элемента коллекции студентов
        log.info("Serialization  object of student was made successfully!");

        // Десериализация коллекции Университетов
        String jsonAllUniversities = JsonUtil.jsonAllUniversities(universities);
        List<University> outputListUniversity = JsonUtil.jsonDeserializerAllUniversities(jsonAllUniversities);
        log.info("Deserialization of the collection of universities was made successfully!");

        // Десериализация коллекции Студентов
        String jsonAllStudents = JsonUtil.jsonAllStudents(students);
        List<Student> outputListStudents = JsonUtil.jsonDeserializerAllStudents(jsonAllStudents);
        log.info("Deserialization of the collection of students was made successfully!");

        // Десериализация объекта списка университетов
        String jsonKindOfUniversities = JsonUtil.jsonKindOfUniversities(universities, kindOfUniversities);
        University jsonDeserializerKindOfUniversities = JsonUtil.jsonDeserializerKindOfUniversities(jsonKindOfUniversities);
        log.info("Deserialization object of university was made successfully!");

        // Десериализация объекта списка студентов
        String jsonKindOfStudents = JsonUtil.jsonKindOfStudents(students, kindOfStudents);
        Student jsonDeserializerKindOfStudents = JsonUtil.jsonDeserializerKindOfStudents(jsonKindOfStudents);
        log.info("Deserialization  object of student was made successfully!");

        System.out.println("Список университетов" + outputListUniversity);
        System.out.println("Список студентов" + outputListStudents);
        System.out.println(jsonDeserializerKindOfUniversities);
        System.out.println(jsonDeserializerKindOfStudents);

        for (kindOfUniversities=0; kindOfUniversities < universities.size(); kindOfUniversities++) {
            System.out.println(JsonUtil.jsonKindOfUniversities(universities, kindOfUniversities));
       }

        // соберем статистику по списку студентов:

        System.out.println("Cписок студентов со средней оценкой выше 4");
        ProcessingCollections.listSudentAvgScoreMoreFoure(students);
        log.info("Statistics of students with an average grade above 4 was made successfully!");
        /*  Статистика по направлениям обучения:
            - Направление обучения.
            - Средний бал студентов.
            - Общее количество студентов по направлению.
            - Количество профильных университетов.
            - Самый популярный университет (университет, в котором учится больше всего студентов).
         */
        System.out.println("Статистика по направлениям обучения:");
        ArrayList<Statistics> statistics = new ArrayList<>();
        statistics = ProcessingCollections.StatisticOfStudyProfile(universities, students, statistics);
        log.info("Statistics on areas of study was made successfully!");

        System.out.println(JsonUtil.jsonAllStatistics(statistics));  // сериализация элементов статистики
        log.info("Serialization of the collection of statistics was made successfully!");

        statistics.stream()
                .forEach(System.out::println);

        // Запись статистики в файл exe: C:\Users\100nout\Downloads\NewExcelFile.xls
        WriteFile.writeFile(statistics);
        log.info("Statistics exe file created!");

        // Запись коллекций в файлы json
        WriteJSONFile.writeJSONFileUniversity(universities);
        log.info("Universities json file created!");

        WriteJSONFile.writeJSONFileStudents(students);
        log.info("Students json file created!");

        WriteJSONFile.writeJSONFileStatistics(statistics);
        log.info("Statistics json file created!");

        System.out.println("Сериализация через общий метод");
        log.info("Сериализация через общий метод");

        ArrayList<E> collection = new ArrayList<E>();
        collection = (ArrayList<E>) students;
        System.out.println(JsonUtil.jsonAllCollection(collection));
        log.info("Сериализация коллекции студентов через общий метод");

        collection = (ArrayList<E>) universities;
        System.out.println(JsonUtil.jsonAllCollection(collection));
        log.info("Сериализация коллекции университетов через общий метод");

        collection = (ArrayList<E>) statistics;
        System.out.println(JsonUtil.jsonAllCollection(collection));
        log.info("Сериализация коллекции статистики через общий метод");
/*
        printMenuUniversity();
        enums.UniversitiesComparators myUniversityComparator = null;

        Scanner scanner = new Scanner(System.in);
        int choiseUniversity = 8;

        while (choiseUniversity != 0) {
            choiseUniversity = scanner.nextInt();
                switch (choiseUniversity) {
                    case 1:
                        myUniversityComparator = enums.UniversitiesComparators.allComparator.IdComparator;
                        choiseUniversity = 0;
                        break;
                    case 2:
                        myUniversityComparator = enums.UniversitiesComparators.allComparator.UniFullNameComparator;
                        choiseUniversity = 0;
                        break;
                    case 3:
                        myUniversityComparator = enums.UniversitiesComparators.allComparator.UniShortNameComparator;
                        choiseUniversity = 0;
                        break;
                    case 4:
                        myUniversityComparator = enums.UniversitiesComparators.allComparator.UniYearOfFoundationComparator;
                        choiseUniversity = 0;
                        break;
                    case 5:
                        myUniversityComparator = enums.UniversitiesComparators.allComparator.UniProfileNameComparator;
                        choiseUniversity = 0;
                        break;
                    case 0:
                        break;
                    default: break;
                }
            if (choiseUniversity > 5) System.out.println("Make your choice again!");
        }

// Сохранить  экземпляры компараторов Universities в переменные с типом интерфейса компаратора
        ArrayList<model.University> universitiesId = new ArrayList<>();
        ArrayList<model.University> universitiesFullName = new ArrayList<>();
        ArrayList<model.University> universitiesShortName = new ArrayList<>();
        ArrayList<model.University> universitiesYearOfFoundation = new ArrayList<>();
        ArrayList<model.University> universitiesProfileName = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            if (i == 0) universitiesId = allComparator.SelectComparator.selectUniversitiesComparator(universities, enums.UniversitiesComparators.allComparator.IdComparator);
            if (i == 1) universitiesFullName = allComparator.SelectComparator.selectUniversitiesComparator(universities, enums.UniversitiesComparators.allComparator.UniFullNameComparator);
            if (i == 2) universitiesShortName = allComparator.SelectComparator.selectUniversitiesComparator(universities, enums.UniversitiesComparators.allComparator.UniShortNameComparator);
            if (i == 3) universitiesYearOfFoundation = allComparator.SelectComparator.selectUniversitiesComparator(universities, enums.UniversitiesComparators.allComparator.UniYearOfFoundationComparator);
            if (i == 4) universitiesProfileName = allComparator.SelectComparator.selectUniversitiesComparator(universities, enums.UniversitiesComparators.allComparator.UniProfileNameComparator);
        }

       System.out.println("Collection of universities:");

       if (myUniversityComparator != null) universities = allComparator.SelectComparator.selectUniversitiesComparator(universities, myUniversityComparator);
//       for (Object o: universities) {
//            System.out.println(o);
//       }
        universities.stream()
                .forEach(System.out::println);


//   выбираем тип компаратора для списка студентов
       printMenuStudents();

        ArrayList<model.Student> studentsUniId = new ArrayList<>();
        ArrayList<model.Student> studentsStudFullName = new ArrayList<>();
        ArrayList<model.Student> studentsCorceNumber = new ArrayList<>();
        ArrayList<model.Student> studentsAvgExamScore = new ArrayList<>();
// Сохранить  экземпляры компараторов model.Student в переменные с типом интерфейса компаратора
        for (int i = 0; i < 4; i++) {
            if (i == 0) studentsUniId = allComparator.SelectComparator.selectStudentComparator(students, enums.StudentsComparators.allComparator.UniversityIdComparator);
            if (i == 1) studentsStudFullName = allComparator.SelectComparator.selectStudentComparator(students, enums.StudentsComparators.allComparator.FullNameComparator);
            if (i == 2) studentsCorceNumber = allComparator.SelectComparator.selectStudentComparator(students, enums.StudentsComparators.allComparator.CurrentCourseNumberComparator);
            if (i == 3) studentsAvgExamScore = allComparator.SelectComparator.selectStudentComparator(students, enums.StudentsComparators.allComparator.StudAvgExamScoreComparator);
        }

        int choiseStudents = 8;
        enums.StudentsComparators myStudentComparator = null;

        while (choiseStudents != 0) {
            choiseStudents = scanner.nextInt();
            switch (choiseStudents) {
                case 1:
                    myStudentComparator = enums.StudentsComparators.allComparator.UniversityIdComparator;
                    choiseStudents = 0;
                    break;
                case 2:
                    myStudentComparator = enums.StudentsComparators.allComparator.FullNameComparator;
                    choiseStudents = 0;
                    break;
                case 3:
                    myStudentComparator = enums.StudentsComparators.allComparator.CurrentCourseNumberComparator;
                    choiseStudents = 0;
                    break;
                case 4:
                    myStudentComparator = enums.StudentsComparators.allComparator.StudAvgExamScoreComparator;
                    choiseStudents = 0;
                    break;
                case 0:
                    break;
                default: break;
            }
            if (choiseStudents > 4) System.out.println("Make your choice again!");
        }

       System.out.println("Collection of students:");
       if (myStudentComparator != null) students = allComparator.SelectComparator.selectStudentComparator(students, myStudentComparator);
       students.stream()
                .forEach(System.out::println);
//       for (model.Student student : students) {
//            System.out.println(student);
//       }
*/
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
        System.out.println("1. Sorting by student's model.University id");
        System.out.println("2. Sorting by full name");
        System.out.println("3. Sorting by Current Course Number");
        System.out.println("4. Sorting by Average ExamScore");
        System.out.println("0. Displaying a list of universities without sorting and exit");
        System.out.print("Make your choise: ");
    }
}
