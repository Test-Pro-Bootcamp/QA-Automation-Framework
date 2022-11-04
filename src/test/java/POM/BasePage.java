package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

   public BasePage(WebDriver mainDriver) {
       driver = mainDriver;
       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   }
}
