import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import java.io.FileOutputStream;
import java.util.ArrayList;

public class WriteFile {
    public static void writeFile(ArrayList<Statistics> statistics){
        String fullName;
        try {
            String filename = "C:\\Users\\100nout\\Downloads\\NewExcelFile.xls" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet1 = workbook.createSheet("FirstSheet");
            HSSFRow rowhead = sheet1.createRow((short)0);
            int numberRow = 1;


            rowhead.createCell(0).setCellValue("Профиль обучения");
            rowhead.createCell(1).setCellValue("Средний бал студентов");
            rowhead.createCell(2).setCellValue("Общее количество студентов по направлению");
            rowhead.createCell(3).setCellValue("Количество профильных университетов");
            rowhead.createCell(4).setCellValue("Самый популярный университет");

            for (Statistics statistic : statistics) {
                HSSFRow row = sheet1.createRow((short)numberRow);
                row.createCell(0).setCellValue(statistic.getMainProfile().ordinal());
                row.createCell(1).setCellValue(statistic.getAvgExamScore());
                row.createCell(2).setCellValue(statistic.getAmountOfStudentsByProfile());
                row.createCell(3).setCellValue(statistic.getAmountOfUniversitiesByProfile());
                row.createCell(4).setCellValue(statistic.getMostPopularUniversity());
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
