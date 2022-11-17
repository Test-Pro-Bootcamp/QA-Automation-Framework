import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Salma_Homework19 extends Salma_BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException{
        //Login
        provideEmail("salma.ayad.87@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        clickOnPlaylist();
        clickOnDeletePlaylist();
        Thread.sleep(2000);
        WebElement sidebarSelector = driver.findElement(By.xpath("//nav[@id='sidebar']"));
        Assert.assertFalse(sidebarSelector.getText().contains("Salma"));
    }



    private void clickOnDeletePlaylist() {
        WebElement deletePlaylist = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
        deletePlaylist.click();
    }

    private void clickOnPlaylist() {
        WebElement playlistSelector = driver.findElement(By.xpath("//a[text()='Salma']"));
        playlistSelector.click();
    }
}