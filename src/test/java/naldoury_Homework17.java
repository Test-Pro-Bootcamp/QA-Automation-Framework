
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class naldoury_Homework17 extends naldoury_BaseTest {


    @Test
    public void addSongToPlaylist () throws  InterruptedException {

        String email = "demo@class.com";
        String password = "te$t$tudent";

        setEmailField(email);
        setPassword(password);
        submit();
        Thread.sleep(3000);
        WebElement chkmyPlaylist = driver.findElement(By.xpath("//a[contains(text(),'myPlaylist')]"
        ));
        Assert.assertTrue(chkmyPlaylist.isDisplayed());

        WebElement pressAllSongs = driver.findElement(By.xpath("//*[@class='songs']"));
        pressAllSongs.click();

        WebElement pressSongtitle = driver.findElement(By.xpath("//*[@class='title']"));
        pressSongtitle.click();


        WebElement choseSongtitle = driver.findElement(By.xpath("//td[contains(text(),'Ketsa')]" ));
        choseSongtitle.click();


        Thread.sleep(2000);
        driver.quit();
    }
}


