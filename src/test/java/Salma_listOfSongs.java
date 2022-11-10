import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class Salma_listOfSongs extends Salma_BaseTest {


  @Test
    public void listOfSongsWebElements(){
      //verify playlist Salma has 3 songs
      logIn();
      //click on playlist Salma
      choosePlaylistByName("New Playlist");
      getListOfSongs();
      //verify that playlist has 3 songs by getting the size of the array
      Assert.assertEquals(getListOfSongs().size(),3);


  }

    private List getListOfSongs() {
        List <WebElement> songList = driver.findElements
                (By.cssSelector("#playlistWrapper .item-container td.title"));
        return songList;
    }

    private void choosePlaylistByName(String name) {
      WebElement playlistLocator = wait.until(ExpectedConditions.visibilityOfElementLocated
              (By.xpath("//a[text()='"+ name + "']")));
      playlistLocator.click();
    }

}
