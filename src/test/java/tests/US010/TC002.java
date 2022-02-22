package tests.US010;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.HotelRoomsPage;
import pages.LoginPage;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC002 extends TestBaseRapor {

    @Test
    public void test02()  {

        AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
        RoomReservationsPage roomReservationsPage = new RoomReservationsPage();
        LoginPage loginPage = new LoginPage();
        HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();

        extentTest=extentReports.createTest("TC002","Oda seçeneklerine ulaşabilme");
        //1- https://www.hotelmycamp.com/ URL adresine gidiniz.
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        //2- '"Rooms" menüsünü locate ediniz ve "Rooms" butonuna tıklayınız.
        anaSayfaPage.anasayfaRoomsButon.click();
        //3- "Categories" başlığı altında bulunan "Triple" seçeneğini locate ediniz ve
        // ulaşılabilir olduğunu test ediniz.

        Assert.assertTrue(hotelRoomsPage.tripleOdaSeçeneğiButonu.isEnabled());
        extentTest.pass("Oda seçenekleri ulaşılabilir durumda");

        Driver.closeDriver();


    }
}

