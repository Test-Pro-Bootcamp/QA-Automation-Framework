import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test(dataProvider = "loginData",dataProviderClass = BaseTest.class)
    public void removeSong(String email, String password) throws InterruptedException {
        launchBrowser(url);
        provideEmail(email);
        providePassword(password);
        clickSubmitBtn();
        clickOnPlaylist();
        deletePlaylist();
    }
    public void clickOnPlaylist () throws InterruptedException {
        WebElement openPlaylist = driver.findElement(By.xpath("//a[text() ='Nargiza']"));
        openPlaylist.click();
        Thread.sleep(2000);
    }
    private void deletePlaylist() throws InterruptedException{
        WebElement delPlaylist = driver.findElement(By.xpath("//button[@title = 'Delete this playlist']"));
        delPlaylist.click();
        Thread.sleep(2000);
    }
}
