package allJSON;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.Statistics;
import model.Student;
import model.University;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static readWriteFile.ReadFile.log;

public class JsonUtil {

// Общий метод сериализации для коллекций University, Students, Statistics
    public static <E> String jsonAllCollection(ArrayList<E> collections) {
        log.info("Begin serialization all collection");
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(collections);
        return json;
    }

    public static String jsonAllUniversities(ArrayList<University> universities) {
        log.info("Begin serialization collection of universities");
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(universities);
        return json;
    }

    public static String jsonAllStatistics(ArrayList<Statistics> statistics) {
        log.info("Begin serialization collection of statistics");
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(statistics);
        return json;
    }

    public static String jsonKindOfUniversities(ArrayList<University> universities, int kindOfUniversities) {
        log.info("Begin serialization object of universities");
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(universities.get(kindOfUniversities));
        return json;
    }

    public static String jsonAllStudents(ArrayList<Student> students) {
        log.info("Begin serialization collection of students");
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(students);
        return json;
    }

    public static String jsonKindOfStudents(ArrayList<Student> students, int kindOfStudents) {
        log.info("Begin serialization object of students");
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(students.get(kindOfStudents));
        return json;
    }

    public static List<University> jsonDeserializerAllUniversities(String jsonAllUniversities) {
        log.info("Begin deserialization collection of universities");
        Type listOfMyClassObject = new TypeToken<ArrayList<University>>() {}.getType();
        Gson gson = new Gson();
        List<University> outputList = gson.fromJson(jsonAllUniversities, listOfMyClassObject);
        return outputList;
    }

    public static List<Student> jsonDeserializerAllStudents(String jsonAllStudents) {
        log.info("Begin deserialization collection of students");
        Type listOfMyClassObject = new TypeToken<ArrayList<Student>>() {}.getType();
        Gson gson = new Gson();
        List<Student> outputList = gson.fromJson(jsonAllStudents, listOfMyClassObject);
        return outputList;
    }

    public static University jsonDeserializerKindOfUniversities(String jsonKindOfUniversity) {
        log.info("Begin deserialization object of universities");
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        University university = gson.fromJson(jsonKindOfUniversity, University.class);
        return university;
    }

    public static Student jsonDeserializerKindOfStudents(String jsonKindOfStudents) {
        log.info("Begin deserialization object of students");
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Student student = gson.fromJson(jsonKindOfStudents, Student.class);
        return student;
    }


}
