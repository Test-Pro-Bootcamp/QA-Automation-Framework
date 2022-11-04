import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork21IvanF extends BaseTestIvan{
    @Test
    public void changeNameOfPlyList() {

        emailLogin();
        doubleClickPlayList();
        enterPlayListName();
        Assert.assertTrue(doesPlayListExist());
    }

    private boolean doesPlayListExist() {
        WebElement playListElement = driver.findElement(By.xpath("//a[text()='Super3333']"));
        return playListElement.isDisplayed();
    }

    private void enterPlayListName(){
        By playListInputfield = By.cssSelector("input[name='name']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(playListInputfield));
        WebElement playListInput = driver.findElement(By.cssSelector("input[name='name']"));
        playListInput.sendKeys((Keys.chord(Keys.COMMAND,"a", Keys.BACK_SPACE)));
        playListInput.sendKeys("Super3333");
        playListInput.sendKeys(Keys.ENTER);

    }

    private void doubleClickPlayList() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists li:nth-child(3)")));
        WebElement element = driver.findElement(By.cssSelector("#playlists li:nth-child(3)"));
        actions.doubleClick(element).perform();

    }


}
