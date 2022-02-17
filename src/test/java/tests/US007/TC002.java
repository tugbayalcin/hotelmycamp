package tests.US007;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelRoomsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC002 {

    HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();
    @Test
    public void TC02() throws InterruptedException {
         //1-https://www.hotelmycamp.com/ Url ile giris yapılır
        //2-Login butonuna tıklandı
        //3-Username girildi
        //4-Password girildi
        //5-Login butonuna basıldı
        //6-LIST OF HOTELROOMS yazısı  görüntülendi
        //7-Hotel Romms linkine tıklandı
        //8-'List of Hotel Rooms' yazisi görüntülendi
        //9- arama için ID BOX'a aranacak data girildi,SEARCH butonuna tıklandı
        //10-girilen bilgiler dogrultusunda tanımlı olan oda görüntülenmeli

        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        hotelRoomsPage.loginLinki.click();
        Thread.sleep(2000);
        hotelRoomsPage.usernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        hotelRoomsPage.passwordBox.sendKeys(ConfigReader.getProperty("ManagerPassword"));
        hotelRoomsPage.loginButonu.click();
        Assert.assertTrue(hotelRoomsPage.listOfUsersYazisi.isDisplayed());
        System.out.println("basarili sekilde giris yapildi");

        Assert.assertTrue(hotelRoomsPage.listOfHotelRoomsYazisi.isDisplayed());
        hotelRoomsPage.hotelManagementLinki.click();
        Thread.sleep(1500);
        hotelRoomsPage.odaListesiSayfaDegistirmeButonu.click();
        Assert.assertTrue(hotelRoomsPage.FoundTotal20Records.isDisplayed());
        System.out.println("sayfalar arasi gecis yapildi");
        hotelRoomsPage.hotelRoomsLinki.click();
        hotelRoomsPage.odaIdBox.sendKeys("120");
        hotelRoomsPage.searchButonu.click();
        Assert.assertTrue(hotelRoomsPage.foundTotal1RecordsYazisi.isDisplayed());
        System.out.println("Aranan kayit bulundu");


    }
}
