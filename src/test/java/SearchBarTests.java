import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchBarTests extends BaseTest{
    @Test
    public void SearchBarResults(){
        HomePage homePage = new LoginPage(driver).login();
        homePage.clickOnSearchBar();
        WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Search Results')]")));
        Assert.assertTrue(homePage.isSearchResultsDisplayed());
    }
    @Test
    public void SearchBarSongsResults(){
        HomePage homePage = new LoginPage(driver).login();
        homePage.clickOnSearchBar();
        Assert.assertTrue(homePage.isSongsSectionResultsDisplayed());
   }
//   @Test
//    public void EmptyListResults(){
//        HomePage homepage =new LoginPage(driver).login();
//        homepage.clickOnSearchBar();
//        Assert.assertEquals(homepage.getTextNoResults(),"no results");

//   
   @Test
    public void CleanTheSearchQuery(){
        HomePage homepage =new LoginPage(driver).login();
        homepage.clickOnSearchBar();
        Assert.assertEquals(homepage.getTextFindSongsArtistAlbums(),"Find songs, artists, and albums");

   }

}
