package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewAllPage extends BasePage {
    //Web Elements
    @FindBy(xpath="//section[@id='recentlyPlayedWrapper']//tr[@class='song-item']//td[@class='title']")
    WebElement firstSongOnList;

    @FindBy(xpath="//section[@id='recentlyPlayedWrapper']//li[@class='top-queue']")
    WebElement addToTopOfQueueOption;

    @FindBy(xpath="//button[contains(@title, 'Add selected songs')]")
    WebElement addToPlayListBtn;

    @FindBy(xpath="//img[contains(@alt,'Avatar of')]")
    WebElement myAvatarIcon;

    public ViewAllPage(WebDriver sentDriver) {
        super(sentDriver);
    }

    public ViewAllPage clickAddToPlaylist() {
        addToPlayListBtn.click();
        return this;
    }
    public ViewAllPage clickFirstSongFromList() {
        firstSongOnList.click();
        return this;
    }
    public String getFirstSongName() {
        return firstSongOnList.getText();
    }

    public ViewAllPage addToTopOfQueue() {
        this.addToTopOfQueueOption.click();
        return  this;
    }
}
