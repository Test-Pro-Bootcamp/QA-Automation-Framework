import PagesIvaF.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PlaySongIvanF extends BaseTestIvan{
    @Test
   public void playSongContextMenu()  {
        LoginPageIvan loginPageIvan= new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = new HomePageIvan(getDriver());
        loginPageIvan.login().clickOnAllSongs().contextClickFirstSong().playFromContextMenu();
        Assert.assertTrue(homePageIvan.isSongPlaying());
   }
    @Test
    void hoverOverPlayButton(){
        LoginPageIvan loginPageIvan= new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = new HomePageIvan(getDriver());
        loginPageIvan.login().clickOnAllSongs().hoverPlay().click();
    }
    @Test
    public void listOfSongWebElements(){
        LoginPageIvan loginPageIvan= new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = new HomePageIvan(getDriver());
        IvanFavorPage ivanFavorPage = new IvanFavorPage(getDriver());
        loginPageIvan.login().choosePlayListByName("super");
        ivanFavorPage.getListOfTheSongs();
        System.out.println("LIST OF SONGS====="+ivanFavorPage.getListOfTheSongs().size());
        Assert.assertEquals(ivanFavorPage.getListOfTheSongs().size(),3);
    }
    @Test
    public void changeNameOfPlyList() {

        emailLogin();
        doubleClickPlayList();
        enterPlayListName();
        Assert.assertTrue(doesPlayListExist());
    }

    private boolean doesPlayListExist() {
        WebElement playListElement = getDriver().findElement(By.xpath("//a[text()='Super3333']"));
        return playListElement.isDisplayed();
    }

    private void enterPlayListName(){
        By playListInputfield = By.cssSelector("input[name='name']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(playListInputfield));
        WebElement playListInput = getDriver().findElement(By.cssSelector("input[name='name']"));
        playListInput.sendKeys((Keys.chord(Keys.COMMAND,"a", Keys.BACK_SPACE)));
        playListInput.sendKeys("Super3333");
        playListInput.sendKeys(Keys.ENTER);

    }

    private void doubleClickPlayList() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists li:nth-child(3)")));
        WebElement element = getDriver().findElement(By.cssSelector("#playlists li:nth-child(3)"));
        actions.doubleClick(element).perform();

    }

}
