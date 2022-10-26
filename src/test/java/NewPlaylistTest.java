import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewPlaylistTest {
    @Test
    public static void createNewPlaylist() throws InterruptedException {
        WebDriver driverFour = new ChromeDriver();
        driverFour.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        By editEmailSelector = By.cssSelector("[type='email']");
        By editPasswordSelector = By.cssSelector("[type='password']");
        By submitButtonThreeSelector = By.cssSelector("[type='submit']");
        By additionButtonSelector = By.xpath("//*[@title = 'Create a new playlist']");
        By createNewListSelector = By.xpath("//li[contains(text(),'New Playlist')]");
        By editNameSelector = By.xpath("//input[@placeholder ='↵ to save']");




            String url = "https://bbb.testpro.io/";
            driverFour.get(url);
            Assert.assertEquals(driverFour.getCurrentUrl(),url);

            String signIn = "nargiza10041@gmail.com";
            String enterPassword = "te$t$tudent";
            String listName = "Nargizas Playlist";
            WebElement editEmail = driverFour.findElement(editEmailSelector);
            editEmail.click();
            editEmail.sendKeys(signIn);

            WebElement editPassword = driverFour.findElement(editPasswordSelector);
            editPassword.click();
            editPassword.sendKeys(enterPassword);
            WebElement submitButtonThree= driverFour.findElement(submitButtonThreeSelector);
            submitButtonThree.click();
            Thread.sleep(2000);
            WebElement additionButton = driverFour.findElement(additionButtonSelector);
            additionButton.click();
            Thread.sleep(2000);
            WebElement createNewList = driverFour.findElement(createNewListSelector);
            createNewList.click();
            WebElement insertText = driverFour.findElement(editNameSelector);
            insertText.click();
            insertText.sendKeys(listName);
            Thread.sleep(2000);
            insertText.sendKeys(Keys.ENTER);
            
    }
}