import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HmWrk19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        // Create a test case deletedPlaylist() using@ TEst annotations
        // Use the reusable methods
        // Use a @Parameter for passing baseUrl
        //Given: navigate to "https://bbb.testpro.io/"
        //Step 1: Log in with your credentials
        logIn();
        // Step 2: Choose a playlist
       selectPlaylist();
        // Step 3: Delete the playlist
       pressDeletePlaylist();
        // Step 4: Validate that the playlist is deleted
       Assert.assertEquals(getConfirmationPopUpText(),"Deleted playlist \"Hmwrk19.\"");
    }
    private void pressDeletePlaylist() throws InterruptedException {
        WebElement delPlaylist = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
        delPlaylist.click();
        Thread.sleep(5000);
    }
    private void selectPlaylist() throws InterruptedException {
        WebElement myPlaylist = driver.findElement(By.xpath("//a[contains(text(),'Hmwrk19')]"));
        myPlaylist.click();
        Thread.sleep(5000);
    }
    public String getConfirmationPopUpText(){
        return driver.findElement(By.xpath("//div[@class='success show']")).getText();
    }
}
