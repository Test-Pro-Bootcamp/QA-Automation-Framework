import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test

public class Homework19SZ extends BaseTest{

//    Create a new file Homework19.java file with @Test annotation in IntelliJ IDEA
//    Create a test case deletePlaylist() using @Test annotations
//    Use the helper/reusable methods we created
//    Use @Parameters for passing baseUrl from the TestNG config file to the tests
//    Navigate to "https://bbb.testpro.io/"
//    Log in with your credentials
//    Choose a playlist
//    Delete the playlist
//    Validate that the playlist is deleted
//    Create a new branch and commit your changes
//    Push your code to a remote repository
//    Create a pull request
//    Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework

    @Test
    public void deletePlaylist() throws InterruptedException {
        login();

       selectingPlaylist();
        
        removePlaylist();

        Assert.assertEquals(getConfirmationPopupText(), "Deleted playlist");



    }

    private void selectingPlaylist() throws InterruptedException {
        WebElement myPlaylist = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]"));
        myPlaylist.click();
        Thread.sleep(5000);
    }

    private void removePlaylist() throws InterruptedException{
        WebElement removePlaylistButton = driver.findElement(By.xpath("//*[@id='playlistWrapper']/header/div[3]/span/button"));
        removePlaylistButton.click();
        Thread.sleep(4000);
    }
    private String getConfirmationPopupText() {
        return driver.findElement(By.cssSelector("div.success.show")).getText();
    }


}
