import org.testng.annotations.BeforeSuite;


public class BaseTests {

    @BeforeSuite
    public static void chromeConfigs() {

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }

    }

}

