import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {
        enterEmail("nozishka86@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmitBtn();

        clickNewPlaylistBtn();
        clickDropDown();
        enterPlayListName();

        goToMyPlaylist();

        WebElement deletePB = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
        deletePB.click();
        Thread.sleep(2000);

        WebElement successPopUp = driver.findElement(By.xpath("//div[contains(text(),'Deleted')]"));
        Assert.assertTrue(successPopUp.isDisplayed());
    }
}
