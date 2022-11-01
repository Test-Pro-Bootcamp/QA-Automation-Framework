import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeWithWaits extends BaseTest {


    String email = "holostenco.yuliya@gmail.com";
    String Password = "te$t$tudent";
    String xpath = "//ul//li[@class='playlist playlist']";
    String myPlaylistName="iulia's playlist";

    @Test
    public void createPlaylist(){
        provideEmail();
        providePassword();
        login();
        createAPlaylist();
        Assert.assertEquals(getConfirmationPopupText(), "Created playlist \"iulia's playlist.\"");

    }
    @Test
    public void deletePlaylist() {
        provideEmail();
        providePassword();
        login();
        chooseAPlaylist();
        deleteSelectedPlaylist();
        Assert.assertEquals(getConfirmationPopupText(), "Deleted playlist \"iulia's playlist.\"");


    }

    private void createAPlaylist() {
        By createAPlaylistButtonLocator=By.xpath("//*[@title='Create a new playlist']");
        wait.until(ExpectedConditions.elementToBeClickable(createAPlaylistButtonLocator));
        driver.findElement(createAPlaylistButtonLocator).click();

        By newPlaylistLocator=By.xpath("//*[contains(text(),\"New Playlist\")]");
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylistLocator));
        driver.findElement(newPlaylistLocator).click();

By newPlaylistNameFieldLocator=By.xpath("//*[contains(@placeholder, 'to save')]");

        wait.until(ExpectedConditions.elementToBeClickable(newPlaylistNameFieldLocator));
        WebElement newPlaylistNameField= driver.findElement(newPlaylistNameFieldLocator);
        newPlaylistNameField.click();
        newPlaylistNameField.sendKeys(myPlaylistName + "\n");

    }

    private String getConfirmationPopupText() {
        By notificationMessageLocator = By.cssSelector("div.success.show");
        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationMessageLocator));
        return driver.findElement(By.cssSelector("div.success.show")).getText();


    }

    private void deleteSelectedPlaylist() {
        By playlistToDeleteLocator = By.xpath("//li[text()='Delete']");
        wait.until(ExpectedConditions.elementToBeClickable(playlistToDeleteLocator));
        driver.findElement(playlistToDeleteLocator).click();


    }

    private void chooseAPlaylist() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement playlist = driver.findElement(By.xpath(xpath));
        actions.contextClick(playlist).perform();
    }

    private void login() {
        By submitButtonLocator = By.xpath("//button[@type='submit']");
        wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        driver.findElement(submitButtonLocator).click();


    }

    private void providePassword() {
        By passwordLocator = By.xpath("//input[@type='password']");
        wait.until(ExpectedConditions.elementToBeClickable(passwordLocator));
        WebElement passwordField = driver.findElement(passwordLocator);
        passwordField.click();
        passwordField.sendKeys(Password);
    }

    private void provideEmail() {
        By emailLocator = By.xpath("//input[@placeholder='Email Address']");
        wait.until(ExpectedConditions.elementToBeClickable(emailLocator));
        WebElement emailField = driver.findElement(emailLocator);
        emailField.click();
        emailField.sendKeys(email);

    }
}

