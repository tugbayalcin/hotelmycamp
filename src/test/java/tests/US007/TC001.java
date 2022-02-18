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

         hotelRoomsPage.managerLoginHotelRoomPages();
    }

}