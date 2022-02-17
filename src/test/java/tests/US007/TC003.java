package tests.US007;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelRoomsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC003 {
    HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();

    @Test
    public void TC003() throws InterruptedException {
        //1-https://www.hotelmycamp.com/ Url ile giris yapılır
        //2-Login butonuna tıklandı
        //3-Username girildi
        //4-Password girildi
        //5-Login butonuna basıldı
        //6-Hotel Management listesinden Hotel Rooms tıklandı,
        //7-LIST OF HOTELROOMS yazısı görüntülendi
        //8-Bilgilerini değiştirmek istediği alanda DETAILS butonuna tıklanmalı
        //9-Değişiklik yapılacak olan sayfada "Edit Hotelroom" yazısı görüntülenmeli
        //10-Tüm değişiklikler ilgili alanlarda yapıldıktan sonra SAVE butonuna tıklanmalı
        //"11-guncellemeler yapıldıktan sonra ""HotelRoom was updated successfully""
        // yazısı görüntülenmeli"


        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        hotelRoomsPage.loginLinki.click();
        Thread.sleep(2000);
        hotelRoomsPage.usernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        hotelRoomsPage.passwordBox.sendKeys(ConfigReader.getProperty("ManagerPassword"));
        hotelRoomsPage.loginButonu.click();

        Assert.assertTrue(hotelRoomsPage.listOfUsersYazisi.isDisplayed());
        System.out.println("basarili sekilde giris yapildi");

        Assert.assertTrue(hotelRoomsPage.listOfHotelRoomsYazisi.isDisplayed());
        hotelRoomsPage.detailsButonu.click();
        Assert.assertTrue(hotelRoomsPage.editHotelRoomYazisi.isDisplayed());




    }
}
