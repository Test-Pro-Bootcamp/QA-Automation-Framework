import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {


    @Test
    public void deletePlaylist() throws InterruptedException {
        provideEmail("kaflimeerim@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        selectAPlaylist();
        pressDeletePlaylist();
        Assert.assertEquals(getConfirmationPopUpText(), "Deleted Playlist");
        
    }
    private void selectAPlaylist() throws InterruptedException {
        WebElement myNewSongs = driver.findElement(By.xpath("//a[contains(text(),'My new songs')]"));
        myNewSongs.click();
        Thread.sleep(4000);

    }
    private void pressDeletePlaylist() throws InterruptedException {

        WebElement pressPlaylistBar = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
        pressPlaylistBar.click();
        Thread.sleep(4000);


    }
    private String getConfirmationPopUpText() {
        return driver.findElement(By.xpath("//html/body/div[2]")).getText();
}
}


    