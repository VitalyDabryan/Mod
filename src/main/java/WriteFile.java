import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.String.valueOf;


public class WriteFile {
    public static void writeFile(ArrayList<Statistics> statistics) {
        String fullName;
        HSSFSheet sheet = null;
        try {
            String filename = "C:\\Users\\100nout\\Downloads\\NewExcelFile.xls";
            HSSFWorkbook workbook = new HSSFWorkbook();
            sheet = workbook.createSheet("FirstSheet");
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.setHeightInPoints(45.0f);

            int numberRow = 1;
            //          sheet.autoSizeColumn(1);
            HSSFFont font = workbook.createFont();
            font.setFontHeightInPoints((short)24);
            font.setFontName("Courier New");
            font.setItalic(true);
            font.setStrikeout(true);
// цвет шрифта
//            font.setColor(new XSSFColor(new java.awt.Color(16,64,255)));

            // Создание стиля с определением в нем шрифта
            HSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);

// Создание ячейки с определением ее стиля
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell = row.createCell(1);
            cell.setCellValue("Тестовый шрифт");
            cell.setCellStyle(style);
            font.setBold(true);

            font = workbook.createFont();
            font.setBold(true);

            style = workbook.createCellStyle();
            style.setFont(font);

            for (int i = 0; i < 100; i++) {
                row = sheet.createRow(i);
                for (int j = 0; j < 100; j++) {
                    cell = row.createCell((short) 0);
                    cell.setCellStyle(style);
                }
            }

            rowhead.createCell(0).setCellValue("Профиль обучения");
            rowhead.createCell(1).setCellValue("Средний бал студентов");
            rowhead.createCell(2).setCellValue("Общее количество студентов по направлению");
            rowhead.createCell(3).setCellValue("Количество профильных университетов");
            rowhead.createCell(4).setCellValue("Самый популярный университет");

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

    private static void setBoldStyle() throws IOException {
        // получаем файл с диска
        FileInputStream file = new FileInputStream(new File("C:\\Users\\100nout\\Downloads\\NewExcelFile.xls"));
        // считываем его в память
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        // говорим, что хотим работать с первым листом
        HSSFSheet sheet = workbook.getSheetAt(0);

        // создаем шрифт
        HSSFFont font = workbook.createFont();
        // указываем, что хотим его видеть жирным
 //       font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // создаем стиль для ячейки
        HSSFCellStyle style = workbook.createCellStyle();
        // и применяем к этому стилю жирный шрифт
        style.setFont(font);

        // получаем первую строку листа excel файла
        Row row = sheet.getRow(0);
        // проходим по всем ячейкам этой строки
//        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
//            // применяем созданный выше стиль к каждой ячейке
//            row.getCell(i).setCellStyle(style);
//        }

        // получаем доступ к excel файлу и обновляем его
        try (FileOutputStream out = new FileOutputStream(new File("C:\\Users\\100nout\\Downloads\\NewExcelFile1.xls"))) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel файл успешно обновлен!");
    }
}
