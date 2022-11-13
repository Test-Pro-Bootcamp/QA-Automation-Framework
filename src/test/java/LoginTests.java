import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

public class LoginTests extends BaseTest {


    @Test
    public  void LoginEmptyEmailPasswordTest() throws InterruptedException {
        LoginPage LoginPage = new LoginPage (getDriver());
        LoginPage.login();




//        LoginPage.provideEmail("myworld123@gmail.com");
//        LoginPage.providePassword("te$t$tudent");
//        LoginPage.clickSubmitBtn();
////        provideLogIn();
//        By avatarIconLocator = (By.cssSelector("[alt='Avatar of student']"));
//        Wait.until(ExpectedConditions.elementToBeClickable(avatarIconLocator));
//        WebElement avatarIcon = driver.findElement(avatarIconLocator);
//        Assert.assertTrue(avatarIcon.isDisplayed());
//        selectPlaylist();
//        deletePlaylist();
//        getConfirmationPopupText();
//        Assert.assertEquals(getConfirmationPopupText(), "Deleted playlist");
    }

//    public void provideLogIn() {
//        provideEmail("myworld123@gmail.com");
//        providePassword("te$t$tudent");
//        clickSubmitBtn();
//    }

//    private String getConfirmationPopupText() {

//        return driver.findElement(By.cssSelector("div.success.show")).getText();
//
//    }
//
//
//    private void deletePlaylist() {
//
//        Wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li:nth-child(4) > nav > ul > li:nth-child(2)")));
//        WebElement deleteBtn = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(4) > nav > ul > li:nth-child(2)"));
//        deleteBtn.click();
//
//}
//    private void selectPlaylist() {
//        WebElement bestestSongs = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(4) > a"));
//        bestestSongs.click();
//        actions.contextClick(bestestSongs).perform();
//
//    }
}









    //    Create a new file Homework19.java file with @Test annotation in IntelliJ IDEA
//    Create a test case deletePlaylist() using @Test annotations
//    Use the helper/reusable methods we created
//    Use @Parameters for passing baseUrl from the TestNG config file to the tests
//    Navigate to "https://bbb.testpro.io/"
//    Log in with your credentials
//    @Test(enabled = false)
//    public void deletePlaylist() throws InterruptedException {
//        provideEmail("myworld123@gmail.com");
//        providePassword();
//        clickSubmitBtn();
//        By avatarIconLocator = (By.cssSelector("[alt='Avatar of student']"));
//        By playlistLocator =
//        By superHitSongsLocator = By.xpath("//*[@id=\"playlists\"]");
//        By deletePlaylistLocator = By.cssSelector("[@title=\"Delete this playlist\"]");
//        Wait.until(ExpectedConditions.elementToBeClickable(avatarIconLocator));
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//        WebElement playlist= driver.findElement(playlistLocator);
//        Wait.until(ExpectedConditions.visibilityOfElementLocated(playlistLocator));
//        Assert.assertTrue(avatarIcon.isDisplayed());

//        WebElement superHitSongs = driver.findElement(By.xpath("//a[text()='super hit songs']"));
//        WebElement playLists = driver.findElement(playlistsLocator);
//        Wait.until(ExpectedConditions.elementToBeClickable(playlistsLocator));
//        Wait.until(ExpectedConditions.textToBePresentInElement(playLists,"" + "PLAYLISTS"));
//        WebElement superHitSongs = driver.findElement(superHitSongsLocator);
//        superHitSongs.click();
//        Wait.until(ExpectedConditions.elementToBeClickable(superHitSongsLocator));
//        Wait.until(ExpectedConditions.textToBePresentInElement(superHitSongs,"" + "super hit songs"));

//        Wait.until(ExpectedConditions.elementToBeClickable(superHitSongsLocator));





//    Choose a playlist
//    Delete the playlist
//    Validate that the playlist is deleted


//    @Test (enabled =false)
//    public void deleteThePlaylist() throws InterruptedException {
//        LogIn
//        provideEmail("myworld123@gmail.com");
//        providePassword();
//        clickSubmitBtn();
//        By avatarIconLocator = (By.cssSelector("[alt='Avatar of student']"));
//        Wait.until(ExpectedConditions.elementToBeClickable(avatarIconLocator));
//        WebElement avatarIcon = driver.findElement(avatarIconLocator);
//        Assert.assertTrue(avatarIcon.isDisplayed());
//        selectPlaylist();
//        deleteTheSelectedPlaylist();
//        getConfirmationPopupText();
//        rightClickOnThePLaylist();

//        selectEdit();
//        renameThePlaylist();
//        pressEnter();
//        Assert.assertTrue(newplaylistisdisplayed);



//    private void deleteTheSelectedPlaylist() {
//        WebElement playlistDelBtn = driver.findElement(By.xpath("//button[@class=\"del btn-delete-playlist\" and @title=\"Delete this playlist\"]"));
//        Wait.until(ExpectedConditions.elementToBeClickable(playlistDelBtn));
//    playlistDelBtn.click();
//    }

//    private String getConfirmationPopupText() {
//        WebElement windowConfirmation = driver.findElement(By.cssSelector("div.success.show"));
//        Wait.until(ExpectedConditions.visibilityOf(windowConfirmation));
//        return windowConfirmation.getText();

//


//        By playlistsLocator = By.xpath("//*[@id=\"playlists\"]/h1");

//        WebElement playLists = driver.findElement(playlistsLocator);
//        Wait.until(ExpectedConditions.elementToBeClickable(playlistsLocator));
//       Wait.until(ExpectedConditions.textToBePresentInElement(playLists,"" + "PLAYLISTS"));
//        WebElement goodSongs = driver.findElement(goodSongsLocator);
////        Wait.until(ExpectedConditions.textToBePresentInElement(goodSongs,"good"));
//        Assert.assertTrue(goodSongs.isDisplayed());