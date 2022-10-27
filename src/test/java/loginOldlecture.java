import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import stash.Stashed;


import java.time.Duration;

public class loginOldlecture {

    @Test
    public static void LoginValidEmailPasswordTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
            emailField.click();
            emailField.sendKeys("demo@class.com");

            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            passwordField.click();
            passwordField.sendKeys("te$t$tudent");


            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            submitButton.click();
            //
            WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        } finally {
            Thread.sleep(5000);
            //Assert.assertEquals(driver.getCurrentUrl(), url);
            driver.quit();
        }

    }


    //@Test
    public static void LoginEmptyPasswordTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/#!/home";
            driver.get(url);

            WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
            emailField.click();
            emailField.sendKeys("demo@class.com");

//        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
//        passwordField.click();
//        passwordField.sendKeys("te$t$tudent");


            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            submitButton.click();
            //
            WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        } finally {
            Thread.sleep(5000);
            //Assert.assertEquals(driver.getCurrentUrl(), url);
            driver.quit();
        }


    }

    //@Test
    public static void LoginInvalidEmailTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/#!/home";
            driver.get(url);

            WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
            emailField.click();
            emailField.sendKeys("demopp@class.com");

            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            passwordField.click();
            passwordField.sendKeys("te$t$tudent");


            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            submitButton.click();
            //
            WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        } finally {
            Thread.sleep(5000);
            //Assert.assertEquals(driver.getCurrentUrl(), url);
            driver.quit();
        }

    }

    // @Test
    public static void registrationTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/#!/home";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("demo@class.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        Assert.assertTrue(avatarIcon.isDisplayed());


        WebElement songMenu = driver.findElement(By.className("songs"));
        songMenu.click();


        Thread.sleep(5000);
        driver.quit();


    }

    //@Test
    public static void songMenuTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/#!/home";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("demo@class.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        Assert.assertTrue(avatarIcon.isDisplayed());


        WebElement songMenu = driver.findElement(By.className("songs"));
        songMenu.click();
        // short way
        //driver.findElement(songMenu).click();


        Thread.sleep(5000);
        driver.quit();


    }

    // @Test




    @Test
    public static void LoginingTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //String url = "https://bbb.testpro.io/#!/home";
            //driver.get(url);
//            By emailFieldSelector = By.cssSelector("[type='email']");
            //*[@id="app"]/div/form/input[1]
//            By emailFieldSelector = By.xpath("//[@id="app"]/div/form/input[1]");
//            By passFieldSelector = By.cssSelector("[type='password']");
//            By submitButtonSelector = By.cssSelector("[type='submit']");
//            By avatarIconSelector = By.cssSelector("[alt='Avatar of student']");
//            By queueLinkSelector = By.cssSelector("[href=\"#!/queue\"]");
//            By queueContainerSelector = By.cssSelector("#queueWrapper");
//            By homeLinkSelector = By.linkText("Home");
//            By searchFieldSelector = By.name("q");


            // By emailFieldSelector = By.cssSelector("[type='email']");
            //*[@id="app"]/div/form/input[1]

            String loginEmail = "demo@class.com";
            String loginPass ="te$t$tudent";
            String url ="http://bbb.testpro.io/";

            driver.get(url);

            Selectors selectMe = new Selectors();

            Login(loginEmail,loginPass,driver);
            //
            WebElement avatarIcon = driver.findElement(selectMe.avatarIconSelector);
            Assert.assertTrue(avatarIcon.isDisplayed());

            //search pluto with xpath and validate the song is correct xpath //article//*[contains(text(),'Pluto']

            //*[@data-test='song-card']//*[contains(text(),'Pluto')]

            WebElement searchField = driver.findElement(selectMe.searchFieldSelector);
            searchField.click();
            searchField.sendKeys("Pluto");
            // how to validate song pluto

            WebElement isCorrectSong = driver.findElement(By.xpath("//*[@data-test='song-card']//*[contains(text(),'Pluto')]"));
            Assert.assertTrue(isCorrectSong.isDisplayed());
            Assert.assertTrue(true, "Pluto");

        } finally {
            Thread.sleep(2000);
            //Assert.assertEquals(driver.getCurrentUrl(), url);
            driver.quit();
        }

    }
    public static void Login(String loginEmail, String loginPass, WebDriver driver ) {
        Selectors selectMe = new Selectors();
        WebElement emailField = driver.findElement(selectMe.emailFieldSelector);
        emailField.click();
        emailField.sendKeys(loginEmail);

//            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        WebElement passwordField = driver.findElement(selectMe.passFieldSelector);
        passwordField.click();
        passwordField.sendKeys(loginPass);


        WebElement submitButton = driver.findElement(selectMe.submitButtonSelector);
        submitButton.click();

    }



}

