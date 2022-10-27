import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


//        Create a new file Homework17.java file with @Test annotation in IntelliJ IDEA
//        Create a test case addSongToPlaylist() using @Test annotations
//        and the helper/reusable methods we created
//        Navigate to "https://bbb.testpro.io/"
//        Log in with your credentials
//        Add a song to a playlist
//        Validate that there is a song added
//        Create a new branch and commit your changes
//        Push your code to a remote repository
//        Create a pull request
//        Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework
public class AddSong extends BaseTest{
    @Test
    public void AddSongToPlaylistTest()throws InterruptedException{

        provideEmail("demo@class.com");
        providePassword();
        clickSubmitBtn();

        WebElement allSongsBank= driver.findElement(By.xpath("//a[@class='songs active']"));
        allSongsBank.click();

        WebElement pickTitleSong = driver.findElement(By.xpath("//tr[@class='song-item selected']//td[@class='title']"));
        pickTitleSong.click();

        WebElement addButton =driver.findElement(By.xpath("//button[@class='btn-add-to']"));
        addButton.click();

        WebElement

       Thread.sleep(5000);
    }
}
