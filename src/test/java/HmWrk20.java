import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HmWrk20 extends BaseTest{
    // Re-Coded HmWrk19 using waits
    @Test
    public void deletePlaylist() throws InterruptedException {
        logIn();
        selectPlaylist();
        pressDeletePlaylist();
        Assert.assertEquals(getConfirmationPopUpText(),"Deleted playlist \"Hmwrk19.\"","enter message");
    }
    private void pressDeletePlaylist() throws InterruptedException {
        WebElement delPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete this playlist']")));
        delPlaylist.click();
    }
    private void selectPlaylist() throws InterruptedException {
        WebElement myPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Hmwrk19')]")));
        myPlaylist.click();
    }
    public String getConfirmationPopUpText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']"))).getText();
    }
}

