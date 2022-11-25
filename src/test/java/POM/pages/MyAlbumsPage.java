package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAlbumsPage extends BasePage {

    By changeViewAsLitsLocator = By.xpath("//*[@id=\"albumsWrapper\"]/header/span/label[2]");
    By thumbnailsEnable = By.cssSelector("#albumsWrapper > header > span > label.thumbnails");

//#albumsWrapper > header > span > label.list.active
    public MyAlbumsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void changeViewAsList(){
        driver.findElement(changeViewAsLitsLocator).click();
    }

    public boolean isViewChanged() {
        WebElement thumbnails = driver.findElement(thumbnailsEnable);
        return thumbnails.isDisplayed();
    }





}


