import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist(){
        logIn("nozishka86@gmail.com","te$t$tudent");
        createPlaylist();
        goToMyPlaylist();

        WebElement deletePB = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
        deletePB.click();

        WebElement successPopUp = driver.findElement(By.xpath("//div[contains(text(),'Deleted')]"));
        Assert.assertTrue(successPopUp.isDisplayed());
    }
}
