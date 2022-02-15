package tests.US001;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC001 {

    @Test
    public void testCase1(){

        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        AnaSayfaPage anaSayfaPage=new AnaSayfaPage();
        RoomReservationsPage roomReservationsPage=new RoomReservationsPage();
        LoginPage loginPage=new LoginPage();
        anaSayfaPage.mainLoginLinki.click();
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("KullaniciUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("KullaniciPassword"));
        loginPage.GirisLoginButon.click();
        Assert.assertTrue(anaSayfaPage.anasayfaRoomsButon.isDisplayed());
        anaSayfaPage.anasayfaRoomsButon.click();
        Driver.getDriver().navigate().back();
        Assert.assertTrue(anaSayfaPage.anasayfaRestaurantButon.isDisplayed());
        anaSayfaPage.anasayfaRestaurantButon.click();
        Driver.getDriver().navigate().back();
        Assert.assertTrue(anaSayfaPage.anasayfaAboutButon.isDisplayed());
        anaSayfaPage.anasayfaAboutButon.click();
        Driver.getDriver().navigate().back();
        Assert.assertTrue(anaSayfaPage.anasayfaContactButon.isDisplayed());
        anaSayfaPage.anasayfaContactButon.click();
        Driver.getDriver().navigate().back();
        Driver.closeDriver();
    }
}
