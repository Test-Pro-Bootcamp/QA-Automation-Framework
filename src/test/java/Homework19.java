import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {

        login();
        selectPlaylist();
        pressDeletePlaylist();

    }
    private void selectPlaylist()  {


            By myNewSongsLocator = (By.xpath("//a[contains(text(),'My new songs')]"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(myNewSongsLocator)).click();

    }

        private void pressDeletePlaylist () {
            By delPlaylistLocator = (By.xpath("//button[@title='Delete this playlist']"));
            wait.until(ExpectedConditions.elementToBeClickable(delPlaylistLocator)).click();

    }


        }







