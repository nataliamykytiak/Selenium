package utils;

import config.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Natalia Mykytiak
 */
public class ExcelDataProvider {
    WebDriver driver;

    @BeforeTest
    public void setUpTest() {
        PropertiesFile.getProperties();
        System.setProperty("webdriver.chrome.driver", "/home/vasyl/IdeaProjects/Selenium/drivers/chromedriver/chromedriver");
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "test1data")
    public void test1(String username, String password) throws InterruptedException {
        System.out.println(username + " | " + password);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(2000);

    }


    @DataProvider(name = "test1data")
    public Object[][] getData(){
        String excelPath = "/home/vasyl/IdeaProjects/Selenium/excel/data.xlsx";
        Object[][] data = testData(excelPath, "Sheet1");
        return data;
    }

    public Object[][] testData(String excelPath, String sheetName){
        ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
        int rowCount = excel.getRowCount();
        int columnCount = excel.getColumnCount();

        Object data[][] = new Object[rowCount-1][columnCount];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                String cellData = excel.getCellDataString(i, j);
//                System.out.print(cellData + " | ");
                data[i-1][j] = cellData;
            }
        }
        return data;

    }
}
