package tests.US001;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC005 extends TestBaseRapor {


    @Test
    public void testCase5() {
        extentTest=extentReports.createTest("TC005","Footer elementler tiklanmali");
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
        js.executeScript("arguments[0].scrollIntoView(true);", anaSayfaPage.anasayfaFooter);
        Assert.assertTrue(anaSayfaPage.anasayfaFooter.isDisplayed());
        extentTest.pass("Footer elementler goruntulendi");
        anaSayfaPage.anasayfaFooterCareer.click();
        extentTest.info("Career tiklandi");
        Driver.getDriver().navigate().back();
        anaSayfaPage.anasayfaFooterAboutUs.click();
        extentTest.info("About Us tiklandi");
        Driver.getDriver().navigate().back();
        anaSayfaPage.anasayfaFooterContactUs.click();
        extentTest.info("Contact Us tiklandi");
        Driver.getDriver().navigate().back();
        anaSayfaPage.anasayfaFooterServices.click();
        extentTest.info("Services tiklandi");
        Driver.getDriver().navigate().back();

        Driver.closeDriver();

    }

}
