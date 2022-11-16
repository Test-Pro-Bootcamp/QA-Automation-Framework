import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreatePLforRenaming extends BaseTest{

    @Test
    public void createPLforRenaming() throws InterruptedException {

        provideEmail("iq14111991@gmail.com");
        providePassword();
        clickSubmitBtn();
        createPlProcess();
    }
    public void createPlProcess() throws InterruptedException {
        createNewPlayListsButton ();
        newPlayLists();
        newPlayListsKeyField();
        Check();
    }

       public static void createNewPlayListsButton() throws InterruptedException {
           WebElement createNewPlayListsButton = driver.findElement(new By.ByXPath("//*[@id=\"playlists\"]/h1/i"));
           wait = new WebDriverWait(driver,Duration.ofSeconds(3));
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id=\"homeWrapper\"]/header/div[2]/h1")));
           createNewPlayListsButton.click();
       }

       public static void newPlayLists() {
           WebElement createNewPlayLists = driver.findElement(new By.ByXPath("//*[@id=\"playlists\"]/nav/ul/li[1]"));
           createNewPlayLists.click();
       }

        public static void newPlayListsKeyField() {
            WebElement createNewPlayListsKeyField = driver.findElement(new By.ByXPath("//*[@id=\"playlists\"]/form/input"));
            createNewPlayListsKeyField.click();
            createNewPlayListsKeyField.sendKeys("CreatePLforRenaming");
            createNewPlayListsKeyField.submit();
        }


        public void Check(){
            WebElement newPlaylist = driver.findElement(By.xpath("//a[contains(text(), 'CreatePLforRenaming')]"));
            Assert.assertTrue(newPlaylist.isDisplayed());

            wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id=\"sidebar\"]/section[1]/ul/li[1]/a")));

            tearDownBrowser();
    }
}