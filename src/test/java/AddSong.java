import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


import javax.swing.*;

import static sun.security.jgss.GSSUtil.login;

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
        login();
        // choose a song to add in playlist
        String songTitle = "Lobo Loco";
        selectSong(songTitle);
        // add the song in play list
        addSong();
        // verify is song is added in Play list
        Assert.assertTrue(isSongAdded(songTitle), "Is selected song");

        Thread.sleep(1000);
    }


    public void login() throws InterruptedException {
        provideEmail("demo@class.com");
        providePassword();
        clickSubmitBtn();
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