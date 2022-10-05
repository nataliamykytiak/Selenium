package demo;

import java.time.Duration;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/home/vasyl/IdeaProjects/Selenium/drivers/chromedriver/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("Admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin123");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
    driver.findElement(By.xpath("//div[@id='app']/div/div/header/div/div[2]/ul/li/span/i")).click();
    driver.findElement(By.linkText("Logout")).click();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
