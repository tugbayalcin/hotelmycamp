package tests.US002;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC003 extends TestBaseRapor {


    @Test
    public void testCase3() throws InterruptedException {

        extentTest=extentReports.createTest("TC003","Eksik bilgilerle giriş yapılmamalı");

        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));

        AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
        LoginPage loginPage = new LoginPage();

        anaSayfaPage.mainLoginLinki.click();
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        loginPage.GirisLoginButon.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(loginPage.ThisFieldIsRequired.isDisplayed());

        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);

        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("ManagerPassword"));
        ReusableMethods.waitFor(2);
        loginPage.GirisLoginButon.click();
        Assert.assertTrue(loginPage.ThisFieldIsRequired.isDisplayed());

        extentTest.pass("Eksik bilgilerle giriş yapılmadı");

        //Driver.closeDriver();




    }
}
