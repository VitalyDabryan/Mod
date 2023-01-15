import com.google.gson.*;
import java.util.ArrayList;

public class JsonUtil {
    static void jsonAllUniversities(ArrayList<University> universities) {
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(universities);
        System.out.println(json);
    }

    static void jsonKindOfUniversities(ArrayList<University> universities, int kindOfUniversities) {
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(universities.get(kindOfUniversities));
        System.out.println(json);
    }

    static void jsonAllStudents(ArrayList<Student> students) {
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(students);
        System.out.println(json);
    }

    static void jsonKindOfStudents(ArrayList<Student> students, int kindOfStudents) {
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(students.get(kindOfStudents));
        System.out.println(json);
    }

}
