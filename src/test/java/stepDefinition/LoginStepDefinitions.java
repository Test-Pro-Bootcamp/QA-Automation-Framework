package stepDefinition;

import PagesIvaF.HomePageIvan;
import PagesIvaF.LoginPageIvan;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.beans.Visibility;
import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Given("I open Login Page")
    public void iOpenLoginPage() {
        driver.get("https://bbb.testpro.io/");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String arg0) {
        LoginPageIvan loginPageIvan = new LoginPageIvan(driver);
        loginPageIvan.provideEmail(arg0);

    }

    @And("I enter password {string}")
    public void iEnterPassword(String arg0) {
        LoginPageIvan loginPageIvan = new LoginPageIvan(driver);
        loginPageIvan.providePassword(arg0);

    }

    @And("I submit")
    public void iSubmit() {
        LoginPageIvan loginPageIvan = new LoginPageIvan(driver);
        loginPageIvan.clickSubmitBtn();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        LoginPageIvan loginPageIvan = new LoginPageIvan(driver);
        HomePageIvan homePageIvan = new HomePageIvan(driver);
        Assert.assertTrue(homePageIvan.isUserAvatarDisplayed());
    }
    @After
    public void closeBrowser(){
        driver.quit();;
    }
}
