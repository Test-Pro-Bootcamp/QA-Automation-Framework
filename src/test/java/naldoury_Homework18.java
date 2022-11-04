import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;




public class naldoury_Homework18 extends naldoury_BaseTest{

    String email = "demo@class.com";
    String password = "te$t$tudent";
    @Test
    public void playAsong() throws InterruptedException {

        setEmailField(email);
        setPassword(password);
        submit();

        WebElement pressAllSongs = driver.findElement(By.xpath("//*[@class='songs']"));
        pressAllSongs.click();


        WebElement choseSongtitle = driver.findElement(By.xpath("//td[contains(text(),'Ketsa')]" ));
        choseSongtitle.click();

        WebElement playNextSong = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']" ));
        Thread.sleep(2000);
        playNextSong.click();


        WebElement playSong = driver.findElement(By.xpath("//span[@data-testid='play-btn']" ));
        Thread.sleep(2000);
        playSong.click();
      //  playSong.sendKeys("myPlaylist",KEYS.ENTER);

        WebElement confirmPlayingSong = driver.findElement(By.xpath("//*[@alt='Sound bars']" ));
        confirmPlayingSong.click();
        Assert.assertTrue(confirmPlayingSong.isDisplayed());

        
        Thread.sleep(2000);
        driver.quit();
    }
}
