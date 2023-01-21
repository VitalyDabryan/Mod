import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import java.io.FileOutputStream;
import java.util.ArrayList;

public class WriteFile {
    public static void writeFile(ArrayList<Student> students){
        String fullName;
        try {
            String filename = "C:\\Users\\100nout\\Downloads\\NewExcelFile.xls" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet1 = workbook.createSheet("FirstSheet");
            HSSFRow rowhead = sheet1.createRow((short)0);
            int numberRow = 1;


            rowhead.createCell(0).setCellValue("mainProfile");
            rowhead.createCell(1).setCellValue("avgExamScore");
            rowhead.createCell(2).setCellValue("amountOfStudentsByProfile");
            rowhead.createCell(3).setCellValue("amountOfUniversitiesByProfile");
            rowhead.createCell(4).setCellValue("UniversitiesFullName");

            for (Student student : students) {
                HSSFRow row = sheet1.createRow((short)numberRow);
                row.createCell(0).setCellValue(student.getFullName());
                row.createCell(1).setCellValue(student.getUniversityId());
                row.createCell(2).setCellValue(student.getAvgExamScore());
                row.createCell(3).setCellValue(student.getCurrentCourseNumber());
                row.createCell(4).setCellValue("аааав");
                numberRow++;
            }
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel file has been generated!");
        } catch ( Exception ex ) {
            System.out.println(ex);
        }
    }
}
