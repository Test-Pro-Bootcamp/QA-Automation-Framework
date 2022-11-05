import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public  void LoginEmptyEmailPasswordTest() {

        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public  void LoginValidEmailValidPasswordTest() throws InterruptedException {
          provideEmail();
          providePassword();
          clickSubmitBtn();


          WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
          Assert.assertTrue(avatarIcon.isDisplayed());

           Thread.sleep(2000);


    }

}