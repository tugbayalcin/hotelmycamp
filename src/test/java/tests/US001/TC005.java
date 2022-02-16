package tests.US001;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC005 {


    @Test
    public void testCase5() {

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
        js.executeScript("arguments[0].scrollIntoView(true);", anaSayfaPage.anasayfaFooter);
        Assert.assertTrue(anaSayfaPage.anasayfaFooter.isDisplayed());
        anaSayfaPage.anasayfaFooterCareer.click();
        Driver.getDriver().navigate().back();
        anaSayfaPage.anasayfaFooterAboutUs.click();
        Driver.getDriver().navigate().back();
        anaSayfaPage.anasayfaFooterContactUs.click();
        Driver.getDriver().navigate().back();
        anaSayfaPage.anasayfaFooterServices.click();
        Driver.getDriver().navigate().back();

        Driver.closeDriver();

    }

}
