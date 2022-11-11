import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddSongHmw17 extends BaseTest {
    By clickViewAllBtn = By.xpath("//button[@data-testid='home-view-all-recently-played-btn']");
    By clickSongFromList = By.xpath("//section[@id='recentlyPlayedWrapper']//tr[@class='song-item']");
    By clickAddToBtn = By.xpath("//button[@data-test='add-to-btn']");
    By addToSuperPlaylist = By.xpath("//section[@id='recentlyPlayedWrapper']//li[contains(text(),'super')]");
    By clickOnSuperPlaylistLink = By.xpath( "//a[contains(text(),'super')]");

    @Test
    public void addSongToPlaylist() throws InterruptedException {
    provideEmail("demo@class.com");
    providePassword("te$t$tudent");
    clickSubmitBtn();
    clickViewAllBtn();
    String getSongTitle = getSongTitleTxt();
    Thread.sleep(3000);
    clickSongFromList();
    clickAddToBtn();
    addToSuperPlaylist();
    clickOnSuperPlaylistLink();
    String getSongTitleAddedToSuperPlaylist = getSongAddedToSuperPlaylist();
    Assert.assertEquals(getSongTitleAddedToSuperPlaylist, getSongTitle);
    }
    private String getSongAddedToSuperPlaylist() {
        WebElement songAdded = driver.findElement(By.xpath("//section[@id='playlistWrapper']//tr[@class='song-item']//td[@class='title']"));
        return songAdded.getText();
    }
    private void clickOnSuperPlaylistLink() {
        driver.findElement(clickOnSuperPlaylistLink).click();
    }
    private String getSongTitleTxt() {
        WebElement getTitleTxt = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//tr[@class='song-item']//td[@class='title']"));
        return getTitleTxt.getText();
    }
    private void addToSuperPlaylist() {
        driver.findElement(addToSuperPlaylist).click();
    }
    private void clickAddToBtn() {
        driver.findElement(clickAddToBtn).click();
    }
    private void clickSongFromList() {
        driver.findElement(clickSongFromList).click();
    }
    private void clickViewAllBtn() {
        driver.findElement(clickViewAllBtn).click();
    }
}
