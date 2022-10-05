package demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

/**
 * @author Natalia Mykytiak
 */
public class FluentWaitDemo {

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    public static void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/vasyl/IdeaProjects/Selenium/drivers/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("abcd");
        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

//        driver.findElement(By.linkText("Alphabet abcd - Учебные ресурсы - Wordwall")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                WebElement linkElement = driver.findElement(By.xpath("//h3[contains(text(),'ABCD: Any Body Can Dance - Wikipedia')]"));
                if (linkElement.isEnabled()){
                    System.out.println("Element found");
                }
                return linkElement;
            }
        });

        element.click();

        Thread.sleep(3);
        driver.close();
        driver.quit();


    }
}
