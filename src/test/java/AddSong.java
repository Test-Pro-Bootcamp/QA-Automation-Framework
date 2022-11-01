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

    public void AddSongToPlaylistTest() throws InterruptedException {
        //log in
        provideEmail("demo@class.com");
        providePassword();
        clickSubmitBtn();
        //add a song to playlist
        addingNewSong();
    }

    private void addingNewSong() {
        clickViewAllCBtn();
        String getSongTitle = getSongTitleTxt();
        clickSongList();
        clickAddToPlayList();
        addToSuperPlaylist();
        clickOnSuperPlaylist();
        getSongTitleFromSuperPlaylist();
        String songFromSuperPlaylist  = getSongTitleFromSuperPlaylist();
        Assert.assertEquals(songFromSuperPlaylist.getSongTitle );
    }

    private String getSongTitleFromSuperPlaylist(){
        WebElement superPlaylistSong = driver.findElement(By.xpath("//section [@id='playlistWrapper'] //td[@class='title']" ));
         return superPlaylistSong.getText() ;
    }

    private void clickOnSuperPlaylist() {
        WebElement superPlaylistLink =driver.findElement(By.xpath("//section [@id='playlistWrapper'] //td[@class='title']"));
    }

    private void addToSuperPlaylist() {
        WebElement superPlaylist = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//li[contains(text(),'super')]"));
        superPlaylist.click();
    }

    private String getSongTitleFromSuperPlaylist() {
        WebElement getTitleTxt  =driver.findElement(By.xpath("//section[@ id='recentlyPlayedWrapper']//tr[@class= 'song-item']//td[@class='title']"));
        return getTitleTxt.getText();
    }

    private void clickAddToPlayList() {
        WebElement viewAllButton = driver.findElement(By.xpath("//button[@data-testid='home-view-all-recently-played-btn']" ));
        viewAllButton.click();

    }

    private void clickSongList() {
        WebElement songList = driver.findElement(By.xpath("//section[@ id='recentlyPlayedWrapper']//tr[@class= 'song-item']"));
        songList.click();
    }

    private void clickViewAllCBtn() {
        WebElement addToPlaylist = driver.findElement(By.xpath("//button[contains(@title. 'Add selected songs ')]"));
        addToPlaylist.click();
    }

    public void selectSong(String songTitle) throws InterruptedException {
        driver.findElement(By.xpath("//div[@id=mainWrapper']/nav/section/ul/li/@[class='songs']"));
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[class='songs active']")).click();

        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(By.xpath("//table[@class=items']/tr[@class='song-item'/td(contains(.,'" + songTitle + "')]"))).perform();
        Thread.sleep(1000);
    }

    public void addSong() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("li[class='has-sub']"))).perform();
        Thread.sleep(1000);

        action.moveToElement(driver.findElement(By.xpath("//ul[@class ='menu submenu menu-add-to']/li[@class='playlist']"))).perform();
        action.click(driver.findElement(By.xpath("//ul[@class='menu sub menu menu-add-to']/li[@class='playlist']"))).perform();
        Thread.sleep(2000);
    }

    public boolean isSongAdded(String songTitle) throws InterruptedException {
        boolean isSongAdded = true;
        driver.findElement(By.xpath("//ul/li[@class='playlist playlist']")).click();

        try {

            driver.findElement(
                    By.xpath("//section[@id='playlistWrapper']/div[@class='song-list-wrap main-scroll-wrap playlist']/div[@class='virtual-scroller scroller']" +
                            "/div[@class='item-container']/table/tr/td[contains(.''" + songTitle + "')]")).click();
        } catch (NoSuchContextException e) {
            isSongAdded = false;
        }
        return isSongAdded;
    }
}