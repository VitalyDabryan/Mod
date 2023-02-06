package allJSON;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.Student;
import model.University;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    public static String jsonAllUniversities(ArrayList<University> universities) {
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(universities);
        return json;
    }

    public static String jsonKindOfUniversities(ArrayList<University> universities, int kindOfUniversities) {
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(universities.get(kindOfUniversities));
        return json;
    }

    public static String jsonAllStudents(ArrayList<Student> students) {
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(students);
        return json;
    }

    public static String jsonKindOfStudents(ArrayList<Student> students, int kindOfStudents) {
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(students.get(kindOfStudents));
        return json;
    }

    public static List<University> jsonDeserializerAllUniversities(String jsonAllUniversities) {
        Type listOfMyClassObject = new TypeToken<ArrayList<University>>() {}.getType();
        Gson gson = new Gson();
        List<University> outputList = gson.fromJson(jsonAllUniversities, listOfMyClassObject);
        return outputList;
    }

    public static List<Student> jsonDeserializerAllStudents(String jsonAllStudents) {
        Type listOfMyClassObject = new TypeToken<ArrayList<Student>>() {}.getType();
        Gson gson = new Gson();
        List<Student> outputList = gson.fromJson(jsonAllStudents, listOfMyClassObject);
        return outputList;
    }

    public static University jsonDeserializerKindOfUniversities(String jsonKindOfUniversity) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        University university = gson.fromJson(jsonKindOfUniversity, University.class);
        return university;
    }

    public static Student jsonDeserializerKindOfStudents(String jsonKindOfStudents) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Student student = gson.fromJson(jsonKindOfStudents, Student.class);
        return student;
    }

}
