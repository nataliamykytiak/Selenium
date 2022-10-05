package test;

import config.PropertiesFile;
import demo.Log4JDemo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Natalia Mykytiak
 */
public class TestNGDemo {

    WebDriver driver;

    public static String browserName;

    private static Logger logger = LogManager.getLogger(Log4JDemo.class);

    @BeforeTest
    public void setUpTest() {
        PropertiesFile.getProperties();
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/home/vasyl/IdeaProjects/Selenium/drivers/chromedriver/chromedriver");
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/home/vasyl/IdeaProjects/Selenium/drivers/geckodriver/geckodriver");
            driver = new FirefoxDriver();
        }
        logger.info("Browser started");
    }

    @Test
    public void googleSearch(){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

    }

    @AfterTest
    public void tearDownTest(){
        driver.close();
//        driver.quit();
        System.out.println("Test completed successfully");
        PropertiesFile.setProperties();
    }
}
