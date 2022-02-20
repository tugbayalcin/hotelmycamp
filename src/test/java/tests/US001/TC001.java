package tests.US001;

import org.openqa.selenium.WebElement;
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
    public void testCase1(){
        extentTest=extentReports.createTest("TC001","Anasayfadaki basliklar tiklanmali");
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        AnaSayfaPage anaSayfaPage=new AnaSayfaPage();
        RoomReservationsPage roomReservationsPage=new RoomReservationsPage();
        LoginPage loginPage=new LoginPage();
        anaSayfaPage.mainLoginLinki.click();
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("KullaniciUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("KullaniciPassword"));
        loginPage.GirisLoginButon.click();
        extentTest.info("Giris yapildi");
        Assert.assertTrue(anaSayfaPage.anasayfaRoomsButon.isDisplayed());
        extentTest.pass("Rooms buton goruntulendi");
        anaSayfaPage.anasayfaRoomsButon.click();
        extentTest.info("Rooms buton tiklandi");
        Driver.getDriver().navigate().back();
        Assert.assertTrue(anaSayfaPage.anasayfaRestaurantButon.isDisplayed());
        extentTest.pass("Restaurant buton goruntulendi");
        anaSayfaPage.anasayfaRestaurantButon.click();
        extentTest.info("Restaurant buton tiklandi");
        Driver.getDriver().navigate().back();
        Assert.assertTrue(anaSayfaPage.anasayfaAboutButon.isDisplayed());
        extentTest.pass("About buton goruntulendi");
        anaSayfaPage.anasayfaAboutButon.click();
        extentTest.info("About buton tiklandi");
        Driver.getDriver().navigate().back();
        Assert.assertTrue(anaSayfaPage.anasayfaContactButon.isDisplayed());
        extentTest.pass("Contact buton goruntulendi");
        anaSayfaPage.anasayfaContactButon.click();
        extentTest.info("Contact buton tiklandi");
        Driver.getDriver().navigate().back();
        Driver.closeDriver();
    }
}
