import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework15 extends BaseTest{

    @Test
    public void search() {

        provideEmail("dirzo@gmail.com");
        providePassword("Te$ter1234");
        clickSubmitBtn();
        WebElement searchBar = driver.findElement(By.cssSelector("[type='search'"));

        searchBar.click();
        searchBar.sendKeys("Pluto");



        WebElement searchResult;
        searchResult = driver.findElement(By.id("searchExcerptsWrapper"));
        Assert.assertTrue(searchResult.isDisplayed());

        if (searchResult.isDisplayed()) {
            WebElement songTitle = driver.findElement(By.xpath("//span[contains(text(),'Pluto')]"));
            Assert.assertTrue(songTitle.isDisplayed());
        }

              driver.quit();
    }
}