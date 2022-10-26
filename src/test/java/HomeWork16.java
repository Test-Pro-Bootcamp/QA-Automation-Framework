import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork16 extends BaseTest{
    @Test
    public void loginWithValidEmail() throws InterruptedException {
        emailLogin();
        createNewPlatList();

        WebElement avatarElement = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        Assert.assertTrue(avatarElement.isDisplayed());


//
//            WebElement searchResult = driver.findElement(By.cssSelector("ul>article"));
//            Assert.assertTrue(searchResult.getText().contains("Pluto"));
//            String a = searchResult.getText();
//            if (a.contains("Pluto")){
//                Boolean testResult = true;
//                Assert.assertTrue(testResult);
//                System.out.println("TEST SUCCESSFUL");
//            }


    }

    private void createNewPlatList() throws InterruptedException {

        WebElement newPlayList = driver.findElement(By.cssSelector("[class='fa fa-plus-circle create']"));
        newPlayList.click();
        Thread.sleep(3000);
        WebElement createPlayList = driver.findElement(By.xpath("//*[text()='New Playlist']"));
        createPlayList.click();
        Thread.sleep(3000);
        WebElement inputPlayList = driver.findElement(By.cssSelector("[placeholder='↵ to save']"));
        inputPlayList.click();
        inputPlayList.sendKeys("super");
        inputPlayList.sendKeys(Keys.RETURN);
        WebElement createdPlayList = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        Assert.assertTrue(createdPlayList.isDisplayed());
        Thread.sleep(3000);
    }


}
