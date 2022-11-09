
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import POM.pages.AllSongsPage;
import POM.pages.BasePage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;



public class LoginTests extends BaseTest{


    @Test(enabled = false, priority = 0)
    public void LoginEmptyEmailPasswordTest() {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    
    }

    @Test(enabled = false, priority = 0)
    public void OpenLoginPageTest () {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test (enabled=false, priority = 1)// (priority = 1, dataProvider = "invalidCredentials", dataProviderClass = BaseTest.class)
    public void LoginValidEmailValidPasswordTest () {

        login();
       
        
         By avatarIconLocator = By.xpath("//img[contains(@alt,'Avatar of')]");
               
         wait.until(ExpectedConditions.elementToBeClickable(avatarIconLocator));
         WebElement avatarIcon = driver.findElement(avatarIconLocator);
         Assert.assertTrue(avatarIcon.isDisplayed());
      
       
    }

