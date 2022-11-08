import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteMyPlaylistTests extends BaseTest {


    String xpath = "//ul//li[@class='playlist playlist']";

    @Test
    public void deletePlaylist() throws InterruptedException {


        login();
        chooseAPlaylist();
        deleteSelectedPlaylist();
        Assert.assertEquals(getConfirmationPopupText(), "Deleted playlist \"iulia's p laylist.\"");


    }

    private String getConfirmationPopupText() throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElement(By.cssSelector("div.success.show")).getText();


    }

    private void deleteSelectedPlaylist() throws InterruptedException {
        By playlistToBeDeletedLocator = By.xpath("//li[text()='Delete']");

        WebElement playlistToDelete = driver.findElement(playlistToBeDeletedLocator);
        Thread.sleep(2000);
        playlistToDelete.click();

        // WebElement buttonOk = driver.findElement(By.xpath("//button[@class='ok']"));
        // Thread.sleep(3000);
        // buttonOk.click();


    }

    private void chooseAPlaylist() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement playlist = driver.findElement(By.xpath(xpath));
        Thread.sleep(3000);
        actions.contextClick(playlist).perform();
    }


    public void login() {
        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
        waitForElementToBeClickable(emailField);
        emailField.click();
        emailField.sendKeys(myEmail);

        WebElement passwordLocator = driver.findElement(By.xpath("//input[@type='password']"));
        waitForElementToBeClickable(passwordLocator);
        passwordLocator.click();
        passwordLocator.sendKeys(myPassword);

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        waitForVisibilityOfElement(submitButton).click();
    }
}
