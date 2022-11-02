
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    @Test (priority = 1, dataProvider = "loginProvider", dataProviderClass = BaseTest.class)
    public void validLogin(String email, String password) throws InterruptedException {
        provideEmail("dankoyanka@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();

        deletePlaylist();
        getConfirmationPopUpText();
//        confirmDelete();
    }
    }
//    public void deletePlaylist() throws InterruptedException {
//
////        login("dankoyanka@gmail.com", "te$t$tudent");
//
//        WebElement playlist = driver.findElement
//                (By.cssSelector(".playlist.playlist"));
//        playlist.click();
//        Thread.sleep(2000);
//
//        WebElement delbtn = driver.findElement
//                (By.xpath("//button[@class='del btn-delete-playlist']"));
//        delbtn.click();
//        Thread.sleep(2000);
//
//        WebElement confirmBtn = driver.findElement
//                (By.xpath("//button[@class='ok']"));
//        confirmBtn.click();
//        Thread.sleep(2000);
//
//        WebElement poPup = driver.findElement(By.xpath
//                (" //div[@class='success show']"));
//        Assert.assertTrue(poPup.isDisplayed());
//
//    }



