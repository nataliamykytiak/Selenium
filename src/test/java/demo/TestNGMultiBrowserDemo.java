package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author Natalia Mykytiak
 */
public class TestNGMultiBrowserDemo {

    WebDriver driver;
    @BeforeTest
    @Parameters("browserName")
    public void setup(String browserName){
        System.out.println("Browser name is : " + browserName);
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/home/vasyl/IdeaProjects/Selenium/drivers/chromedriver/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "/home/vasyl/IdeaProjects/Selenium/drivers/geckodriver/geckodriver");
            driver = new FirefoxDriver();
        }
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(4000);
    }
    @AfterTest
    public void tearDown(){
        driver.close();
        System.out.println("Test completed successfully");
    }

}
