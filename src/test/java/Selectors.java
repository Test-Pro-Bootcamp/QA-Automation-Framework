import org.openqa.selenium.By;

public class Selectors {

    By emailFieldSelector = By.xpath("//*[@type='email']");
    By passFieldSelector = By.xpath("//*[@type='password']");
    By submitButtonSelector = By.xpath("//*[@type='submit']");
    By avatarIconSelector = By.xpath("//img[@alt='Avatar of student']");
    By queueLinkSelector = By.xpath("//*[@href='#!/queue']");
    By queueContainerSelector = By.xpath("//*[@id='queueWrapper']");
    By homeLinkSelector = By.xpath("//*[text()='Home']");
    // //*[text()='Testing']
    By searchFieldSelector = By.xpath("//*[@name='q']");
    By resultSelector = By.cssSelector("ul > article");
}
