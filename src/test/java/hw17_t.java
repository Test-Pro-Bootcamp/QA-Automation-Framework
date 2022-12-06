import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class hw17_t extends BaseTest{
    @Test
    public void addSongToPlaylist() {
        provideEmail("trangoishi99@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();

        WebElement avatarIcon = driver.findElement(By.xpath("//img[contains(@alt,'Avatar of')]"));
        //WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        Assert.assertTrue(avatarIcon.isDisplayed());

        //select the all song

        recentPlaylist();
        firstSongInPlaylist();
        addToButton();
        selectPlaylist();
        checkSelectedPlaylist();
        String songselected = songTitle();
        String songInsideTheListtoBechecked= songTobeChecked();
        Assert.assertEquals(songselected,songInsideTheListtoBechecked);

//        WebElement allBtn = driver.findElement(By.xpath("//section[@id=\"recentlyPlayedWrapper\"]//button[@class=\"btn-shuffle-all\"]"));
//        allBtn.click();
        //dropDownMenuPlaylist();
        //selectPlaylist();
    //        WebElement recentlist = driver.findElement(By.xpath("//a[@href=\"#!/recently-played\"]"));
        //section[@id='playlistWrapper']//tr[@class='song-item']//td[@class='title']

    }

    private void checkSelectedPlaylist() {

        //a[text()='tt']
        WebElement mylist = driver.findElement(By.xpath("//a[@class='active']"));

        mylist.click();
    }

    private void recentPlaylist() {
        WebElement recentlist = driver.findElement(By.xpath("//a[@href=\"#!/recently-played\"]"));
        recentlist.click();
   }

    //helpers
    //go recently play

//    public void allViewbtn() {--not needed---)
//        //all button xpaht //button[@class="btn-shuffle-all"]
//        WebElement allBtn = driver.findElement(By.xpath("//section[@id=\"recentlyPlayedWrapper\"]//button[@class=\"btn-shuffle-all\"]"));
//        allBtn.click();
//    }

    //hover first song  xpath
    public void firstSongInPlaylist() {
        //section[@id="recentlyPlayedWrapper"]//table[@class="items"]//tr[@class="song-item"]
        WebElement songitem = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//tr[@class='song-item']"));
        songitem.click();
    }
    public String songTitle() {
        WebElement songname = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//tr[@class='song-item']//td[@class='title']"));
        return songname.getText();
    }
    public String songTobeChecked(){
        WebElement songInSideTheList = driver.findElement(By.xpath("//section[@id='playlistWrapper']//tr[@class='song-item']//td[@class='title']"));
        return songInSideTheList.getText();
    }
    ////section[@id="recentlyPlayedWrapper"]tr[@class="songs-item selected"]
    public void addToButton(){
        //buton to add song  //button[@class="btn-add-to"]
        WebElement addSongButton = driver.findElement(By.xpath("//button[@class=\"btn-add-to\"]"));
        addSongButton.click();
    }

    //after button is drop down menu
//    public void dropDownMenuPlaylist() {
//        // =---//section[@class="existing-playlists"]
//        WebElement dropdown = driver.findElement(By.xpath("//section[@class=\"existing-playlists\"]"));
//        dropdown.click();
//    }
   //search tt playlist

   public void selectPlaylist() {
       //search tt playlist //section[@class="existing-playlists"]//li[contains(text(),"tt")]

       /////section[@class="existing-playlists"]
       WebElement pickedPlaylist = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//li[contains(text(), 'tt')]"));
       pickedPlaylist.click();
   }

   //find playlist tt


}
