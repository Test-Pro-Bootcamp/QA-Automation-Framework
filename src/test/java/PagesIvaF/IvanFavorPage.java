package PagesIvaF;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class IvanFavorPage extends BasePageIvan
{
    public IvanFavorPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public List getListOfTheSongs() {

        return driver.findElements(By.cssSelector("#playlistWrapper td.title"));
    }
}
