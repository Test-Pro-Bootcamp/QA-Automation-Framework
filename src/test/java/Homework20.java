import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{

        @Test
        public void deletePlaylistWait(){
            enterEmail("nozishka86@gmail.com");
            enterPassword("te$t$tudent");
            clickSubmitBtn();

            clickNewPlaylistBtn();
            clickDropDown();
            enterPlayListName();

            goToMyPlaylist();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete this playlist']"))).click();

            WebElement successPopUp = driver.findElement(By.xpath("//div[contains(text(),'Deleted')]"));
            Assert.assertTrue(successPopUp.isDisplayed());
        }
    }

