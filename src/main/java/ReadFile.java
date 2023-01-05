import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadFile {

// Метод чтения списка университетов
    static void readFileUniversity(ArrayList<University> universities, String id, String fullName, String shortName, double yearOfFoundation, StudyProfile mainProfile, int countRow) {
        InputStream inputStream = null;
        XSSFWorkbook workBook = null;

        try {
            inputStream = new FileInputStream
                    ("C:\\Users\\100nout\\IdeaProjects\\ProjectUniversity\\src\\main\\resources\\universityInfo.xlsx");
            workBook = new XSSFWorkbook(inputStream);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(1);
        Iterator<Row> it = sheet.iterator();
        //проходим по всему листу
        while (it.hasNext()) {
            int count=0;
            Row row = it.next();

            Iterator<Cell> cells = row.iterator();
            if (countRow > 0) while (cells.hasNext()) {
                Cell cell = cells.next();
                count++;
//    заполнение значений полей
                if (count == 1) id = cell.getStringCellValue();
                else if (count == 2) fullName = cell.getStringCellValue();
                else if (count == 3) shortName = cell.getStringCellValue();
                else if (count == 4) yearOfFoundation = (double) cell.getNumericCellValue();
                else if (count == 5) mainProfile = StudyProfile.valueOf(cell.getStringCellValue());
            }
            University university = new University(id, fullName, shortName, yearOfFoundation, mainProfile);
            if (countRow > 0) universities.add(university); // добавляем в коллекцию universities новую запись
            countRow++;
        }
    }

    // Метод чтения из файла списка студентов
    static void readFileStudents(ArrayList<Student> students, String fullName, int countRow, String universityId, double currentCourseNumber, double avgExamScore) {
        InputStream inputStream = null;
        XSSFWorkbook workBook = null;

        try {
            inputStream = new FileInputStream("C:\\Users\\100nout\\IdeaProjects\\ProjectUniversity\\src\\main\\resources\\universityInfo.xlsx");
            workBook = new XSSFWorkbook(inputStream);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        //проходим по всему листу
        while (it.hasNext()) {
            int count=0;
            Row row = it.next();

            Iterator<Cell> cells = row.iterator();
            if (countRow > 0) while (cells.hasNext()) {
                Cell cell = cells.next();
                count++;
//    заполнение значений полей
                if (count == 1) fullName = cell.getStringCellValue();
                else if (count == 2) universityId = cell.getStringCellValue();
                else if (count == 3) currentCourseNumber =  cell.getNumericCellValue();
                else if (count == 4) avgExamScore = (double) cell.getNumericCellValue();

            }
            Student student = new Student(universityId, fullName, currentCourseNumber,  avgExamScore);
            if (countRow > 0) students.add(student); // добавляем в коллекцию students новую запись
            countRow++;
        }
    }

 }
