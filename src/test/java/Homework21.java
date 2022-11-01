import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;


public class Homework21 extends BaseTest{

    @Test(dataProvider ="loginData",dataProviderClass = BaseTest.class)
    public void renamePlaylist(String email, String password){
        launchBrowser(url);
        mainLogin();
        selectPlaylist();
        doubleClickOnPlaylist();
        enterName();
        verifyNewPlaylist();


    }


    public void selectPlaylist() {
        WebElement clickPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() ='Nargiza']")));
        Assert.assertTrue(clickPlaylist.isDisplayed());
        clickPlaylist.click();
    }
    public void doubleClickOnPlaylist() {
        WebElement doubleClickOn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() ='Nargiza']")));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickOn).perform();
    }
    public void enterName() {
        WebElement viewTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid = 'inline-playlist-name-input']")));
        viewTextField.sendKeys(Keys.chord(Keys.COMMAND,"a",Keys.BACK_SPACE));
        viewTextField.sendKeys("NewOnePlaylist");
        viewTextField.sendKeys(Keys.ENTER);

    }
    public boolean verifyNewPlaylist() {
        WebElement playlistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() ='NewOnePlaylist']")));
        return playlistName.isDisplayed();
    }
}
