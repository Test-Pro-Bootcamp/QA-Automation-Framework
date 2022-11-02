import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.time.Duration;


public class Homework20 extends BaseTest {

    @Test (priority = 1, dataProvider = "loginProvider", dataProviderClass = BaseTest.class)
    public void validLogin(String email, String password) throws InterruptedException {
        provideEmail("dankoyanka@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();

        deletePlaylist();
    }
    }
//    public void deletePlaylist() throws InterruptedException {
//
////        login("dankoyanka@gmail.com", "te$t$tudent");
//
//        WebElement playlist = driver.findElement
//                (By.cssSelector(".playlist.playlist"));
//        playlist.click();
//        Thread.sleep(2000);
//
//        WebElement delbtn = driver.findElement
//                (By.xpath("//button[@class='del btn-delete-playlist']"));
//        delbtn.click();
//        Thread.sleep(2000);
//
//        WebElement confirmBtn = driver.findElement
//                (By.xpath("//button[@class='ok']"));
//        confirmBtn.click();
//        Thread.sleep(2000);
//
//        WebElement poPup = driver.findElement(By.xpath
//                (" //div[@class='success show']"));
//        Assert.assertTrue(poPup.isDisplayed());
//
//    }



