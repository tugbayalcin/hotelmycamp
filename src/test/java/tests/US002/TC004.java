package tests.US002;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC004 extends TestBaseRapor {

    @Test
    public void testCase4() throws InterruptedException {

        extentTest=extentReports.createTest("TC004","Yanlış username ve password ile  giriş yapılmamalı");

        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
        LoginPage loginPage = new LoginPage();
        anaSayfaPage.mainLoginLinki.click();
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("WrongUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("WrongPassword"));
        loginPage.GirisLoginButon.click();
        Assert.assertTrue(loginPage.TryAgainPlease.isDisplayed());

        extentTest.pass("Yanlış username ve password ile giriş yapılmadı");

        //Driver.closeDriver();



    }
}
