package tests.US007;

import org.testng.Assert;
import org.testng.annotations.Test;
 ;
import pages.HotelRoomsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC001 {
    //1-https://www.hotelmycamp.com/ Url ile giris yapılır
//2-Login butonuna tıklandı
//3-Username girildi
//4-Password girildi
//5-Login butonuna basıldı
//6-Yönetici olarak giriş yapıldıgını test edelim.

    HotelRoomsPage hotelRoomsPage = new HotelRoomsPage();


    @Test
    public void  TC01() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        hotelRoomsPage.loginLinki.click();
        Thread.sleep(2000);
        hotelRoomsPage.usernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        Thread.sleep(2000);
        hotelRoomsPage.passwordBox.sendKeys(ConfigReader.getProperty("ManagerPassword"));
        hotelRoomsPage.loginButonu.click();
        Assert.assertTrue(hotelRoomsPage.listOfUsersYazisi.isDisplayed());
        System.out.println("basarili sekilde giris yapildi");

    }

}