import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class  AddSongsToPlaylistTests extends BaseTest{


    String email="holostenco.yuliya@gmail.com";
    String searchPhrase="Waiting on a train";



 @Test
    public void addASongToPlaylist() throws InterruptedException {

     login();
     search();
     addSong();

     WebElement myPlaylist=driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
     Thread.sleep(2000);
     myPlaylist.click();

     WebElement newSongInMyPlaylist=driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/div/div/div[1]/table/tr/td[2]"));
     Assert.assertTrue(newSongInMyPlaylist.isDisplayed());


 }

    public void addSong() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement songLocator = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[1]/ul/article[1]"));
        actions.contextClick(songLocator).perform();

        WebElement addSongBtn =driver.findElement(By.xpath("//*[@id=\"app\"]/nav/ul/li[4]"));
        actions.moveToElement(addSongBtn);

        WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/nav/ul/li[4]/ul/li[7]"));
        actions.moveToElement(subMenu);
        Thread.sleep(4000);
        actions.click().build().perform();
    }


    public void login() throws InterruptedException {
        WebElement emailField= driver.findElement(By.xpath("//input[@type='email']"));
        emailField.click();
        emailField.sendKeys(email);

        WebElement passwordField= driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitBtn= driver.findElement(By.xpath("//button[@type='submit']"));
        submitBtn.click();

        Thread.sleep(3000);
    }



    private void search() throws InterruptedException {
     WebElement searchField= driver.findElement(By.cssSelector("input[type=search]"));
     Thread.sleep(3000);
     String searchPhrase= "Waiting on a train";
     searchField.sendKeys(searchPhrase);
     Thread.sleep(2000);
    }


}
