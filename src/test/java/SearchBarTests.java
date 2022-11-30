import POM.AllSongsPage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchBarTests extends  BaseTest {
    private String songName = "Waiting On A Train";
    private String songNameWithLeadingSpaces = "         Waiting On A Train";
    private String songNameWithTrailingSpaces = "Waiting On A Train       ";
    private String songNameStartingWithALowercase = "waiting on a train";
    private String songNameOutOfDataBase="Happy Birthday";
    private String noResultsText="None found.";

    private String searchPhrase = "HoliznaCC0 - Waiting On A Train\n" +
            "Unknown Artist";
    private By searchfieldLocator= By.xpath("//input[@type='search']");

    @Test
    public void searchForAnExistingSong() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.search(songName);
        allSongsPage.songsResultsSectionIsDisplayed();
        allSongsPage.validateSongsResultsSection();
        allSongsPage.artistsResultsSectionIsDisplayed();
        allSongsPage.validateArtistsResultsSection();
        allSongsPage.albumsResultsSectionIsDisplayed();
        allSongsPage.validateAlbumsResultsSection();
        allSongsPage.searchedSongIsDisplayed();
        allSongsPage.validateSearchedSong();
        allSongsPage.getTextFirstSongFromSearchResults();
        Assert.assertEquals(allSongsPage.getTextFirstSongFromSearchResults(), searchPhrase);
    }

    @Test
    public void searchForASongWithLeadingSpaces() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.search(songNameWithLeadingSpaces);
        allSongsPage.searchedSongIsDisplayed();
        allSongsPage.validateSearchedSong();
        allSongsPage.getTextFirstSongFromSearchResults();
        Assert.assertEquals(allSongsPage.getTextFirstSongFromSearchResults(), searchPhrase);
    }

    @Test
    public void searchForASongWithTrailingSpaces() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.search(songNameWithTrailingSpaces);
        allSongsPage.searchedSongIsDisplayed();
        allSongsPage.validateSearchedSong();
        allSongsPage.getTextFirstSongFromSearchResults();
        Assert.assertEquals(allSongsPage.getTextFirstSongFromSearchResults(), searchPhrase);
    }

    @Test
            public void searchForASongStartingWithALowerCase() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.search(songNameStartingWithALowercase);
        allSongsPage.getTextForSongsResultsSection();
        Assert.assertEquals(allSongsPage.getTextForSongsResultsSection(),noResultsText);
    }
    @Test
    public void searchForASongOutOfDataBase() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.search(songNameOutOfDataBase);
        allSongsPage.getTextForSongsResultsSection();
        Assert.assertEquals(allSongsPage.getTextForSongsResultsSection(),noResultsText);
}

@Test
    public void clearSearchBarWithKeyboard(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login();
    AllSongsPage allSongsPage = new AllSongsPage(driver);
    allSongsPage.search(songName);
    driver.findElement(searchfieldLocator).sendKeys((Keys.chord(Keys.CONTROL + "a", Keys.BACK_SPACE)));
    allSongsPage.getTextForSongsResultsSection();
    Assert.assertEquals(allSongsPage.getTextForSongsResultsSection(),noResultsText);

}
}
