import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW19 extends BaseTest{

    @Test
    public void deletePlaylist()throws InterruptedException {
        provideEmail("yuliyakis85@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        clickOnThursdayPlaylist();
        clickDeleteBtn();


        WebElement deletedPlaylistMsg = getDeletedPlaylistMsg();
        Assert.assertTrue(deletedPlaylistMsg.isDisplayed());

    }

    private WebElement getDeletedPlaylistMsg() {
        return driver.findElement(By.cssSelector("div.success.show"));
    }

    private void clickDeleteBtn() throws InterruptedException {
        WebElement deletePlaylist = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        deletePlaylist.click();
        Thread.sleep(2000);
    }

    private void clickOnThursdayPlaylist() throws InterruptedException {
        WebElement mondayPlaylist = driver.findElement(By.xpath("//a[text()='Thursday']"));
        mondayPlaylist.click();
        Thread.sleep(2000);
    }


}
