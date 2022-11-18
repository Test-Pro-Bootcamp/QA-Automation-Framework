package practicePO.pages.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPagesimple extends BasePagesimple {
    public void fillEmail() {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("demo@class.com");
    }

    public void fillPass() {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
    }
   public void clickSubmit() {
       WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
       submitButton.click();
   }

   }




