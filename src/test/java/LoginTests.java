import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {

    @Test
    public static void LoginGoodEmailGoodPass() throws InterruptedException {

        // load homepage
        // login
        // go to artists
        // go to home
        // search for Pluto

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Selectors selectMe = new Selectors();

        String loginEmail = "demo@class.com";
        String loginPass = "te$t$tudent";
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        login(loginEmail,loginPass, driver);

        WebElement queueLink = driver.findElement(selectMe.queueLinkSelector);
        queueLink.click();

        WebElement queueContainer = driver.findElement(selectMe.queueContainerSelector);
        Assert.assertTrue(queueContainer.isDisplayed());
        Thread.sleep(2000);

        WebElement homeLink = driver.findElement(selectMe.homeLinkSelector);
        homeLink.click();

        WebElement searchBar = driver.findElement(selectMe.searchFieldSelector);
        searchBar.click();
        searchBar.sendKeys("Pluto");
        WebElement result = driver.findElement(selectMe.resultSelector);
        Assert.assertTrue(result.isDisplayed());

        Thread.sleep(4000);
        Assert.assertTrue(result.getText().contains("Pluto"));


        Thread.sleep(2000);

        driver.quit();
    }

    public static void login(String email, String pass,
                             WebDriver driver) {
        Selectors selectMe = new Selectors();

        WebElement emailField = driver.findElement(selectMe.emailFieldSelector);
        emailField.click();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(selectMe.passFieldSelector);
        passwordField.click();
        passwordField.sendKeys(pass);

        WebElement submitButton = driver.findElement(selectMe.submitButtonSelector);
        submitButton.click();

        WebElement avatarIcon = driver.findElement(selectMe.avatarIconSelector);
        Assert.assertTrue(avatarIcon.isDisplayed());

    }
}
