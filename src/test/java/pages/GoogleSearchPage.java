package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Natalia Mykytiak
 */
public class GoogleSearchPage {

    private static WebElement element;

    public static WebElement textBox_search(WebDriver driver) {
        element = driver.findElement(By.name("q"));
        return element;
    }

    public static WebElement button_search(WebDriver driver) {
        element = driver.findElement(By.name("btnK"));
        return element;
    }

}
