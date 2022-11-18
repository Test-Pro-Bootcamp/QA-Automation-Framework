import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW17 extends BaseTest{

    @Test
    public void addSongToPlaylist(){
     provideEmail("yuliyakis85@gmail.com");
     providePassword("te$t$tudent");
     clickSubmitBtn();
     clickViewBttn();
     String getSongTitle= getSongTitleTxt();
     clickSongList();
     clickAddToList();
     addToMondayPlayList();
     clickOnMondayPlaylist();

     String songFromMondayPlaylist =getSongTitleFromMondayPlaylist();
     Assert.assertEquals(songFromMondayPlaylist,getSongTitle);
    }


    private String getSongTitleFromMondayPlaylist() {
        WebElement MondayPlaylistSong = driver.findElement(By.xpath("/section[@id='playlistWrapper']//tr[@class='song-item']//td[@class='title']"));
    return MondayPlaylistSong.getText();
    }

    private void clickOnMondayPlaylist() {
        WebElement MondayPlaylistLink = driver.findElement(By.xpath(" //a[text()='Monday']"));
        MondayPlaylistLink.click();
    }

    private void addToMondayPlayList() {
        WebElement MondayPlayList= driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//li[contains(text(), 'Monday')]"));
        MondayPlayList.click();
    }

    private String getSongTitleTxt() {
        WebElement getTitleTxt= driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//tr[@class='song-item']//td[@class='title']"));
        return getTitleTxt.getText();
    }

    private void clickAddToList() {
        WebElement addToList= driver.findElement(By.xpath(" //button[@class='btn-add-to']"));
        addToList.click();
    }

    private void clickSongList() {
        WebElement songList= driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//tr[@class='song-item']//td[@class='title']"));
        songList.click();
    }

    private void clickViewBttn() {
        WebElement viewAllBtn= driver.findElement(By.xpath("//button[@data-testid='home-view-all-recently-played-btn']"));
        viewAllBtn.click();
    }

}
