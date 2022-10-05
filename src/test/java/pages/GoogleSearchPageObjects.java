package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.security.Key;

/**
 * @author Natalia Mykytiak
 */
public class GoogleSearchPageObjects {

    WebDriver driver;

    By textbox_search = By.name("q");
    By button_search = By.name("btnK");

    public GoogleSearchPageObjects(WebDriver driver){
        this.driver = driver;
    }


    public void setTextInSearchBox(String text){
        driver.findElement(textbox_search).sendKeys(text);
    }

    public void clickSearchButton(){
        driver.findElement(button_search).sendKeys(Keys.RETURN);
    }
}
