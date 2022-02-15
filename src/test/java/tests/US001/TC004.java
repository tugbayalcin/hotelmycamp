package tests.US001;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC004 {

    @Test
    public void testCase5() throws InterruptedException {

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
        js.executeScript("arguments[0].scrollIntoView(true);", anaSayfaPage.anasayfaRecentBlogBaslik);
        Thread.sleep(1500);
        Assert.assertTrue(anaSayfaPage.anasayfaRecentBlogBaslik.isDisplayed());
        anaSayfaPage.anasayfaRecentBlogElementi1.click();
        Driver.getDriver().navigate().back();
        anaSayfaPage.anasayfaRecentBlogElementi2.click();
        Driver.getDriver().navigate().back();
        anaSayfaPage.anasayfaRecentBlogElementi3.click();
        Driver.getDriver().navigate().back();
        anaSayfaPage.anasayfaRecentBlogElementi4.click();
        Driver.getDriver().navigate().back();
        js.executeScript("arguments[0].scrollIntoView(true);", anaSayfaPage.anasayfaInstagramBaslik);
        Thread.sleep(2000);
        Assert.assertTrue(anaSayfaPage.anasayfaInstagramBaslik.isDisplayed());
        Thread.sleep(2000);
        anaSayfaPage.anasayfaInstagramFotograf2.click();

        Driver.closeDriver();
    }

}
