package tests.US009;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.ObjectInitialiser.*;

public class TC005 extends TestBaseRapor {


    @Test
    public void testCase5() {
        extentTest=extentReports.createTest("TC005","Hatali kullanici adi ve dogru sifre ile giris yapilmamali");
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        LoginPage loginPage = new LoginPage();
        anaSayfaPage.mainLoginLinki.click();
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("WrongUsername"));
        extentTest.info("Hatali kullanici adi girildi");
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("ManagerPassword"));
        loginPage.GirisLoginButon.click();
        Assert.assertTrue(roomReservationsPage.girisYapilamadiYazisi.isDisplayed());
        extentTest.pass("Hatali kullanici adi ile giris yapilamadigi goruntulendi");
    //    Driver.closeDriver();
    }

}
