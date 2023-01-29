import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.Student;
import model.University;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    static String jsonAllUniversities(ArrayList<University> universities) {
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(universities);
        return json;
    }

    static String jsonKindOfUniversities(ArrayList<University> universities, int kindOfUniversities) {
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(universities.get(kindOfUniversities));
        return json;
    }

    static String jsonAllStudents(ArrayList<Student> students) {
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(students);
        return json;
    }

    static String jsonKindOfStudents(ArrayList<Student> students, int kindOfStudents) {
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(students.get(kindOfStudents));
        return json;
    }

    static List<University> jsonDeserializerAllUniversities(String jsonAllUniversities) {
        Type listOfMyClassObject = new TypeToken<ArrayList<University>>() {}.getType();
        Gson gson = new Gson();
        List<University> outputList = gson.fromJson(jsonAllUniversities, listOfMyClassObject);
        return outputList;
    }

    static List<Student> jsonDeserializerAllStudents(String jsonAllStudents) {
        Type listOfMyClassObject = new TypeToken<ArrayList<Student>>() {}.getType();
        Gson gson = new Gson();
        List<Student> outputList = gson.fromJson(jsonAllStudents, listOfMyClassObject);
        return outputList;
    }

    static University jsonDeserializerKindOfUniversities(String jsonKindOfUniversity) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        University university = gson.fromJson(jsonKindOfUniversity, University.class);
        return university;
    }

    static Student jsonDeserializerKindOfStudents(String jsonKindOfStudents) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Student student = gson.fromJson(jsonKindOfStudents, Student.class);
        return student;
    }

}
