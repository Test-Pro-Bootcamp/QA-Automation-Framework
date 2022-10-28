import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;

import javax.swing.*;


public class Homework19 extends BaseTest {

    @Test
    public void DeletePlaylist() throws InterruptedException {
        login("dankoyanka@gmail.com", "te$t$tudent");

        WebElement Playlist = driver.findElement(By.xpath
                ("//li[@class='playlist playlist']"));
        Playlist.click();
        Thread.sleep(2000);

        WebElement delbtn = driver.findElement
                (By.xpath("//button[@class='del btn-delete-playlist']"));
        delbtn.click();
        Thread.sleep(2000);

        WebElement ConfirmBtn = driver.findElement
                (By.xpath("//button[@class='ok']"));
        ConfirmBtn.click();
        Thread.sleep(2000);

        WebElement Popup = driver.findElement(By.xpath
                (" //div[@class='success show']"));
        Assert.assertTrue(Popup.isDisplayed());

    }
}


//button[@class='ok']
    //a[@href='#!/playlist/12131']
    //li[@class='playlist playlist']
    //button[@class='del btn-delete-playlist']
    //div[@class='success show']
