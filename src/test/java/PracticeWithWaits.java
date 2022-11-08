import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeWithWaits extends BaseTest {


    String email = "holostenco.yuliya@gmail.com";
    String Password = "te$t$tudent";
    By newPlaylistLocator = By.xpath("//ul//li[@class='playlist playlist']");
    String myPlaylistName = "iulia's playlist";

    @Test
    public void createPlaylist() {
        login();
        createAPlaylist();
        Assert.assertEquals(getConfirmationPopupText(), "Created playlist \"iulia's playlist.\"");

    }

    @Test
    public void deletePlaylist() {

        login();
        chooseAPlaylist();
        deleteSelectedPlaylist();
        Assert.assertEquals(getConfirmationPopupText(), "Deleted playlist \"iulia's playlist.\"");


    }

    private void createAPlaylist() {
        WebElement createAPlaylistButton = driver.findElement(By.xpath("//*[@title='Create a new playlist']"));
        waitForElementToBeClickable(createAPlaylistButton).click();


        WebElement newPlaylist = driver.findElement(By.xpath("//*[contains(text(),\"New Playlist\")]"));
        waitForElementToBeClickable(newPlaylist).click();


        WebElement newPlaylistNameField = driver.findElement(By.xpath("//*[contains(@placeholder, 'to save')]"));
        waitForElementToBeClickable(newPlaylistNameField).click();
        newPlaylistNameField.sendKeys(myPlaylistName + "\n");

    }

    public void login() {
        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
        waitForElementToBeClickable(emailField);
        emailField.click();
        emailField.sendKeys(email);

        WebElement passwordLocator = driver.findElement(By.xpath("//input[@type='password']"));
        waitForElementToBeClickable(passwordLocator);
        passwordLocator.click();
        passwordLocator.sendKeys(Password);

        WebElement submitButton =driver.findElement(By.xpath("//button[@type='submit']"));
        waitForVisibilityOfElement(submitButton).click();


    }

    private String getConfirmationPopupText() {
        WebElement notificationMessage = driver.findElement(By.cssSelector("div.success.show"));
        waitForVisibilityOfElement(notificationMessage);
        return driver.findElement(By.cssSelector("div.success.show")).getText();


    }

    private void deleteSelectedPlaylist() {
        WebElement playlistToDelete = driver.findElement(By.xpath("//li[text()='Delete']"));
        waitForElementToBeClickable(playlistToDelete).click();



    }

    private void chooseAPlaylist() {

        WebElement playlist = driver.findElement(newPlaylistLocator);
        waitForVisibilityOfElement(playlist);
        Actions actions=new Actions(driver);
        actions.contextClick(playlist).perform();
    }


}

