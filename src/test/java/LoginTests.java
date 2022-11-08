import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class  LoginTests extends BaseTest {
   



    @Test
    public void LoginEmptyEmailPasswordTest() throws InterruptedException{

        Assert.assertEquals(driver.getCurrentUrl(), url);
        tearDownBrowser();
    }
   // @DataProvider(name="invalidCredentials")
//public Object[] [] getDataFromProviders(){

       // return  new Object[][]{
               // {"Invalid@class.com", "InvalidPass"},
               // {"demo@class.com", ""},
                {//"",""}
        };

    @Test
    public void LoginValidEmailValidPasswordTest() throws InterruptedException {

        LoginPage loginPage=new LoginPage(driver);

        provideEmail("holostenco.yuliya@gmail.com"); //"holostenco.yuliya@gmail.com"
        providePassword(); //te$t$tudent
        clickonSubmitBtn();
        Thread.sleep(2000);
        WebElement avatarIcon= driver.findElement(By.xpath("//*[contains(@alt,'Avatar of')]"));
        Assert.assertTrue(avatarIcon.isDisplayed());


    }

    @Test
    public void LoginInValidEmailPasswordTest() throws InterruptedException{
        provideEmail("holost@gmail.com");
        providePassword();
        clickonSubmitBtn();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }


    private void clickonSubmitBtn() {
        WebElement submitBtn= driver.findElement(By.xpath("//button[@type='submit']"));
        submitBtn.click();

    }

    private void providePassword() {
        WebElement passwordField= driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
    }

    private void provideEmail(String email) {
        WebElement emailField= driver.findElement(By.xpath("//input[@type='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }
}