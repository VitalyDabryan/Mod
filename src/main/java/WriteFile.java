import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import java.io.FileOutputStream;
import java.util.ArrayList;
import static java.lang.String.valueOf;

public class WriteFile {
    public static void writeFile(ArrayList<Statistics> statistics) {

        try {
            String filename = "C:\\Users\\100nout\\Downloads\\NewExcelFile.xls";
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");
            HSSFRow rowhead = sheet.createRow( (short)0);

            HSSFCellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            HSSFFont font = workbook.createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 8);
            font.setUnderline((byte) 2);
            font.setBold(true);
            headerStyle.setFont(font);

            sheet.setColumnWidth(0, 4300);
            sheet.setColumnWidth(1, 6300);
            sheet.setColumnWidth(2, 9000);
            sheet.setColumnWidth(3, 9200);
            sheet.setColumnWidth(4, 14000);

           // Создание ячейки с определением ее стиля
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell = row.createCell(0);
       //     headerStyle.setAlignment(ALIGN_CENTER);
            createHeader(rowhead, headerStyle); // Создание шапки таблицы

            // Заполнение таблицы значениями
            int numberRow = 1;
            for (Statistics statistic : statistics) {
                row = sheet.createRow((short) numberRow);
                row.createCell(0).setCellValue(valueOf(statistic.getMainProfile()));
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
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static void createHeader(HSSFRow rowhead, HSSFCellStyle headerStyle) {
        HSSFCell headerCell = rowhead.createCell(0);
        headerCell.setCellValue("Профиль обучения");
        headerCell.setCellStyle(headerStyle);

        headerCell = rowhead.createCell(1);
        headerCell.setCellValue("Средний бал студентов");
        headerCell.setCellStyle(headerStyle);

        headerCell = rowhead.createCell(2);
        headerCell.setCellValue("Общее количество студентов по направлению");
        headerCell.setCellStyle(headerStyle);

        headerCell = rowhead.createCell(3);
        headerCell.setCellValue("Количество профильных университетов");
        headerCell.setCellStyle(headerStyle);

        headerCell = rowhead.createCell(4);
        headerCell.setCellValue("Самый популярный университет");
        headerCell.setCellStyle(headerStyle);
    }

}
