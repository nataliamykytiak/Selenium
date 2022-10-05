package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Natalia Mykytiak
 */
public class Test_GoogleSearch {
    public static void main(String[] args) {
        googleSearch();

    }


    public static void googleSearch(){
        System.setProperty("webdriver.chrome.driver", "/home/vasyl/IdeaProjects/Selenium/drivers/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
//        driver.findElement(By.name("btnK")).click();
        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

        driver.close();

        System.out.println("Test completed successfully");


    }
}
