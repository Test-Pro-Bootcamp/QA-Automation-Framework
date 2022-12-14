package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeletePlaylistTest extends BaseTest{
    @Test
    public void DeletePlaysttest() throws InterruptedException{
        WebElement Playlist = driver.findElement(By.xpath
                ("//li[@class='playlist playlist']"));
        Playlist.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement delbtn = driver.findElement
                (By.xpath("//button[@class='del btn-delete-playlist']"));
        delbtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement ConfirmBtn = driver.findElement
                (By.xpath("//button[@class='ok']"));
        ConfirmBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement Popup = driver.findElement(By.xpath
                (" //div[@class='success show']"));
        Assert.assertTrue(Popup.isDisplayed());

    }
}

