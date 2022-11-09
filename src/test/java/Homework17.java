import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 {
    @Test


    public static void addSongToPlaylist() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("iq14111991@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement choseAllSongs = driver.findElement(new By.ByXPath("//*[@id=\"sidebar\"]/section[1]/ul/li[3]/a"));
        choseAllSongs.click();


        WebElement choseSong1 = driver.findElement(new By.ByXPath("/html/body/div/div/div/section[1]/section[3]/div/div/div[1]/table/tr[1]/td[2]"));
        choseSong1.click();
        WebElement addTo = driver.findElement(new By.ByXPath("//*[@id=\"songsWrapper\"]/header/div[3]/span/button[2]"));
        addTo.click();
        Thread.sleep(3000);
        WebElement chosePLtoAdd = driver.findElement(new By.ByXPath("//*[@id=\"songsWrapper\"]/header/div[3]/div/section[1]/ul/li[6]"));
        chosePLtoAdd.click();
// Я не совсем понял как можно проверить добавлена ли песня в плей лист, так же у меня есть пара вопросов:
//        1) не получится добавить несколько песен таким способом одновременно, вводить в ручную путь для песен долго и не эффективно
//        2) я подсмотрел как с этой задачей справились другие ученики, я не могу использовать функции так же как они
//        private void addToSuperPlaylist() {
//            WebElement superPlaylist = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//li[contains(text(),'super')]"));
//            superPlaylist.click();
//        КАК пример, такие в таких функциях подчеркивает driver. Не смог понять как с этим справиться


        Thread.sleep(3000);

//        driver.quit();
    }
}