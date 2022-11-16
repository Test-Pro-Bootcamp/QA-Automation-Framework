import POM.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void viewAll() throws InterruptedException {
        login();

        String viewAllURL = "https://bbb.testpro.io/#!/recently-played";

        HomePage homePage = new HomePage(driver);
        homePage.clickViewAllBtn();
        Thread.sleep(1000);

        Assert.assertEquals(driver.getCurrentUrl(), viewAllURL);
    }

    @Test
    public void viewProfileTest() throws InterruptedException {
        login();

        String profileURL = "https://bbb.testpro.io/#!/profile";

        HomePage homePage = new HomePage(driver);
        homePage.clickViewMyProfile();
        Thread.sleep(1000);

        Assert.assertEquals(driver.getCurrentUrl(), profileURL);
    }


}
