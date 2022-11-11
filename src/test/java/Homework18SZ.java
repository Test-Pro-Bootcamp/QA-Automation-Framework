import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//     1.Create a new file Homework18.java file with @Test annotation in IntelliJ IDEA
//        Create a test case playSong() using @Test annotations
//        Use the helper/reusable methods we created
//        Create a new config XML file for the test case
//        Specify the method to be ran in the XML file
//        Navigate to "https://bbb.testpro.io/"
//        Log in with your credentials
//        Play a song
//        Validate that a song is playing
//        Create a new branch and commit your changes
//        Push your code to a remote repository
//        Create a pull request
//        Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework

public class Homework18SZ extends BaseTest  {

    @Test
    public void playSong() throws InterruptedException{
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();


        playASong();

        WebElement visualizer = driver.findElement(By.xpath("//button[@title='Click for a marvelous visualizer!']"));
        Assert.assertTrue(visualizer.isDisplayed());

    }

    private void playASong() throws InterruptedException {
        WebElement nextBtn= driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        nextBtn.click();
        Thread.sleep(2000);
        WebElement playPauseBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playPauseBtn.click();
    }

}
