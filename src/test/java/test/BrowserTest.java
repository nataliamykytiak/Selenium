package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * @author Natalia Mykytiak
 */
public class BrowserTest {

    public static void main(String[] args) {
//        System.setProperty("webdriver.gecko.driver", "/home/vasyl/IdeaProjects/Selenium/drivers/geckodriver/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/home/vasyl/IdeaProjects/Selenium/drivers/chromedriver/chromedriver");

//        WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

//        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("abcd");

        List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));

        int count = listOfInputElements.size();

        System.out.println("Count of input elements: " + count);


        driver.close();
    }
}
