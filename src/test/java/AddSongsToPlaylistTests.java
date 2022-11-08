import POM.AllSongsPage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class  AddSongsToPlaylistTests extends BaseTest {


    String email = "holostenco.yuliya@gmail.com";
    String searchPhrase = "Waiting on a train";


    @Test
    public void addASongToPlaylist() throws InterruptedException {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        AllSongsPage allSongs = new AllSongsPage(driver);
        allSongs.search();
        addSong();

        WebElement myPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        Thread.sleep(2000);
        myPlaylist.click();

        WebElement newSongInMyPlaylist = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/div/div/div[1]/table/tr/td[2]"));
        Assert.assertTrue(newSongInMyPlaylist.isDisplayed());


    }

    public void addSong() throws InterruptedException {

        Actions actions = new Actions(driver);
        WebElement addSongBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/nav/ul/li[4]"));
        actions.moveToElement(addSongBtn);

        WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/nav/ul/li[4]/ul/li[7]"));
        actions.moveToElement(subMenu);
        Thread.sleep(4000);
        actions.click().build().perform();

    }
}