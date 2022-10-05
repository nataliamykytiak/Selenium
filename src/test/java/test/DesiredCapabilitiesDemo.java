package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Natalia Mykytiak
 */
public class DesiredCapabilitiesDemo {
    public static void main(String[] args) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        System.setProperty("webdriver.chrome.driver", "/home/vasyl/IdeaProjects/Selenium/drivers/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("qwe");
        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
        driver.close();
        driver.quit();

    }
}
