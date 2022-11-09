import POM.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void viewAll() throws InterruptedException {
        login();

        String viewAllURL = "https://bbb.testpro.io/#!/recently-played";

        HomePage homePage = new HomePage(driver);
        homePage.clickViewAllSongs();
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
