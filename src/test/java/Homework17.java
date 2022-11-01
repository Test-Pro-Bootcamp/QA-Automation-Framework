import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
        public void addSongToPlaylist() throws InterruptedException {
        provideEmail("salma.ayad.87@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        clickAllSongs();
        chooseSongClickAddTo();

        //Choose Playlist to add the song to

       // WebElement playlistDropdownSelector = driver.findElement(By.xpath("//*[@id='songsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        WebElement playlistDropdownSelector = driver.findElement(By.xpath("//section[@id='songsWrapper']//ul//li[contains(text() , 'Salma New Playlist')]"));
        playlistDropdownSelector.click();

       // WebElement myPlaylistSelector =
        Thread.sleep(2000);

        //Clicking on the playlist
        WebElement playlistSelector = driver.findElement(By.xpath("//a[text()='Salma New Playlist']"));
        playlistSelector.click();

        //Verifying the song is added to the playlist
        WebElement confirmSongIsAdded = driver.findElement(By.xpath("//div[@class='song-list-wrap main-scroll-wrap playlist']"));
        Assert.assertTrue(confirmSongIsAdded.getText().contains("Mid-Air Machine"));

    }

    private void chooseSongClickAddTo() {
        WebElement SongSelector = driver.findElement(By.xpath("//td[text()='Mid-Air Machine - If It_s All I Do']"));
        SongSelector.click();
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
    }

    public void clickAllSongs() {
        WebElement clickAllSongsBtn = driver.findElement(By.xpath("//a[@class='songs']"));
        clickAllSongsBtn.click();

    }

    @Test
    public void addSongToFavorites() throws InterruptedException {

                provideEmail("salma.ayad.87@gmail.com");
                providePassword("te$t$tudent");
                clickSubmitBtn();
                clickAllSongs();
                chooseSongClickAddTo();

                //Choose Playlist to add the song to

                // WebElement playlistDropdownSelector = driver.findElement(By.xpath("//*[@id='songsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
                WebElement playlistDropdownSelector = driver.findElement(By.xpath("//section[@id='songsWrapper']//ul//li[contains(text() , 'Salma New Playlist')]"));
                //section[@id='songsWrapper']//li[contains(text(),"Salma's New Playlist")]
                playlistDropdownSelector.click();

                // WebElement myPlaylistSelector =
                Thread.sleep(2000);

                //Clicking on the playlist
                WebElement playlistSelector = driver.findElement(By.xpath("//a[text()='Salma New Playlist']"));
                playlistSelector.click();

                //Verifying the song is added to the playlist
                WebElement confirmSongIsAdded = driver.findElement(By.xpath("//div[@class='song-list-wrap main-scroll-wrap playlist']"));
                Assert.assertTrue(confirmSongIsAdded.getText().contains("Mid-Air Machine"));

            }


    }


