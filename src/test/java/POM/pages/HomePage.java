package POM.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    String url = "https://bbb.testpro.io/";

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    public String homepageURL(){
        return url;
    }
}
