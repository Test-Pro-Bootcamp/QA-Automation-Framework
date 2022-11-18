package practicePO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import practicePO.pages.page.LoginPagesimple;

public class KoelLogin {
    @Test
    public void login() {
        LoginPagesimple loginPage = new LoginPagesimple();
        loginPage.fillEmail();
        loginPage.fillPass();
        loginPage.clickSubmit();

        Assert.assertTrue(loginPage.isAvatarDisplaying());




    }
}
