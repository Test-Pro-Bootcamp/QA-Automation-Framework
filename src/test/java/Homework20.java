import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20  extends BaseTest{
        @Test(dataProvider = "loginData",dataProviderClass = BaseTest.class)
        public void removeSong(String email,String password) {
            launchBrowser(url);
            mainLogin();
            clickOnPlaylist();
            deletePlaylist();
        }
        public void clickOnPlaylist () {
            WebElement openPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() ='Nargiza']")));
            Assert.assertTrue(openPlaylist.isDisplayed());
            openPlaylist.click();
        }
        private void deletePlaylist(){
            WebElement delPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title = 'Delete this playlist']")));
           delPlaylist.click();
        }
    }



