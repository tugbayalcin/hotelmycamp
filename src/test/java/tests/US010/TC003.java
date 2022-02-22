package tests.US010;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.HotelRoomsPage;
import pages.LoginPage;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.ObjectInitialiser.anaSayfaPage;

public class TC003 extends TestBaseRapor {

    @Test
    public void test03(){

        AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
        RoomReservationsPage roomReservationsPage = new RoomReservationsPage();
        LoginPage loginPage = new LoginPage();
        HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();

        extentTest=extentReports.createTest("TC003","Advanced Search yapabilme");

        //1- https://www.hotelmycamp.com/ URL adresine gidiniz.
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        //2- '"Rooms" menüsünü locate ediniz ve "Rooms" butonuna tıklayınız.
        anaSayfaPage.anasayfaRoomsButon.click();

        //6- Açılan sayfada "Advanced Search" menüsününden "Select Room Type" kutucuğunu locate ediniz
        // ve "Double" değerini değerini seçiniz.
        Select select=new Select(hotelRoomsPage.selectRoomTypeButonu);
        select.selectByVisibleText("Double");
        //7- "Advanced Search" menüsününden "Select Adult Count" kutucuğunu locate ediniz ve "2 Adult"
        // değerini seçiniz.
        select=new Select(hotelRoomsPage.selectAdultCountButonu);
        select.selectByVisibleText("2 Adult");
        //8-"Search" butonunu locate ediniz ve tıklayınız, gelen sonuç sayfasında ilk sırada "Double room"
        // olduğunu test ediniz.
        hotelRoomsPage.advancedSearchButonu.click();
        extentTest.info("Search butonu tıklandı");
        Assert.assertTrue(hotelRoomsPage.doubleRoom225DolarYazısı.isDisplayed());
        extentTest.pass("Yapılan aramada istenen sonuca ulaşıldı");
        Driver.closeDriver();


    }
}
