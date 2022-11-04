import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork20IvanF extends BaseTestIvan{
    @Test
    public void deletingPlayList() throws Exception {
        emailLogin();
        newPlaylist();
        deletePlaylist();
        WebElement deletePlayListMessage = getDeletePlayListMsg();
        Assert.assertTrue(deletePlayListMessage.isDisplayed());
    }

    private WebElement getDeletePlayListMsg() {
        return driver.findElement(By.cssSelector("div.success.show"));
    }

    private void deletePlaylist() throws Exception {
        WebElement deletePls = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='del btn-delete-playlist']")));
        deletePls.click();
        deletingPlayList();
    }

}
