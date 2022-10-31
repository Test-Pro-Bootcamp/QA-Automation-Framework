import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteMyPlaylistTests extends BaseTest {

    String email = "holostenco.yuliya@gmail.com";
    String Password = "te$t$tudent";
    String xpath = "//ul//li[@class='playlist playlist']";


    @Test
    public void deletePlaylist() throws InterruptedException {

        provideEmail();
        providePassword();
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

        WebElement playlistToDelete = driver.findElement(By.xpath("//li[text()='Delete']"));
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

    private void login() throws InterruptedException {
        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        Thread.sleep(2000);
        submitBtn.click();


    }

    private void providePassword() throws InterruptedException {
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));

        passwordField.click();
        Thread.sleep(2000);
        passwordField.sendKeys(Password);
    }

    private void provideEmail() throws InterruptedException {
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        Thread.sleep(3000);
        emailField.click();
        emailField.sendKeys(email);

    }
}
