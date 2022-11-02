import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RenameAPlaylist extends BaseTest {

    String email = "holostenco.yuliya@gmail.com";
    String Password = "te$t$tudent";
    String xpath = "//ul//li[@class='playlist playlist']";
    String css ="li>input";
   String  newPlaylistName=" -Best Club music Selection";

    @Test
    public void renameSelectedPlaylist(){
        login();
        chooseAPlaylist();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
        WebElement renamedPlaylist=driver.findElement(By.cssSelector(css));
        renamedPlaylist.sendKeys(newPlaylistName+"\n");
        Assert.assertTrue(renamedPlaylist.isDisplayed());
    }

    private void chooseAPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement playlist = driver.findElement(By.xpath(xpath));
        actions.doubleClick(playlist).perform();
    }

    private void login() {
        By emailLocator = By.xpath("//input[@placeholder='Email Address']");
        wait.until(ExpectedConditions.elementToBeClickable(emailLocator));
        WebElement emailField = driver.findElement(emailLocator);
        emailField.click();
        emailField.sendKeys(email);

        By passwordLocator = By.xpath("//input[@type='password']");
        wait.until(ExpectedConditions.elementToBeClickable(passwordLocator));
        WebElement passwordField = driver.findElement(passwordLocator);
        passwordField.click();
        passwordField.sendKeys(Password);

        By submitButtonLocator = By.xpath("//button[@type='submit']");
        wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        driver.findElement(submitButtonLocator).click();

    }


    }

