package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class RenamePlaylistTest extends BaseTest{

    Actions action;

    @Test (priority = 1, description = "Playing a Song & Validating")
    public void doubleClickChoosePlaylist() throws InterruptedException{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
            WebElement webElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        action.doubleClick(webElement).perform();
        }

        public void choosePlaylist() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        }

        public void enterPlaylistName() {
            WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
            playlistInputField.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
            playlistInputField.sendKeys("Party Hits");
            playlistInputField.sendKeys(Keys.ENTER);
        }

        public boolean locateNewPlaylistName() {
            WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Party Hits']"));
            return playlistElement.isDisplayed();
        }
    }


