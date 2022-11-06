import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

public class RenameAPlaylist extends BaseTest {


    By newPlaylistLocator = By.cssSelector(".playlist:nth-child(3)");
    By getNewPlaylistTextFieldLocator =By.cssSelector("input[name='name']");
    String  newPlaylistName= "Best";

    @Test

    public void renameSelectedPlaylist() {
        login();
        chooseAPlaylist();
        nameNewPlaylist();
        Assert.assertEquals(newPlaylistName, getTextNameNewPlaylist());

    }
    public void login() {
        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
        waitForElementToBeClickable(emailField).click();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        waitForElementToBeClickable(passwordField).click();
        passwordField.sendKeys(Password);

        WebElement submitButton =driver.findElement(By.xpath("//button[@type='submit']"));
        waitForVisibilityOfElement(submitButton).click();


    }
    private void chooseAPlaylist() {
        WebElement playlist = driver.findElement(newPlaylistLocator);
        waitForVisibilityOfElement(playlist);
        Actions actions=new Actions(driver);
        actions.doubleClick(playlist).perform();
    }
    private void nameNewPlaylist() {
        WebElement renamedPlaylist=driver.findElement(getNewPlaylistTextFieldLocator);
        renamedPlaylist.sendKeys((Keys.chord(Keys.CONTROL + "a", Keys.BACK_SPACE)));
        waitForVisibilityOfElement(renamedPlaylist);
        renamedPlaylist.sendKeys(newPlaylistName);
        renamedPlaylist.sendKeys(Keys.ENTER);
    }




        private String getTextNameNewPlaylist() {
            return driver.findElement(newPlaylistLocator).getText();

        }


    }




