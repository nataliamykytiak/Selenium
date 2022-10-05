package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

/**
 * @author Natalia Mykytiak
 */
public class ExtentReportsDemoWithTest {
    ExtentSparkReporter htmlReporter;
    ExtentReports extent;
    WebDriver driver;

    @BeforeSuite
    public void setUp(){
        htmlReporter = new ExtentSparkReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        System.setProperty("webdriver.chrome.driver", "/home/vasyl/IdeaProjects/Selenium/drivers/chromedriver/chromedriver");
        driver = new ChromeDriver();
    }


    @Test
    public void test1(){
        ExtentTest test = extent.createTest("Google Search Test1", "Google Search");
        driver.get("https://www.google.com/");
        test.log(Status.INFO, "This step shows usage of log");
        test.info("This - usage of info");
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.addScreenCaptureFromPath("screenshot.png");
    }

    @AfterSuite
    public void tearDown(){
        extent.flush();
    }
}
