package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I open browser")
    public void iOpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @And("I open Login Page")
    public void iOpenLoginPage() {
        driver.get("https://bbb.testpro.io");


    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(emailField));
        Assert.assertTrue(emailField.isDisplayed());
        emailField.sendKeys(email);

    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.sendKeys(password);

    }

    @And("I submit")
    public void iSubmit() {
        WebElement submitBtn = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitBtn.click();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        By avatar = By.cssSelector("img.avatar");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(avatar));
        Assert.assertTrue(driver.findElement(avatar).isDisplayed());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}