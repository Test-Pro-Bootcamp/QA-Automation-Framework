import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//import java.time.Duration;

public class HWtwentyOneYD extends BaseTest{

    @Test
    @Parameters({"baseURL"})
    public void renamePlaylist()  {

        provideEmail("dankoyanka@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();

        doubleClickChoosePlaylist();
        enterPlaylistName();
        locateNewPlaylistName();
    }
}
