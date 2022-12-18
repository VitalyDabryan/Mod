import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

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
       ReadFile.readFileUniversity(universities, id, fullName, shortName, yearOfFoundation, mainProfile, countRow);
//     Чтение списка студентов, заполнение коллекции
       ReadFile.readFileStudents(students, fullName, countRow, universityId, currentCourseNumber, avgExamScore);

       System.out.println("Collection of universities:");
       for (Object o: universities) {
            System.out.println(o);
        }

       System.out.println("Collection of students:");
       for (Object o: students) {
            System.out.println(o);
        }
    }
}
