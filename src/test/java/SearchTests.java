import POM.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest{
    @Test
    public void searchASong(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        BasePage basePage = new BasePage(driver).search();
        SearchPage searchPage = new SearchPage(driver).searchForSong("Pluto");

        Assert.assertTrue(searchPage.plutoFound());
    }

    @Test
    public void searchByArtist(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        BasePage basePage = new BasePage(driver).search();
        SearchPage searchPage = new SearchPage(driver).searchByArtist();

        Assert.assertTrue(searchPage.makaihFound());
    }

    @Test
    public void searchByAlbum(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        BasePage basePage = new BasePage(driver).search();
        SearchPage searchPage = new SearchPage(driver).searchByAlbum();

        Assert.assertTrue(searchPage.airbitFound());
    }

    @Test
    public void searchNonExSong(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        BasePage basePage = new BasePage(driver).search();
        SearchPage searchPage = new SearchPage(driver).searchForSong("Nozima");

        Assert.assertTrue(searchPage.noneFoundDisplayed());
    }

    @Test
    public void ignoreWhitespace(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        BasePage basePage = new BasePage(driver).search();
        SearchPage searchPage = new SearchPage(driver).searchForSong("          Pluto ");

        Assert.assertTrue(searchPage.plutoFound());
    }

    @Test
    public void ignoreCaseSens() {
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com", "te$t$tudent");
        BasePage basePage = new BasePage(driver).search();
        SearchPage searchPage = new SearchPage(driver).enterSearchKeyword("PLUTO");

        Assert.assertTrue(searchPage.plutoFound());
    }

    @Test
    public void clearSearchQuery(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        BasePage basePage = new BasePage(driver).search();
        SearchPage searchPage = new SearchPage(driver).searchForSong("Pluto").clearSearchInput();

        Assert.assertTrue(searchPage.allClear());
    }
}
