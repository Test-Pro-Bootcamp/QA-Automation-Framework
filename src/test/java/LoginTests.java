import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test(priority = 0)
    public void LoginValidEmailValidPasswordTest() throws InterruptedException {
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();

        WebElement avatarIcon = driver.findElement(By.xpath("//img[contains(@alt,'Avatar of')]"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }
    @Test(priority = 1)
    public void LoginInValidEmailPasswordTest() throws InterruptedException {
        provideEmail("dem@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test(priority = 2)
    public void LoginValidEmailEmptyPasswordTest() throws InterruptedException {
        provideEmail("demo@class.com");
        providePassword("");
        clickSubmitBtn();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }
    @Test (enabled = false, description = "example search ")
    public void LoginEmptyPasswordTest() {

        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            driver.get(url);

            WebElement searchBar = driver.findElement(By.cssSelector("[type='search']"));
            searchBar.click();
            searchBar.sendKeys("Dark Days");


            WebElement avatarIcon = driver.findElement(By.cssSelector("[alt = 'Avatar of student']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        } finally {
            driver.quit();
        }
    }


    }

