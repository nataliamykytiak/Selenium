package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

/**
 * @author Natalia Mykytiak
 */
public class GoogleSearchTest {

    private static WebDriver driver;


    public static void main(String[] args) {
        googleSearch();

    }


    public static void googleSearch(){
        System.setProperty("webdriver.chrome.driver", "/home/vasyl/IdeaProjects/Selenium/drivers/chromedriver/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        GoogleSearchPage.textBox_search(driver).sendKeys("abcd");
        GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);

        driver.close();

        System.out.println("Test completed successfully");


    }
}
