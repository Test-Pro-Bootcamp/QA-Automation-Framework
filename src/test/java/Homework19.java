import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    @Parameters({"baseURL"})
    public void deletePlaylist(@Optional String baseURL) throws InterruptedException {
        // Create a test case deletePlaylist() using @Test annotations
        // Use the reusable methods
        // Use @Parameters for passing baseUrl
        // Given: Navigate to "https://bbb.testpro.io/"
        // Step1: Log in with your credentials
        if(baseURL != null) {
            this.url = baseURL;
        }
        login();
        // Step2: Choose a playlist
        selectPlaylist();
        // Step3: Delete the playlist
        pressDeletePlaylist();
        // Step4: Validate that the playlist is deleted "Deleted playlist"
        Assert.assertTrue(getConfirmationPopupText().contains("Deleted playlist"));
    }

    private void selectPlaylist() throws InterruptedException {
        WebElement myPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        myPlaylist.click();
        Thread.sleep(1000);
    }

    private void pressDeletePlaylist() throws InterruptedException {

        WebElement delPlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        delPlaylist.click();
        Thread.sleep(1000);

        try {
            // This is applicable when there is at least one song in the playlist
            WebElement confirmOkElement = driver.findElement(By.xpath("//button[contains(@class,'ok')]"));
            confirmOkElement.click();
        } catch (NoSuchElementException e) {
            System.out.println("Confirm dialog was not present!");
        }

        // Thread.sleep(2000);
    }

    private String getConfirmationPopupText() {
        String confirmationPopupText = driver.findElement(By.cssSelector("div.success.show")).getText();
        return confirmationPopupText;
    }


}
