package utils;

/**
 * @author Natalia Mykytiak
 */
public class ExcelUtilsDemo {
    public static void main(String[] args) {
        ExcelUtils excel = new ExcelUtils("/home/vasyl/IdeaProjects/Selenium/excel/data.xlsx",
                "Sheet1");
        excel.getRowCount();
        excel.getCellDataString(0, 0);
        excel.getCellDataNumber(1, 1);
    }

}
