import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork17RA extends BaseTest {
/*
    Create a new file Homework17.java file with @Test annotation in IntelliJ IDEA
    Create a test case addSongToPlaylist() using @Test annotations
    and the helper/reusable methods we created
    Navigate to "https://bbb.testpro.io/"
    Log in with your credentials
    Add a song to a playlist
    Validate that there is a song added
    Create a new branch and commit your changes
    Push your code to a remote repository
    Create a pull request
    Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework*/
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        // login
        provideEmail("dirzo@gmail.com");
        providePassword("Te$ter1234");
        clickSubmitBtn();
        // add songs
        clickViewall();
        clicksongList();
        clickaddSong();
        clickplayList();
        clicklistTitle();
        String songTitle = songTitletext();
        Thread.sleep(1000);

        String songFrom16isDone = getsongFrom16isDone();
        Assert.assertEquals(songFrom16isDone, songTitle);
    }

    private String getsongFrom16isDone() {
        WebElement list16isDone = driver.findElement(By.xpath("//div[@class='song-list-wrap main-scroll-wrap playlist']//td[@class='title'][normalize-space()='Ketsa - That_s a Beat']"));
        return list16isDone.getText();
    }
    private void clicklistTitle() {
        WebElement listTitle = driver.findElement(By.xpath("//a[normalize-space()='16 is Done']"));
        listTitle.click();
    }

    private void clickplayList() {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//li[@class='playlist'][normalize-space()='16 is Done']"));
        playlist.click();
    }


    private void clickaddSong() {
        WebElement addSong = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//button[@title='Add selected songs to…'][contains(text(),'Add To…')]"));
        addSong.click();
    }

    private void clicksongList() {
        WebElement songList = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//div[@class='virtual-scroller scroller']//tr[1]"));
        songList.click();
    }

    private void clickViewall(){
        WebElement Viewall = driver.findElement(By.xpath("//*[@id=\"homeWrapper\"]/div/div[1]/section[2]/h1/button"));
        Viewall.click();
    }
       private String songTitletext() {
        WebElement songTitletext = driver.findElement(By.xpath("//div[@class='song-list-wrap main-scroll-wrap playlist']//td[@class='title'][normalize-space()='Ketsa - That_s a Beat']"));
        return songTitletext.getText();
       }
}


