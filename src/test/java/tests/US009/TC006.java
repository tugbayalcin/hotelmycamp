package tests.US009;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.ObjectInitialiser.*;

public class TC006 extends TestBaseRapor {

    @Test
    public void testCase6() {
        extentTest=extentReports.createTest("TC006","Hatali sifre ve dogru kullanici adi ile giris yapilmamali");
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        anaSayfaPage.mainLoginLinki.click();
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("WrongPassword"));
        extentTest.info("Hatali password girildi");
        loginPage.GirisLoginButon.click();
        Assert.assertTrue(roomReservationsPage.girisYapilamadiYazisi.isDisplayed());
        extentTest.pass("Hatali password ile giris yapilamadigi goruntulendi");

   //     Driver.closeDriver();
    }

}
