package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    By avatarLocator= By.cssSelector("img.avatar");

    public  HomePage(WebDriver givenDriver) {
            driver = givenDriver;
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        }


    }

