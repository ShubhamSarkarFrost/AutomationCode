import net.bytebuddy.asm.Advice;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ExcelData {

    public static String ExportData( String filepath, String sheetname, String cellvalue) throws IOException {
        FileInputStream fis = new FileInputStream(filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();
        for(int i = 0 ; i<sheets; i++){

            if(workbook.getSheetName(i).equalsIgnoreCase(sheetname)){
                XSSFSheet sheet = workbook.getSheetAt(i);

                // Identify Test Case Column by Scanning the entire row
                Iterator<Row> rows = sheet.iterator();
                Row firstrow = rows.next();
                Iterator<Cell> cell = firstrow.cellIterator();
                int flag = 0;
                int column ;
                while(cell.hasNext()){
                    Cell value = cell.next();
                    if(value.getStringCellValue().equalsIgnoreCase(cellvalue)){

                        column = flag;
                    }
                    flag ++;
                }
            }

        }

        return null;
    }

}
