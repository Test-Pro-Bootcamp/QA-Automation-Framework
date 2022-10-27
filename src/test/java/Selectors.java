import org.openqa.selenium.By;
import org.testng.Assert;

public class Selectors {
    By emailFieldSelector = By.xpath("//*[@type=\"email\"]");
    By passFieldSelector = By.xpath("//*[@type=\"password\"]");
    By submitButtonSelector = By.xpath("//*[@type=\"submit\"]");
    By avatarIconSelector = By.xpath("//img[@alt='Avatar of 5d247fddf6d0448793efa922e5bc9728']");
    By queueLinkSelector = By.xpath("//*[@href=\"#!/queue\"]");
    By queueContainerSelector = By.xpath("//*[@id='queueWrapper']");
    //By homeLinkSelector = By.linkText("Home");   //*[text()='Home']
    By homeLinkSelector = By.xpath("//*[text()='Home']");
    By searchFieldSelector = By.xpath("//*[@name='q']");

}
