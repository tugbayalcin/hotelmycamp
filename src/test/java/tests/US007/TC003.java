package tests.US007;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelRoomsPage;
import utilities.ConfigReader;
import utilities.Driver;
import static utilities.ObjectInitialiser.*;

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
        //11-guncellemeler yapıldıktan sonra "HotelRoom was updated successfully" yazısı görüntülenmeli

        hotelRoomsPage.managerLoginHotelRoomPages();

         hotelRoomsPage.hotelManagementLinki.click();
        hotelRoomsPage.hotelRoomsLinki.click();
        Assert.assertTrue(hotelRoomsPage.listOfHotelRoomsYazisi.isDisplayed());
        hotelRoomsPage.detailsButonu.click();
        Assert.assertTrue(hotelRoomsPage.editHotelRoomYazisi.isDisplayed());
        hotelRoomsPage.codeBox.clear();
        Thread.sleep(1500);
        hotelRoomsPage.codeBox.sendKeys("1110");
        hotelRoomsPage.saveButonu.click();
        Assert.assertTrue(hotelRoomsPage.hotelRoomWasUpdatedSuccessfullyYazisi.isDisplayed());







    }
}
