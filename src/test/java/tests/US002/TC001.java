package tests.US002;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC001 extends TestBaseRapor {

    @Test
    public void testCase1() throws InterruptedException {

        extentTest=extentReports.createTest("TC001","Log in Sayfası görüntüleme");


        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));

        AnaSayfaPage anaSayfaPage=new AnaSayfaPage();
        LoginPage loginPage=new LoginPage();

        anaSayfaPage.mainLoginLinki.click();

        Assert.assertTrue(loginPage.LoginUsernameBox.isDisplayed());

        Assert.assertTrue(loginPage.LoginPasswordBox.isDisplayed());

        Assert.assertTrue(loginPage.GirisLoginButon.isDisplayed());

        Assert.assertTrue(loginPage.CreateNewAccountButonu.isDisplayed());

        extentTest.pass("Log in sayfası görüntülendi");

        //Driver.closeDriver();

    }
}
