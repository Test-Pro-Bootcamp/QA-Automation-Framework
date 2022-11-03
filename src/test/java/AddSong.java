import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;



// following solution
//        Create a new file Homework17.java file with @Test annotation in IntelliJ IDEA
//        Create a test case addSongToPlaylist() using @Test annotations
//        and the helper/reusable methods we created
//        Navigate to "https://bbb.testpro.io/"
//        Log in with your credentials
//        Add a song to a playlist
//        Validate that there is a song added
//        Create a new branch and commit your changes
//        Push your code to a remote repository
//        Create a pull request
//        Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework
public class AddSong extends BaseTest {


    @Test

    public void AddSongToPlaylistTest () throws InterruptedException {
        //log in
        provideEmail("demo@class.com");
        providePassword();
        clickSubmitBtn();
        //add a song to playlist
        clickViewAllBtn();
        String getSongTitle = getSongTitleTxt();
        clickSongFromList();
        clickAddToPlayList();
        addToSuperPlaylist();
        clickOnSuperPlaylist();

        //Verify the song
        String songFromSuperPlaylist = getSongTitleFromSuperPlaylist();
        Assert.assertEquals(songFromSuperPlaylist, getSongTitle);
    }

    private void clickViewAllBtn() {
        WebElement viewAllButton = driver.findElement(By.xpath("//button[@data-testid='home-view-all-recently-played-btn']"));
        viewAllButton.click();
    }
    private void clickSongFromList() {
        WebElement songList = driver.findElement(By.xpath("//section[@ id='recentlyPlayedWrapper']//tr[@class= 'song-item']"));
        songList.click();
    }
    private void clickAddToPlayList() {
        WebElement addToPlaylist = driver.findElement(By.xpath("//button[contains(@title,'Add selected songs ')]"));
        addToPlaylist.click();
    }
    private void addToSuperPlaylist() {
        WebElement superPlaylist = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//li[contains(text(),'super')]"));
        superPlaylist.click();
    }
    private void clickOnSuperPlaylist() {
        WebElement superPlaylistLink = driver.findElement(By.xpath("//a[text()='super']"));
        superPlaylistLink.click();
    }


    private String getSongTitleFromSuperPlaylist() {
        WebElement superPlaylistSong = driver.findElement(By.xpath("//section[@id='playlistWrapper']//tr[@class='song-item']//td[@class='title']"));
        return superPlaylistSong.getText();
    }

    private String getSongTitleTxt() {
        WebElement getTitleTxt = driver.findElement(By.xpath("//section[@ id='recentlyPlayedWrapper']//tr[@class='song-item']//td[@class='title']"));
        return getTitleTxt.getText();
    }

}
