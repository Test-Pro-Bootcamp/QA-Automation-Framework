package stepDefinitions;
import Salma_POM.Pages.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStepDefinitions{
    WebDriver driver= new ChromeDriver();
    WebDriverWait wait;
    LoginPage loginPage = new LoginPage(driver);

        @Before
        public void openBrowser() {
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }


    @After
    public void quitBrowser(){
        driver.quit();
   }

        @Given("I open Login page")
        public void openLoginPage (){
            driver.get("https://bbb.testpro.io/");
        }
         @When ("I enter email {string}")
         public void enterEmail(String email){
             loginPage.provideEmail(email);
         }
        @And ("I enter password {string}")
        public void enterPassword(String password){
        loginPage.providePassword(password);
    }
       @And("I click submit")
       public void clickSubmit(){
           loginPage.clickSubmitBtn();
    }
       @Then("I am logged in")
       public void LoggedIn(){
        HomePage homePage = new HomePage(driver);
        homePage.isUserAvatarDisplayed();
       }


    }

