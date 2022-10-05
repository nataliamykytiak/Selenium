package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPageObjects;

/**
 * @author Natalia Mykytiak
 */
public class GoogleSearchPageTest {
    private static WebDriver driver;

    public static void main(String[] args) {
        googleSearchTest();

    }

    public static void googleSearchTest(){
        System.setProperty("webdriver.chrome.driver", "/home/vasyl/IdeaProjects/Selenium/drivers/chromedriver/chromedriver");
        driver = new ChromeDriver();

        GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);

        driver.get("https://www.google.com/");

        searchPageObj.setTextInSearchBox("abcd");
        searchPageObj.clickSearchButton();

        driver.close();
    }
}
