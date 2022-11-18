package practicePO.pages.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePagesimple {
    WebDriver driver;
    WebDriverWait wait;
    public void BasePage(WebDriver givenDriver) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bbb.testpro.io/");
    }
    public void closeBroweser() {
        driver.quit();

    }
    public boolean isAvatarDisplaying(){
        return  driver.findElement(By.cssSelector("[alt='Avatar of student']")).isDisplayed();
    }

}
