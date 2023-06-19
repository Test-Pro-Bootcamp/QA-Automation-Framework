import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19RA extends BaseTest {
    /*  By avatarIconLocator = By.xpath("//img[contains(@alt,'Avatar of')]");
        By playlistLocator = By.cssSelector("#playlists h1");

        wait.until(ExpectedConditions.elementToBeClickable(avatarIconLocator));
        WebElement avatarIcon = driver.findElement(avatarIconLocator);
        Assert.assertTrue(avatarIcon.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(playlistLocator));
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(playlistLocator), "PLAYLISTS"));*/

    @Test
    public void deletePlaylist() {

        login();
        selectPlaylist();
        pressDeleteplaylist();
        //confirmDel(); THis is used if the playlist has songs saved in it
        Assert.assertNotNull(getConfirmationPopupText());
        Assert.assertTrue(getConfirmationPopupText().startsWith("Deleted playlist"));

    }

    private void selectPlaylist() {


        WebElement myPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        myPlaylist.click();
    }

    private void pressDeleteplaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[title='Delete this playlist']")));
        WebElement playlistDel = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        playlistDel.click();


    }

    //This was used to test when the playlist had songs in it.
    /*private void confirmDel() {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='dialog']//div")));
        WebElement okButton = driver.findElement(By.cssSelector(".ok"));
        okButton.click();

    }*/

    private String getConfirmationPopupText() {
        return driver.findElement(By.cssSelector("div.success.show")).getText();


    }
}
