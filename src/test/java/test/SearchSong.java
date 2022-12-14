package test;

import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchSong extends BaseTest {
//    LoginPage loginPage = new LoginPage(getDriver());
//    HomePage homePage = new HomePage(getDriver());


@Test
    public void searchSong(String songTitle) throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
        searchField.sendKeys(songTitle);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }



}
