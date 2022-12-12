import PagesIvaF.HomePageIvan;
import PagesIvaF.IvanSearchPage;
import PagesIvaF.LoginPageIvan;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IvanFSearchTest extends BaseTestIvan{
    @Test
    public void searchSong(){
        HomePageIvan homePage = new LoginPageIvan(getDriver()).login();
        IvanSearchPage ivanSearchPage = new IvanSearchPage(getDriver());
        homePage.putSearchRequest("Take My Hand");
        Assert.assertTrue(ivanSearchPage.takeHandSongFound());
    }

    @Test
    public void searchArtist(){
        HomePageIvan homePage = new LoginPageIvan(getDriver()).login();
        IvanSearchPage ivanSearchPage = new IvanSearchPage(getDriver());
        ivanSearchPage.searchByArtist();
        Assert.assertTrue(ivanSearchPage.artistFound());
    }

    @Test
    public void searchAlbum() {
        HomePageIvan homePage = new LoginPageIvan(getDriver()).login();
        IvanSearchPage ivanSearchPage = new IvanSearchPage(getDriver());
        ivanSearchPage.searchByArtist();
        Assert.assertTrue(ivanSearchPage.albumFound());
    }
    @Test
    public void searchNeSong(){
            HomePageIvan homePage = new LoginPageIvan(getDriver()).login();
            IvanSearchPage ivanSearchPage = new IvanSearchPage(getDriver());
            homePage.putSearchRequest("Ivan Song");
            Assert.assertTrue(ivanSearchPage.noneFoundDisplayed());
    }

    @Test
    public void ignoreSpace()  {
            HomePageIvan homePage = new LoginPageIvan(getDriver()).login();
            IvanSearchPage ivanSearchPage = new IvanSearchPage(getDriver());
            homePage.putSearchRequest("     Take My Hand     ");
            System.out.println("------TEXT:   "+ivanSearchPage.getTextFromSearch());
            Assert.assertTrue(ivanSearchPage.getTextFromSearch().contains("take my"));
    }

    @Test ////BAG
    public void ignoreCaseSens() {
        HomePageIvan homePage = new LoginPageIvan(getDriver()).login();
        IvanSearchPage ivanSearchPage = new IvanSearchPage(getDriver());
        homePage.putSearchRequest("TAKE MY HAND");

        Assert.assertFalse(ivanSearchPage.takeHandSongFound());
    }

    @Test
    public void clearSearchQuery() {
        HomePageIvan homePage = new LoginPageIvan(getDriver()).login();
        IvanSearchPage ivanSearchPage = new IvanSearchPage(getDriver());
        homePage.putSearchRequest("Take my Hand");
        ivanSearchPage.clearSearchInput();
        Assert.assertTrue(ivanSearchPage.allClear());

    }




}
