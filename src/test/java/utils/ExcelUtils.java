package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

/**
 * @author Natalia Mykytiak
 */
public class ExcelUtils {
     static XSSFWorkbook workbook = null;
     static XSSFSheet sheet = null;

    public ExcelUtils(String excelPath, String sheetName){
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        getRowCount();
//        getCellDataString(0, 0);
//        getCellDataNumber(1, 1);
    }

    public int getRowCount(){
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println(rowCount);
        return rowCount;
    }

    public int getColumnCount(){
        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println(columnCount);
        return columnCount;
    }

    public String getCellDataString(int rowNumber, int columnNumber){
        String cellData = sheet.getRow(rowNumber).getCell(columnNumber).getStringCellValue();
//        System.out.println(cellData);
        return cellData;
    }

    public void getCellDataNumber(int rowNumber, int columnNumber){
        Double cellData = sheet.getRow(rowNumber).getCell(columnNumber).getNumericCellValue();
        System.out.println(cellData);
    }
}
