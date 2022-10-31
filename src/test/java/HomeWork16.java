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

        newPlaylist();
        WebElement createdPlayList = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/a"));
        createdPlayList.click();

    }

    private WebElement getDeletePlayListMsg() {
        return driver.findElement(By.cssSelector("div.success.show"));
    }

    private void deletePlaylist() {
        WebElement deletePls = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        deletePls.click();
    }


}
