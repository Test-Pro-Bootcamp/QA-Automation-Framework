import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ChangeUserNameTest extends BaseTest {

    @Test(priority = 1, description = "changing user name")
    public void changeUserNameVerifyTheChange() throws InterruptedException {
    
        provideEmail("demo@class.com");
        providePassword();
        clickSubmitBtn();
        clickAvatarIcon();
        WebElement currentPassword = driver.findElement(By.xpath("//input[@name='current_password']"));
        currentPassword.sendKeys("te$t$tudent");

        WebElement username = driver.findElement(By.xpath("//input[@name='name']"));
        String expectedUserName = randomStr();
        username.sendKeys(expectedUserName);  //" " to make it always changeable

        WebElement saveBtn = driver.findElement(By.xpath("//button[text()='Save']"));
        saveBtn.click();

        Thread.sleep(3000);

        WebElement actualUserName = driver.findElement(By.xpath("//span[@class='name']"));
        Assert.assertEquals(expectedUserName, actualUserName);
    }
    private void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.xpath("//img[contains(@alt,'Avatar of')]"));
        avatarIcon.click();
    }
    public String randomStr(){
        return UUID.randomUUID().toString().replace( "", "");
    }
}
