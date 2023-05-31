import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException{
        //Login to webapp
        navigateToPage();
        provideEmail("khushbu07@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();

        //Add a new song to playlist
        clickViewAllButton();
        clickSongFromList();
        clickAddtoPlaylist();
        addSelectedSong();
        clickOnPlaylist();

        //Verify added song
        String getSongTitle =  getSongTitleTxt();
        String verifyAddedSong = getAddedSong();
        Assert.assertEquals(verifyAddedSong, getSongTitle);
    }

    private void clickViewAllButton() throws InterruptedException {
        WebElement viewAllBtn = driver.findElement(By.xpath("//*[@data-testid = 'home-view-all-recently-played-btn']"));
        viewAllBtn.click();
        Thread.sleep(4000);
    }

    private void clickSongFromList() throws InterruptedException{
        WebElement clickSong = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//tr[@class='song-item']"));
        clickSong.click();
        Thread.sleep(4000);
    }

    private void clickAddtoPlaylist() throws InterruptedException{
        WebElement clickAddtoPlaylist = driver.findElement(By.xpath("//*[@id='recentlyPlayedWrapper']/header/div[3]/span/button[2]"));
        clickAddtoPlaylist.click();
        Thread.sleep(4000);
    }

    private void addSelectedSong() throws InterruptedException{
        WebElement addSelectedSong = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//li[contains(text(),'Playlist12')]"));
        addSelectedSong.click();
        Thread.sleep(4000);
    }

    private void clickOnPlaylist() throws InterruptedException{
        WebElement clickOnPlaylist = driver.findElement(By.xpath("//a[text()='Playlist12']"));
        clickOnPlaylist.click();
        Thread.sleep(4000);
    }

    private String getSongTitleTxt() {
        WebElement getTitletxt = driver.findElement(By.xpath("//section[@id='playlistWrapper']//table[@class='items']//td[@class='title']"));
        return getTitletxt.getText();
    }

    private String getAddedSong() {
        WebElement verifyAddedSong = driver.findElement(By.xpath("//section[@id='playlistWrapper']//tr[@class='song-item']//td[@class='title']"));
        return verifyAddedSong.getText();
    }
}
