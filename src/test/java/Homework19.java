import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlayList() throws InterruptedException{
        //Login to webapp
        navigateToPage();
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
        WebElement selectPlaylist = driver.findElement(By.xpath("//section[@id='playlists']//ul//li[@class='playlist playlist'][1]"));
        selectPlaylist.click();
        Thread.sleep(4000);
    }
    private String getSelectedPlaylist() throws InterruptedException{
        WebElement getSelectedPlaylist = driver.findElement(By.xpath("//section[@id='playlists']//ul//li[@class='playlist playlist']"));
        String txt = getSelectedPlaylist.getText();
        return txt;
    }
    private void deletePlaylist() throws InterruptedException{
        WebElement deletePlaylistBtn = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        deletePlaylistBtn.click();
        Thread.sleep(4000);
    }

    private String getConfirmationPopup(){
        return driver.findElement(By.xpath("//div[@class='success show']")).getText();
    }
}
