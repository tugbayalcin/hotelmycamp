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
import utilities.TestBaseRapor;

public class TC003 extends TestBaseRapor {

    @Test
    public void testCase3() throws InterruptedException {
        extentTest=extentReports.createTest("TC003","Welcome to hotel bölümü,Our Rooms ve içerisindeki elementler gorunur olmali.");
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
        RoomReservationsPage roomReservationsPage = new RoomReservationsPage();
        LoginPage loginPage = new LoginPage();
        anaSayfaPage.mainLoginLinki.click();
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("KullaniciUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("KullaniciPassword"));
        loginPage.GirisLoginButon.click();
        extentTest.info("Giris yapildi");
        anaSayfaPage.anaSayfaHomeButon.click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", anaSayfaPage.anasayfaWelcomeToOurHotelYazisi);
        Thread.sleep(1500);
        Assert.assertTrue(anaSayfaPage.anasayfaWelcomeToOurHotelYazisi.isDisplayed());
        extentTest.pass("Welcome To Our Hotel yazisi goruntulendi");
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
        extentTest.pass("Misafir yorumlari goruntulendi");

        Driver.closeDriver();
    }

}
