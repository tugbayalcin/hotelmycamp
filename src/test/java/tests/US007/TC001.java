package tests.US007;

import org.testng.Assert;
import org.testng.annotations.Test;
 ;
import pages.HotelRoomsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC001 extends TestBaseRapor {
    //1-https://www.hotelmycamp.com/ Url ile giris yapılır
//2-Login butonuna tıklandı
//3-Username girildi
//4-Password girildi
//5-Login butonuna basıldı
//6-Yönetici olarak giriş yapıldı

    HotelRoomsPage hotelRoomsPage = new HotelRoomsPage();


    @Test
    public void  TC01() throws InterruptedException {

        extentTest=extentReports.createTest("TC001","Yonetici olarak giris yapildigini goruntuleme");

         hotelRoomsPage.managerLoginHotelRoomPages();
         extentTest.pass("yonetici olarak giris yapildi");

    }

}