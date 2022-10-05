package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Natalia Mykytiak
 */
public class ExtentReportsBasicDemo {
    private static WebDriver driver;

    public static void main(String[] args) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReports.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        ExtentTest test = extent.createTest("Google Search Test1", "Google Search");

        System.setProperty("webdriver.chrome.driver", "/home/vasyl/IdeaProjects/Selenium/drivers/chromedriver/chromedriver");
        driver = new ChromeDriver();
        test.log(Status.INFO, "Starting Test Case");

        driver.get("https://www.google.com/");
        test.pass("Navigating to google.com");

        driver.findElement(By.name("q")).sendKeys("hhhhh");
        test.pass("Entering text into search box");

        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        test.pass("Pressing search button");

        driver.close();
        driver.quit();
        test.pass("Closing browser");
        test.info("Test completed");


        ExtentTest test2 = extent.createTest("Google Search Test2", "Google Search Again");

        System.setProperty("webdriver.chrome.driver", "/home/vasyl/IdeaProjects/Selenium/drivers/chromedriver/chromedriver");
        driver = new ChromeDriver();
        test2.log(Status.INFO, "Starting Test Case");

        driver.get("https://www.google.com/");
        test2.pass("Navigating to google.com");

        driver.findElement(By.name("q")).sendKeys("hhhhh");
        test2.pass("Entering text into search box");

        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        test2.fail("Pressing search button");

        driver.close();
        driver.quit();
        test2.pass("Closing browser");
        test2.info("Test completed");



        extent.flush();

    }
}
