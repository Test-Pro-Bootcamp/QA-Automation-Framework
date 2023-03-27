import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {
/*    Create a new file Homework16.java file with @Test annotation in IntelliJ IDEA
    Create a test case createNewPlaylist() using @Test annotation
    Navigate to "https://bbb.testpro.io/"
    Log in with your credentials
    Create a new playlist (use XPath locators to locate the elements)
    Validate that there is a new playlist made
    Create a new branch and commit your changes
    Push your code to a remote repository
    Create a pull request
    Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework*/
    @Test
    public void main () throws InterruptedException {

        provideEmail("dirzo@gmail.com");
        providePassword("Te$ter1234");

        clickSubmitBtn();

        WebElement plusPlaylist = driver.findElement(By.xpath("//*[@data-testid=\"sidebar-create-playlist-btn\"]"));
        Thread.sleep(1000);
        plusPlaylist.click();
        WebElement newPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]"));
        newPlaylist.click();
        WebElement createPlaylist = driver.findElement(By.xpath("//*[@id='playlists']/form/input"));
        createPlaylist.sendKeys("16 is Done");
        createPlaylist.sendKeys(Keys.RETURN);

        WebElement listPage = driver.findElement(By.xpath("//h1[normalize-space()='16 is Done']"));
        Assert.assertTrue(listPage.isDisplayed());

/*        Thread.sleep(1000);*/
       /* if (listPage.isDisplayed()){
            WebElement namedList = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/header"));
            Assert.assertTrue(namedList.isDisplayed());


        }*/

        Thread.sleep(1000);
        driver.quit();



    }
}
