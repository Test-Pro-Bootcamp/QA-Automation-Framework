package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CurrentQueuePage extends BasePage {
    //Web Elements
    @FindBy(xpath="//section[@id='queueWrapper']//tr//td[@class='title']")
    List<WebElement> songs;

    public CurrentQueuePage(WebDriver sentDriver) {
        super(sentDriver);
    }

    public List<String> getSongNames() {
        List<String> songNames = new ArrayList<>();

        if(songs != null && !songs.isEmpty()) {
            for(WebElement each : songs) {
                songNames.add(each.getText());
            }
        }

        return songNames;
    }
}
