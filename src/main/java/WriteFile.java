import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;

public class WriteFile {
    private void WriteFile(){
        try {
            String filename = "C:\\Users\\100nout\\Downloads\\NewExcelFile.xls" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet1 = workbook.createSheet("FirstSheet");
            HSSFRow rowhead = sheet1.createRow((short)0);
            rowhead.createCell(0).setCellValue("No.");
            rowhead.createCell(1).setCellValue("Name");
            rowhead.createCell(2).setCellValue("Address");
            rowhead.createCell(3).setCellValue("Email");
            HSSFRow row = sheet1.createRow((short)1);
            row.createCell(0).setCellValue("1");
            row.createCell(1).setCellValue("Sankumarsingh");
            row.createCell(2).setCellValue("India");
            row.createCell(3).setCellValue("sankumarsingh@gmail.com");
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
