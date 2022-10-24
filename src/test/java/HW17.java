import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW17 {

    @Test
    public static void HomeWork15 () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            driver.get(url);
            WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
            emailField.click();
            emailField.sendKeys("fedorov.ivan@hotmail.com");
            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            passwordField.click();
            passwordField.sendKeys("te$t$tudent");
            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            submitButton.click();
            WebElement avatarElement = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
            Assert.assertTrue(avatarElement.isDisplayed());
            WebElement allSongsBut = driver.findElement(By.cssSelector("[href='#!/songs']"));
            submitButton.click();
            WebElement pickSong = driver.findElement(By.xpath("//*[contains(text(),'Ketsa')]"));
            submitButton.click();
            WebElement addSongBt = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/header/div[3]/span/button[2]"));
            submitButton.click();
            WebElement addToPlayList = driver.findElement(By.xpath("//*[@class='playlist']"));
            submitButton.click();
            WebElement goToPl = driver.findElement(By.xpath("//*[@href='#!/playlist/24842']"));
            submitButton.click();
            WebElement controlSongCheck = driver.findElement(By.xpath("//div/div/table/tr[@class='song-item']/td[2][@class='title' and text()='Ketsa - That_s a Beat']"));
            Assert.assertTrue(controlSongCheck.isDisplayed());





            /*WebElement newPlayList = driver.findElement(By.cssSelector("[class='fa fa-plus-circle create']"));
            newPlayList.click();
            Thread.sleep(3000);
            WebElement createPlayList = driver.findElement(By.xpath("//*[text()='New Playlist']"));
            createPlayList.click();
            Thread.sleep(3000);
            WebElement inputPlayList = driver.findElement(By.cssSelector("[placeholder='↵ to save']"));
            inputPlayList.click();
            inputPlayList.sendKeys("super");
            inputPlayList.sendKeys(Keys.RETURN);*/
           /* WebElement createdPlayList = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
            Assert.assertTrue(createdPlayList.isDisplayed());
            Thread.sleep(3000);*/

//
//            WebElement searchResult = driver.findElement(By.cssSelector("ul>article"));
//            Assert.assertTrue(searchResult.getText().contains("Pluto"));
//            String a = searchResult.getText();
//            if (a.contains("Pluto")){
//                Boolean testResult = true;
//                Assert.assertTrue(testResult);
//                System.out.println("TEST SUCCESSFUL");
//            }
        } finally {
            driver.quit();

        }

    }


}
