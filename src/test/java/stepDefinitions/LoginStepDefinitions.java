package stepDefinitions;

import POM.pages.HomePage;
import POM.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("I open Login Page")
    public void iOpenLoginPage() {
        driver.get("https://bbb.testpro.io/");
    }

    @And("I enter email {string}")
    public void iEnterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @When("I click Log In button")
    public void iClickLogInButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginBtn();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isPageOpened();
    }

    @Then("I am NOT logged in")
    public void iAmNOTLoggedIn() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginPageIsStillOpen();
    }
}

