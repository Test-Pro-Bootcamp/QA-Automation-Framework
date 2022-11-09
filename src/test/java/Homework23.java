import POM.pages.CurrentQueuePage;
import POM.pages.LoginPage;
import POM.pages.ViewAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Homework23 extends BaseTest {

    @Test
    public void addSongToPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        ViewAllPage viewAllPage = loginPage.login().clickViewAllSongs();

        String getSongTitle = viewAllPage.getFirstSongName();

        CurrentQueuePage currentQueuePage = viewAllPage.clickFirstSongFromList()
                .clickAddToPlaylist()
                .addToTopOfQueue().navigateToCurrentQueue();

        //Verify the song
        List<String> songsFromSuperPlaylist = currentQueuePage.getSongNames();
        Assert.assertTrue(songsFromSuperPlaylist.contains(getSongTitle));
    }

}
