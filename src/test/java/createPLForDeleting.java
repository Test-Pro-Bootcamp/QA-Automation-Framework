import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class createPLForDeleting extends BaseTest {

    @Test(priority=0)
    public void createNewPlaylist() {
        provideEmail("iq14111991@gmail.com");
        providePassword();
        clickSubmitBtn();

        createPL();
    }

    public void createPL(){
        WebElement createNewPlayListsButton = driver.findElement(new By.ByXPath("//*[@id=\"playlists\"]/h1/i"));

        createNewPlayListsButton.click();

        WebElement createNewPlayLists = driver.findElement(new By.ByXPath("//*[@id=\"playlists\"]/nav/ul/li[1]"));
        createNewPlayLists.click();
        WebElement createNewPlayListsKeyField = driver.findElement(new By.ByXPath("//*[@id=\"playlists\"]/form/input"));
        createNewPlayListsKeyField.click();
        createNewPlayListsKeyField.sendKeys("PlayListsForDeleting");
        createNewPlayListsKeyField.submit();

        WebElement PlayListsForDeleting = driver.findElement(By.xpath("//a[contains(text(), 'PlayListsForDeleting')]"));
        Assert.assertTrue(PlayListsForDeleting.isDisplayed());


        driver.quit();

    }

}