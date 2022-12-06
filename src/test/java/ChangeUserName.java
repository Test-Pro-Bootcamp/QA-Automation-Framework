import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ChangeUserName extends BaseTest{
    @Test(priority=1, description ="changing the username")
    public void changeUsernameVerifyTheChange() {
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        clickAvartarIcon();

        WebElement currentPassword = driver.findElement(By.xpath("//input[@name='current_password']"));
        currentPassword.sendKeys("te$t$tudent");

        WebElement username = driver.findElement(By.xpath("//input[@name='name']"));
        username.sendKeys(randomStr());

        WebElement usernameActual = driver.findElement(By.xpath("//span[@class='name']"));

    }

    private void clickAvartarIcon() {
        WebElement avatarIcon = driver.findElement(By.xpath("//img[contains(@alt,'Avatar of')]"));
        //WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }
    public String randomStr() {
        return UUID.randomUUID().toString().replace("-","");
    }

}
