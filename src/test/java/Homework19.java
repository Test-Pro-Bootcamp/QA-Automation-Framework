import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() {

        login();
        selectPlaylist();
        pressDeletePlaylist();

    }
    private void selectPlaylist()  {


        By myNewSongsLocator = (By.xpath("//a[contains(text(),'My new song')]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(myNewSongsLocator)).click();
        Assert.assertEquals(driver.findElement(myNewSongsLocator).getText(),"My new songs");


    }

    private void pressDeletePlaylist () {
        By delPlaylistLocator = (By.xpath("//button[@title='Delete this playlist']"));
        wait.until(ExpectedConditions.elementToBeClickable(delPlaylistLocator)).click();




    }


}

