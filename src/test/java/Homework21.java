import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v104.console.model.ConsoleMessage;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class Homework21 extends BaseTest {

    @Test(priority=1)
    public void renamePlayList() throws InterruptedException {

        provideEmail("iq14111991@gmail.com");
        providePassword();
        clickSubmitBtn();
        renamePL();
    }
    private void renamePL() throws InterruptedException {

        choseAndRenamePL();

        verifyRenamedPL();
    }

    private void choseAndRenamePL(){
        WebElement chosePL = driver.findElement(By.xpath("//a[contains(text(), 'CreatePLforRenaming')]"));
        Actions actions = new Actions(driver);
        actions.contextClick(chosePL).perform();
        WebElement editPL = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/nav/ul/li[1]"));
        editPL.click();

        WebElement toClear = driver.findElement(By.name("name"));
        toClear.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        toClear.sendKeys("It's WORKING????");
        toClear.sendKeys(Keys.ENTER );


    }
    private void verifyRenamedPL (){
        WebElement verifyRenamedPL = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[2]/h1"));
        Assert.assertEquals(true, verifyRenamedPL.isDisplayed());
    }

}