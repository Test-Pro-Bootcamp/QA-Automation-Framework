import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HW18 extends BaseTest {

    //    @Test
//    public void PlaySong() throws InterruptedException{
//        emailLogin();
//        Actions actions = new Actions(driver);
//        WebElement allSong = driver.findElement(By.cssSelector("[href='#!/songs']"));
//        allSong.click();
//        Thread.sleep(2000);
//        WebElement locateSong = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[2]/td[2]"));
//        actions.doubleClick(locateSong).perform();
//        WebElement confirmSongPlaying = driver.findElement(By.xpath("//*[@id='progressPane']/h3"));
//        Assert.assertTrue(confirmSongPlaying.isDisplayed());
//
//
//
//    }
    @Test(priority = 1,dataProvider = "invalidCredentials",dataProviderClass = BaseTest.class)
    public void emailInvalidLogin( String email, String password){
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebElement avatarElement = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        Assert.assertTrue(avatarElement.isDisplayed());
    }

}
