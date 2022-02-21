package tests.US010;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC001 extends TestBaseRapor {

    @Test

    public void rooms(){
        AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
        RoomReservationsPage roomReservationsPage = new RoomReservationsPage();
        LoginPage loginPage = new LoginPage();

        extentTest=extentReports.createTest("TC001","Rooms yazısı görüntüleme");



        //1- https://www.hotelmycamp.com/ URL adresine gidiniz.
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        //2- '"Rooms" menüsünü locate ediniz ve "Rooms" butonuna tıklayınız.
        anaSayfaPage.anasayfaRoomsButon.click();
        extentTest.info("ana sayfa rooms tıklandı");
        //3- Açılan sayfada "Rooms" yazısının çıktığını test ediniz.
        Assert.assertTrue(anaSayfaPage.anaSayfaRoomsYazısı.isDisplayed());
        extentTest.pass("Rooms yazısı görüntelendi");
        Driver.closeDriver();

    }


}