package tests.US004;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.HotelListPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC003 extends TestBaseRapor {
    AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
    LoginPage loginPage = new LoginPage();
    HotelListPage hotelListPage = new HotelListPage();

    @Test
    public void test01() {
        extentTest=extentReports.createTest("TC003","ADD Hotel butonuna tiklanildi");
        //1-https://www.hotelmycamp.com/ Url ile giris yapılır
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        //2-Login butonuna tıklandı
        anaSayfaPage.mainLoginLinki.click();
        //3-Username girildi
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        //4-Password girildi
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("ManagerPassword"));
        //5-Login butonuna basıldı
        loginPage.GirisLoginButon.click();
        //6-Yönetici olarak giriş yapıldıgını test edelim.
        Assert.assertTrue(hotelListPage.listofUserYazısı.isDisplayed());
        //7)sol taraftaki hotel management a tikla
        hotelListPage.hotelManagementButonu.click();
        //8)Acilan menuden hotel list e tikla
        hotelListPage.hotelListButonu.click();

        //9)List of hotels yazisi goruldugunu test et
        hotelListPage.listOfHotelsYazısı.click();
        Assert.assertTrue(hotelListPage.listOfHotelsYazısı.isDisplayed());
        //10)sol taraftaki Add Hotel butonuna tikla
        hotelListPage.ADDHOTELButonu.click();
        extentTest.info("AddHotel butonuna tiklanildi");
        //11)Create hotel yazisi goruldugunu test et
        hotelListPage.CreateHotelButonu.click();
        Assert.assertTrue(hotelListPage.CreateHotelButonu.isDisplayed());
        Driver.closeDriver();
    }
}
