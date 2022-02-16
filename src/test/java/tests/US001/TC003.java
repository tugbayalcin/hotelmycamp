package tests.US001;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC003 {

    @Test
    public void testCase3() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
        RoomReservationsPage roomReservationsPage = new RoomReservationsPage();
        LoginPage loginPage = new LoginPage();
        anaSayfaPage.mainLoginLinki.click();
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("KullaniciUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("KullaniciPassword"));
        loginPage.GirisLoginButon.click();
        anaSayfaPage.anaSayfaHomeButon.click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", anaSayfaPage.anasayfaWelcomeToOurHotelYazisi);
        Thread.sleep(1500);
        Assert.assertTrue(anaSayfaPage.anasayfaWelcomeToOurHotelYazisi.isDisplayed());
        js.executeScript("arguments[0].scrollIntoView(true);", anaSayfaPage.anasayfaWiewRoomDetails1);
        Thread.sleep(1500);
        Assert.assertTrue(anaSayfaPage.anasayfaWiewRoomDetails1.isDisplayed());
        js.executeScript("arguments[0].scrollIntoView(true);", anaSayfaPage.anasayfaWiewRoomDetails2);
        Thread.sleep(1500);
        Assert.assertTrue(anaSayfaPage.anasayfaWiewRoomDetails2.isDisplayed());
        js.executeScript("arguments[0].scrollIntoView(true);", anaSayfaPage.anasayfaWiewRoomDetails3);
        Thread.sleep(1500);
        Assert.assertTrue(anaSayfaPage.anasayfaWiewRoomDetails3.isDisplayed());
        js.executeScript("arguments[0].scrollIntoView(true);", anaSayfaPage.anasayfaMisafirYorumlari);
        Thread.sleep(1500);
        Assert.assertTrue(anaSayfaPage.anasayfaMisafirYorumlari.isDisplayed());

        Driver.closeDriver();
    }

}
