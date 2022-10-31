import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW19 extends BaseTest {
    @Test
    public void deletingPlayList() throws Exception {
        emailLogin();
        newPlaylist();
        Thread.sleep(2000);
        deletePlaylist();
        Thread.sleep(2000);
        WebElement deletePlayListMessage = getDeletePlayListMsg();
        Assert.assertTrue(deletePlayListMessage.isDisplayed());
    }

    private WebElement getDeletePlayListMsg() {
        return driver.findElement(By.cssSelector("div.success.show"));
    }

    private void deletePlaylist() {
        WebElement deletePls = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        deletePls.click();
    }

}
