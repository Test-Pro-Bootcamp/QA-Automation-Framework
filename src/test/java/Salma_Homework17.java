import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Salma_Homework17 extends Salma_BaseTest {
    String songName = "Waiting On A Train";
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

        Thread.sleep(2000);

        //Clicking on the playlist
        WebElement playlistSelector = driver.findElement(By.xpath("//a[text()='Salma New Playlist']"));
        playlistSelector.click();

        //Verifying the song is added to the playlist
        WebElement confirmSongIsAdded = driver.findElement(By.xpath("//div[@class='song-list-wrap main-scroll-wrap playlist']"));
        Assert.assertTrue(confirmSongIsAdded.getText().contains("Mid-Air Machine"));

    }

    private void chooseSongClickAddTo() {

        WebElement SongSelector = driver.findElement(By.xpath("//td[contains(text() , '"+ songName + "')]"));
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

        logIn();
        clickAllSongs();
        chooseSongClickAddTo();
        Thread.sleep(2000);

        //Adding song to favorites
        WebElement favoritesDropDownSelector = driver.findElement(By.xpath("//section[@id='songsWrapper']//li[@class='favorites']"));
        favoritesDropDownSelector.click();


        //Clicking on favorites
        WebElement favoritesSelector = driver.findElement(By.xpath("//a[text()='Favorites']"));
        favoritesSelector.click();
        Thread.sleep(2000);
        //Verifying the song is added to favorites
        //System.out.println(getSongTextFromFavorites());
        Assert.assertTrue(getSongTextFromFavorites().contains(songName));

    }
    public String getSongTextFromFavorites(){
        WebElement favoritesSection = driver.findElement(By.xpath("//div[@class='song-list-wrap main-scroll-wrap favorites']"));
        return favoritesSection.getText();
    }

//This Locator is not getting text from song
//    public String getSongText(){
//        WebElement songSelector = driver.findElement(By.xpath("//td[contains(text() , 'Waiting On A Train')]"));
//        return songSelector.getText();
//    }



}