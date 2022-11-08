
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test


public class LoginTests extends BaseTest {

   
    @Test
    
    public  void LoginEmptyEmailPasswordTest () {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @DataProvider(name = "invalidCredentials")
public Object[][] getDataFromDataProvider(){

        return  new Object[][]{
                {"invalid@gmail.com", "invalidPass"},
                {"d@gmail.com", ""},
                {"",""},
        };
}

    @Test(dataProvider = "invalidCredentials")
    public void LoginValidEmailValidPasswordTest (String email, String password) throws InterruptedException {
        provideEmail(email);
        providePassword(password);
        clickSubmitBtn();

        WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        Thread.sleep(2000);


    }

    }
