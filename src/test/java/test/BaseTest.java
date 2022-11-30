package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    String url;
    ThreadLocal<WebDriver> threadDriver;

    @BeforeSuite
    public static void chromeConfigs() {
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
        }
    }

    @BeforeMethod
    @Parameters({"baseURL"})

    public void launchBrowser(@Optional String baseURL) throws MalformedURLException {
        baseURL = "https://bbb.testpro.io";
        driver = pickBrowser("browser");

        threadDriver = new ThreadLocal<>();
        threadDriver.set(driver);

//        action = new Actions(getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        url = baseURL;
        getDriver().get(url);
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }

//    public WebDriver lambdaTest() throws MalformedURLException {
//        String username = "dankoyanka";
//        String authkey = "7u1e1vjWWLcBMyNqSpdx9C00NBfqD3yZyVkhjFFn6Nl874Ph74";
//        String hub = "@hub.lambdatest.com/wd/hub";
//
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platform","MacOS Catalina");
//        caps.setCapability("browserName", "Chrome");
//        caps.setCapability("version","106.0");
//        caps.setCapability("resolution", "1920x1080");
//        caps.setCapability("build", "TestNG With Java");
//        caps.setCapability("name", this.getClass().getName());
//        caps.setCapability("plugin", "git-testng");
//
//        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
//    }

    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "dankoyanka";
        String authkey = "7u1e1vjWWLcBMyNqSpdx9C00NBfqD3yZyVkhjFFn6Nl874Ph74";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform","Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version","106.0");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");

        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }



//    ChromeOptions browserOptions = new ChromeOptions();
//browserOptions.setPlatformName("Windows 10");
//browserOptions.setBrowserVersion("107.0");
//    HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//ltOptions.put("username", "dankoyanka");
//ltOptions.put("accessKey", "7u1e1vjWWLcBMyNqSpdx9C00NBfqD3yZyVkhjFFn6Nl874Ph74");
//ltOptions.put("resolution", "1024x768");
//ltOptions.put("project", "Untitled");
//ltOptions.put("selenium_version", "4.1.2");
//ltOptions.put("w3c", true);
//ltOptions.put("plugin", "java-java");
//browserOptions.setCapability("LT:Options", ltOptions);


    private WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.2:4444";
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver");
                return driver = new FirefoxDriver();
            case "safari":
                return driver = new SafariDriver();
            case "grid-safari":
                caps.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                return driver = new ChromeDriver();
        }
    }

    @AfterMethod
    public void tearDownBrowser() {
        getDriver().quit();
        threadDriver.remove();

    }


}

