import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import stash.Stashed;

import java.time.Duration;

public class hw16 extends BaseTest{
    @Test
    public static void homework16() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        
            // By emailFieldSelector = By.cssSelector("[type='email']");
            //*[@id="app"]/div/form/input[1]

            String loginEmail = "demo@class.com";
            String loginPass ="te$t$tudent";
            String url ="http://bbb.testpro.io/";

            driver.get(url);

            Selectors selectMe = new Selectors();

            Login(loginEmail,loginPass,driver);
            //search for adding playlist btn//*[@data-testid="sidebar-create-playlist-btn"]

            WebElement searchAddingNewPlayListBtn = driver.findElement(By.xpath("//*[@data-testid='sidebar-create-playlist-btn']"));
            searchAddingNewPlayListBtn.click();
            Thread.sleep(1000);
            //select new playlistb   //*[@data-testid="playlist-context-menu-create-simple"]
            WebElement selectNewPlaylist = driver.findElement(By.xpath("//*[@data-testid='playlist-context-menu-create-simple']"));
            //WebElement selectNewPlaylist = driver.findElement(By.xpath("//*[contains(text(),'New Playlist']"));
            selectNewPlaylist.click();
            Thread.sleep(2000);
            //enter
//            WebElement newNameList = driver.findElement(By.xpath("//*[@name='name']"));
//            newNameList.sendKeys("legolas");
//            Thread.sleep(2000);

        } finally {
            Thread.sleep(2000);
            //Assert.assertEquals(driver.getCurrentUrl(), url);
            driver.quit();
        }

    }
    public static void Login(String loginEmail, String loginPass, WebDriver driver ) {
        Selectors selectMe = new Selectors();
        WebElement emailField = driver.findElement(selectMe.emailFieldSelector);
        emailField.click();
        emailField.sendKeys(loginEmail);

//            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        WebElement passwordField = driver.findElement(selectMe.passFieldSelector);
        passwordField.click();
        passwordField.sendKeys(loginPass);


        WebElement submitButton = driver.findElement(selectMe.submitButtonSelector);
        submitButton.click();

    }

}