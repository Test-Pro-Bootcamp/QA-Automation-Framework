import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test(enabled = true)
    public void deletePlayList() throws InterruptedException{
        //Login to webapp
       // navigateToPage();
        provideEmail("khushbu07@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        selectPlaylist();
        String deletedPlaylist = getSelectedPlaylist();
        deletePlaylist();
        Assert.assertEquals(getConfirmationPopup(),"Deleted playlist \"" + deletedPlaylist + ".\"");
    }
    private void selectPlaylist() throws InterruptedException{
        //wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement selectPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//ul//li[@class='playlist playlist'][1]")));
        selectPlaylist.click();
    }
    private String getSelectedPlaylist() throws InterruptedException{
        //wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement getSelectedPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//ul//li[@class='playlist playlist']")));
        String txt = getSelectedPlaylist.getText();
        return txt;
    }
    private void deletePlaylist() throws InterruptedException{
      //  wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='del btn-delete-playlist']")));
        deletePlaylistBtn.click();
    }

    private String getConfirmationPopup(){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']"))).getText();
       // return driver.findElement(By.xpath("//div[@class='success show']")).getText();
    }
}
