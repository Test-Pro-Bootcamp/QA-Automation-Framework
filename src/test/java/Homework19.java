import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v104.console.model.ConsoleMessage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class Homework19 extends BaseTest {

    @Test(priority=1)
    public void deletePlayList() throws InterruptedException {

        provideEmail("iq14111991@gmail.com");
        providePassword();
        clickSubmitBtn();
        deletePL();
    }
    private void deletePL() throws InterruptedException {

        chosePL();
        getPlaylistLink();
        deleteChosenPL();
        verifyRemovedPL();
    }

    private void chosePL(){

        WebElement chosePL = driver.findElement(By.xpath("//a[contains(text(), 'PlayListsForDeleting')]"));
        chosePL.click();
    }
    public void getPlaylistLink() {

        WebElement getPlaylistLink = driver.findElement(By.xpath("//a[contains(text(), 'PlayListsForDeleting')]"));
        getPlaylistLink.click();
        driver.navigate().refresh();
    }
        private void deleteChosenPL(){

        WebElement getPlaylistLink = driver.findElement(By.xpath("//a[contains(text(), 'PlayListsForDeleting')]"));
        getPlaylistLink.click();
        driver.navigate().refresh();
        WebElement deleteChosenPL = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[3]/span/button"));
        deleteChosenPL.click();
    }
    private void verifyRemovedPL (){

        WebElement verifyRemovedPL = driver.findElement(By.xpath("//a[contains(text(), 'PlayListsForDeleting')]"));
        Assert.assertEquals(true, verifyRemovedPL.isDisplayed());
        tearDownBrowser();
    }

}
